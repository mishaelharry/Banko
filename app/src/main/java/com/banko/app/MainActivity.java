package com.banko.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCenter.start(getApplication(), "6aa4b968-bd19-4629-b590-7913cd7d0fe1", Analytics.class, Crashes.class);

        findViewById(R.id.test_crash)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Analytics.trackEvent("Test Crash button clicked");
                        testCrash();
                    }
                });
    }


    public void testCrash(){
        throw new RuntimeException("This is a test crash");
    }
}
