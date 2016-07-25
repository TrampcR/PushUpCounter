package com.trampcr.pushupcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtNumber;
    private Button mBtnStart;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtNumber = (EditText) findViewById(R.id.et_number);
        mBtnStart = (Button) findViewById(R.id.btn_start);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = mEtNumber.getText().toString();
                if (number != null) {
                    Intent intent = new Intent(MainActivity.this, PushUpsActivity.class);
                    intent.putExtra("number", number);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "训练目标不能为空", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
