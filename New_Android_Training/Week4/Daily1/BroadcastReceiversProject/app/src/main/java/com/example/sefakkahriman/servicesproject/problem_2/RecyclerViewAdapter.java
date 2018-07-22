package com.example.sefakkahriman.servicesproject.problem_2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.servicesproject.R;
import com.example.sefakkahriman.servicesproject.problem_3.MyBroadcastReceiver;

import java.util.List;

import static android.content.Context.ALARM_SERVICE;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Person> personList;
    Context context;

    public RecyclerViewAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.person_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Person person = personList.get(i);

        viewHolder.image.setBackgroundResource(person.getPictureID());

        viewHolder.name.setText(person.name);
        viewHolder.title.setText(person.title);
        viewHolder.type.setText(person.type);

        //This part for Listener
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "You clicked " + person.getName(), Toast.LENGTH_SHORT).show();
                int i = 5;

                Intent intent = new Intent(context, MyBroadcastReceiver.class);
                intent.putExtra("name", person.getName());
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        context.getApplicationContext(), 0, intent, 0);

                AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                        + (i * 1000), pendingIntent);
                Toast.makeText(context, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView title;
        private final TextView type;
        private final ImageView image;

        //This part for Listener
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            type = itemView.findViewById(R.id.type);
            image = itemView.findViewById(R.id.image);

            //This part for Listener
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }
    }
}