package com.example.ekachart.datamining;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ekachart on 8/11/2558.
 */
public class result extends Activity {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    private String rcv1,rcv2,rcv3,rcv4,rcv5,rcv6,rcv7,rcv8,rcv9;
    private Button retry,home;
    private ImageView image;
    private double no1,no2,no3,no4,no5,no6,no7,no8,no9;
    private double sumdormitory = 0 ,  sumhome=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result2);
        getvalue();
        setFont();

        //calDormitory();
        //calHome();
        //getResult();

        buttonClick();
        home();

    }

    private void buttonClick() {
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), no1.class);
                startActivity(i);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), delayed.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void home() {
        if(rcv7.equals("1"))    { t3.setText("บ้าน");   t5.setText("เหมาะสำหรับอยู่บ้านค่ะ"); }
        if(rcv7.equals("2"))    { t3.setText("บ้าน");   t5.setText("เหมาะสำหรับอยู่บ้านค่ะ"); }
        if(rcv7.equals("3"))    { t3.setText("บ้าน");   t5.setText("เหมาะสำหรับอยู่บ้านค่ะ"); }
        if(rcv7.equals("4"))    { t3.setText("หอ");  image.setBackground(this.getResources().getDrawable(R.drawable.hor1));}
        if(rcv7.equals("5"))    { t3.setText("หอ");  image.setBackground(this.getResources().getDrawable(R.drawable.hor1));}
        if(rcv7.equals("6"))    { t3.setText("หอ");  image.setBackground(this.getResources().getDrawable(R.drawable.hor1));}
    }

    private void setFont() {
        final Typeface type = Typeface.createFromAsset(getAssets(), "SukhumvitSet.ttc");
        t1.setTypeface(type);   t3.setTypeface(type);
        t2.setTypeface(type);   t4.setTypeface(type);
        t5.setTypeface(type);
        retry.setTypeface(type);   home.setTypeface(type);
    }

    private void getvalue() {
        rcv1 = getIntent().getStringExtra("No1");
        rcv2 = getIntent().getStringExtra("No2");
        rcv3 = getIntent().getStringExtra("No3");
        rcv4 = getIntent().getStringExtra("No4");
        rcv5 = getIntent().getStringExtra("No5");
        rcv6 = getIntent().getStringExtra("No6");
        rcv7 = getIntent().getStringExtra("No7");
        rcv8 = getIntent().getStringExtra("No8");
        rcv9 = getIntent().getStringExtra("No9");

        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);
        t4 = (TextView) findViewById(R.id.text4);
        t5 = (TextView) findViewById(R.id.text5);
        image = (ImageView)findViewById(R.id.imageView);
        retry = (Button)findViewById(R.id.retry);
        home = (Button)findViewById(R.id.home);
    }

    private void getResult() {
        if(sumdormitory > sumhome)
            t10.setText("อยู่หอเถอะ");
        else
            t10.setText("กลับบ้านไป๋");
    }


    private void calDormitory() {

        //no1
        double i1 = 1/(1.1516*(Math.sqrt(2*Math.PI)));
        double i2 = Math.pow(2.7183, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 2.2759) / 1.1516, 2));
        sumdormitory = sumdormitory + i1*i2;
        //Toast.makeText(result.this, String.valueOf(i2),Toast.LENGTH_SHORT).show();

        //no2
        if(rcv2=="1")
            sumdormitory = sumdormitory+0.2333 ;
        else
            sumdormitory = sumdormitory+0.7667 ;

        //no3
        i1 = 1/(1.0057*(Math.sqrt(2*Math.PI)));
        i2 = Math.pow(2.7183, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 1.6207) / 1.0057, 2));
        sumdormitory = sumdormitory + i1*i2;

        //no4
        i1 = 1/(0.8202*(Math.sqrt(2*Math.PI)));
        i2 = Math.pow(2.7183, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 4.4483) / 0.8202, 2));
        sumdormitory = sumdormitory + i1*i2;

        //no5
        if(rcv5=="1")
            sumdormitory = sumdormitory + 0.2787 ;
        if(rcv5=="2")
            sumdormitory = sumdormitory + 0.2623 ;
        if(rcv5=="3")
            sumdormitory = sumdormitory + 0.4590 ;

        //no6
        if(rcv6=="1")
            sumdormitory = sumdormitory + 0.0645 ;
        if(rcv6=="2")
            sumdormitory = sumdormitory + 0.3226 ;
        if(rcv6=="3")
            sumdormitory = sumdormitory + 0.3387 ;
        if(rcv6=="4")
            sumdormitory = sumdormitory + 0.2742 ;

        //no7
        if(rcv7=="1")
            sumdormitory = sumdormitory+0.0156   ;
        if(rcv7=="2")
            sumdormitory = sumdormitory+0.0156   ;
        if(rcv7=="3")
            sumdormitory = sumdormitory+0.0781   ;
        if(rcv7=="4")
            sumdormitory = sumdormitory+0.25     ;
        if(rcv7=="5")
            sumdormitory = sumdormitory+0.3594   ;
        if(rcv7=="6")
            sumdormitory = sumdormitory+0.2813   ;

        //no8
        if(rcv8=="1")
            sumdormitory = sumdormitory+0.0615   ;
        if(rcv8=="2")
            sumdormitory = sumdormitory+0.2308   ;
        if(rcv8=="3")
            sumdormitory = sumdormitory+0.1692   ;
        if(rcv8=="4")
            sumdormitory = sumdormitory+0.1538   ;
        if(rcv8=="5")
            sumdormitory = sumdormitory+0.0923   ;
        if(rcv8=="6")
            sumdormitory = sumdormitory+0.0615   ;
        if(rcv8=="7")
            sumdormitory = sumdormitory+0.2308   ;

        //no9
        if(rcv9=="1")
            sumdormitory = sumdormitory+0.35  ;
        if(rcv9=="2")
            sumdormitory = sumdormitory+0.65  ;

    }

    private void calHome() {

        //no1
        double i1 = 1/(1.1606*(Math.sqrt(2*Math.PI)));
        double i2 = Math.pow(2.7183, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 2.3276) / 1.1606, 2));
        sumhome = sumhome + i1*i2;
        //Toast.makeText(result.this, String.valueOf(i2),Toast.LENGTH_SHORT).show();

        //no2
        if(rcv2=="1")
            sumhome = sumhome+0.3333 ;
        else
            sumhome = sumhome+0.6666 ;

        //no3
        i1 = 1/(0.9264*(Math.sqrt(2*Math.PI)));
        i2 = Math.pow(2.7183, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 1.8103) / 0.9264, 2));
        sumhome = sumhome + i1*i2;

        //no4
        i1 = 1/(0.6738*(Math.sqrt(2*Math.PI)));
        i2 = Math.pow(2.7183, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 4.3965) / 0.6738, 2));
        sumhome = sumhome + i1*i2;

        //no5
        if(rcv5=="1")
            sumhome = sumhome + 0.8196 ;
        if(rcv5=="2")
            sumhome = sumhome + 0.1475 ;
        if(rcv5=="3")
            sumhome = sumhome + 0.0327 ;

        //no6
        if(rcv6=="1")
            sumhome = sumhome + 0.0967 ;
        if(rcv6=="2")
            sumhome = sumhome + 0.6129 ;
        if(rcv6=="3")
            sumhome = sumhome + 0.1935 ;
        if(rcv6=="4")
            sumhome = sumhome + 0.0967 ;

        //no7
        if(rcv7=="1")
            sumhome = sumhome+0.1406   ;
        if(rcv7=="2")
            sumhome = sumhome+0.3593   ;
        if(rcv7=="3")
            sumhome = sumhome+0.3750   ;
        if(rcv7=="4")
            sumhome = sumhome+0.0625   ;
        if(rcv7=="5")
            sumhome = sumhome+0.0156   ;
        if(rcv7=="6")
            sumhome = sumhome+0.0468    ;

        //no8
        if(rcv8=="1")
            sumhome = sumhome+0.3538   ;
        if(rcv8=="2")
            sumhome = sumhome+0.3846   ;
        if(rcv8=="3")
            sumhome = sumhome+0.1384   ;
        if(rcv8=="4")
            sumhome = sumhome+0.0461   ;
        if(rcv8=="5")
            sumhome = sumhome+0.0307   ;
        if(rcv8=="6")
            sumhome = sumhome+0.0307   ;
        if(rcv8=="7")
            sumhome = sumhome+0.0153   ;

        //no9
        if(rcv9=="1")
            sumhome = sumhome+0.5167  ;
        if(rcv9=="2")
            sumhome = sumhome+0.4833  ;

    }

}
