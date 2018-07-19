package com.example.sefakkahriman.makingrestcalls.client;

import android.util.Log;

import com.example.sefakkahriman.makingrestcalls.model.APIResponse;
import com.example.sefakkahriman.makingrestcalls.model.CustomUser;
import com.example.sefakkahriman.makingrestcalls.model.Result;
import com.example.sefakkahriman.makingrestcalls.utils.RxUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.sefakkahriman.makingrestcalls.client.NativeCallHelper.TAG;


public class RetrofitHelper {

    private static final String BASE_URL = "https://randomuser.me/";

    private Call<APIResponse> getUsers(String results) {
        Retrofit retrofit = createClient();
        Service service = retrofit.create(Service.class);
        return service.getUsers(results);
    }

    public Retrofit createClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava
                .build();
        return retrofit;
    }

    public void makeCallSync(final String results) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                APIResponse APIResponse = null;
                try {
                    APIResponse = getUsers(results).execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "run: "  + APIResponse.getResults().size());
            }
        }).start();
    }

    public void makeCallAsync(String results) {
        getUsers(results).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                APIResponse APIResponse = response.body();
                Log.d(TAG, "onResponse: " + APIResponse.getResults().size());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "  + t.toString());

            }
        });
    }

    //    using rxjava observable
    private Observable<APIResponse> getUsersRX(String results) {
        return createClient().create(Service.class).getUsersRx(results);
    }

    public void makeCallRxJava(String results) {
        getUsersRX(results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<APIResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(APIResponse APIResponse) {
                        Log.d(TAG, "onNext: " + Thread.currentThread().getName());
                        Log.d(TAG, "onNext: Response " + APIResponse.getResults().size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: " + Thread.currentThread().getName());

                    }
                });

    }

    public void makeCallCustomRx(String results, final RetrofitCallback callBack ) {
        getUsersRX(results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(RxUtils.getMappingFunction())
                .subscribe(new Observer<CustomUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CustomUser customUser) {
                        callBack.onResults(customUser);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }

    public void makeCallCustomRxJava(String results, final ListCallBack callBack){
        final List<Result> list = new ArrayList<>();
        getUsersRX(results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(RxUtils.getResultMapper())
                .map(RxUtils.tranformResult())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        list.add(result);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                        callBack.onResults(list);

                    }
                });

    }

    public interface RetrofitCallback {
        void onResults(CustomUser customUser);
    }

    public interface ListCallBack{

        void onResults(List<Result> resultList);
    }

    //    interface to use Http verbs
    interface Service{
        @GET("api")
        Call<APIResponse> getUsers(@Query("results") String results);
//        dynamic URL
//        @GET("{pathHolder}")

        @GET("api")
        Observable<APIResponse> getUsersRx(@Query("results") String results);


    }
}
