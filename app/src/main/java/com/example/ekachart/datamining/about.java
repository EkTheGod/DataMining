package com.example.ekachart.datamining;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Ekachart on 10/11/2558.
 */
public class about extends Activity {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        init();
        setFont();
    }

    private void init() {
        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView21);
        t6 = (TextView) findViewById(R.id.textView22);
        t7 = (TextView) findViewById(R.id.textView23);
        t8 = (TextView) findViewById(R.id.textView31);
        t9 = (TextView) findViewById(R.id.textView32);
        t10 = (TextView) findViewById(R.id.textView33);
        t11 = (TextView) findViewById(R.id.textView41);
        t12 = (TextView) findViewById(R.id.textView42);
        t13 = (TextView) findViewById(R.id.textView43);
        t14 = (TextView) findViewById(R.id.textView51);
        t15 = (TextView) findViewById(R.id.textView52);
        t16 = (TextView) findViewById(R.id.textView53);
    }

    private void setFont() {
        final Typeface type = Typeface.createFromAsset(getAssets(), "SukhumvitSet.ttc");
        t1.setTypeface(type); t2.setTypeface(type);
        t3.setTypeface(type); t4.setTypeface(type);
        t5.setTypeface(type); t6.setTypeface(type);
        t7.setTypeface(type); t8.setTypeface(type);
        t9.setTypeface(type); t10.setTypeface(type);
        t11.setTypeface(type); t12.setTypeface(type);
        t13.setTypeface(type); t14.setTypeface(type);
        t15.setTypeface(type); t16.setTypeface(type);
    }
}
