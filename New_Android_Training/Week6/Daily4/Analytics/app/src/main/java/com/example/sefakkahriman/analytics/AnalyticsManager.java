package com.example.sefakkahriman.analytics;

import android.content.Context;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class AnalyticsManager {

    public static class Events {
        public static final String RUN = "run";
        public static final String JUMP = "jump";
        public static final String SKYDIVE = "skydive";
        public static final String SWIM = "swim";
        public static final String LOAD_IMAGE = "load_image";
    }

    MixpanelAPI mixpanelAPI;

    public static final String TOKEN = "9130fc93354ac0257c58efb0496ababf";

    public AnalyticsManager(Context context) {
        this.mixpanelAPI = MixpanelAPI.getInstance(context, TOKEN);
    }

    public void trackTimeEvent(Event event) {
        if (event.getName().equals(Events.LOAD_IMAGE)) {
            mixpanelAPI.track(event.getName());
        } else {
            mixpanelAPI.track(event.getName(), event.getProps());
        }
    }

    public void timeEvent(Event event) {

        mixpanelAPI.timeEvent(event.getName());

    }
}
