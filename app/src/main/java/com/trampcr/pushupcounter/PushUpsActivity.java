package com.trampcr.pushupcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by zxm on 2016/7/25.
 */
public class PushUpsActivity extends AppCompatActivity {

    private Button mBtnStop;

    public static String number = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = getIntent().getStringExtra("number");
        setContentView(R.layout.activity_pushups);
        mBtnStop = (Button) findViewById(R.id.btn_stop);

        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PushUpsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
