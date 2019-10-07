package com.jorgeluis.zombierpg;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new ZombieGame(), config);
        FirebaseAnalytics fa = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putFloat("OMG", 23f);
        fa.logEvent(FirebaseAnalytics.Event.LEVEL_UP, bundle);
    }
}
