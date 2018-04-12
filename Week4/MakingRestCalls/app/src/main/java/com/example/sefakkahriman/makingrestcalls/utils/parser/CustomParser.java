package com.example.sefakkahriman.makingrestcalls.utils.parser;


import android.util.Log;

import com.example.sefakkahriman.makingrestcalls.model.GithubProfile;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class CustomParser {

    public static void parse(String className, String response) throws JSONException {

        switch (className) {
            case "GITHUBPROFILE":

                GithubProfile githubProfile = new GithubProfile();
                JSONObject jsonObject = new JSONObject(response);
                String name = jsonObject.getString("name");
                githubProfile.setName(name);
                Log.d(TAG, "parse: " + githubProfile.toString());

                break;

        }
    }
}