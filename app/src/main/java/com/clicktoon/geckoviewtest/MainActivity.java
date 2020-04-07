package com.clicktoon.geckoviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoSessionSettings;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends AppCompatActivity {
    GeckoView geckoView;
    GeckoSession geckoSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        geckoView = (GeckoView)findViewById(R.id.geckoView);
        GeckoSessionSettings.Builder builder = new GeckoSessionSettings.Builder();
        builder.usePrivateMode(true)
                .useTrackingProtection(true)
                .userAgentMode(GeckoSessionSettings.USER_AGENT_MODE_MOBILE)
                .userAgentOverride("")
                .suspendMediaWhenInactive(true)
                .allowJavascript(true);
        GeckoRuntime runtime = GeckoRuntime.create(MainActivity.this);
        geckoSession = new GeckoSession();
        geckoSession.open(runtime);

        geckoView.setSession(geckoSession);

        geckoSession.loadUri("http://m.webtoon.daum.net/");

    }
}
