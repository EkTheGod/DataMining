package com.example.ekachart.datamining;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Ekachart on 8/11/2558.
 */
public class empty extends Activity {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    private String rcv1,rcv2,rcv3,rcv4,rcv5,rcv6,rcv7,rcv8,rcv9,rcv10,rcv11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        rcv1 = getIntent().getStringExtra("No1");
        rcv2 = getIntent().getStringExtra("No2");
        rcv3 = getIntent().getStringExtra("No3");
        rcv4 = getIntent().getStringExtra("No4");
        rcv5 = getIntent().getStringExtra("No5");
        rcv6 = getIntent().getStringExtra("No6");
        rcv7 = getIntent().getStringExtra("No7");
        rcv8 = getIntent().getStringExtra("No8");
        rcv9 = getIntent().getStringExtra("No9");
        rcv10 = getIntent().getStringExtra("No10");
        rcv11 = getIntent().getStringExtra("No11");

        t1 = (TextView) findViewById(R.id.show1);
        t1.setText(rcv1);
        t2 = (TextView) findViewById(R.id.show2);
        t2.setText(rcv2);
        t3 = (TextView) findViewById(R.id.show3);
        t3.setText(rcv3);
        t4 = (TextView) findViewById(R.id.show4);
        t4.setText(rcv4);
        t5 = (TextView) findViewById(R.id.show5);
        t5.setText(rcv5);
        t6 = (TextView) findViewById(R.id.show6);
        t6.setText(rcv6);
        t7 = (TextView) findViewById(R.id.show7);
        t7.setText(rcv7);
        t8 = (TextView) findViewById(R.id.show8);
        t8.setText(rcv8);
        t9 = (TextView) findViewById(R.id.show9);
        t9.setText(rcv9);
        t10 = (TextView) findViewById(R.id.show10);
        t10.setText(rcv10);
        t11 = (TextView) findViewById(R.id.show11);
        t11.setText(rcv11);
    }
}