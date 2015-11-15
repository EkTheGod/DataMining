package com.example.ekachart.datamining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

        calDormitory();
        calHome();
        getResult();

        Toast.makeText(result.this, String.valueOf(sumdormitory),Toast.LENGTH_SHORT).show();
        Toast.makeText(result.this, String.valueOf(sumhome),Toast.LENGTH_SHORT).show();

        //home();
        buttonClick();


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
        if(sumdormitory > sumhome)  { t3.setText("หอ");  image.setBackground(this.getResources().getDrawable(R.drawable.hor1));}
        else                        { t3.setText("บ้าน");   t5.setText("เหมาะสำหรับอยู่บ้านค่ะ");}
    }


    private void calDormitory() {

        //no1
        double i1 = 1/(1.15155278*(Math.sqrt(2*Math.PI)));
        double i2 = Math.pow(2.718281828, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 2.27586207) / 1.15155278, 2));
        sumdormitory = sumdormitory + i1*i2;
        //Toast.makeText(result.this, String.valueOf(i2),Toast.LENGTH_SHORT).show();

        //no2
        if(rcv2.equals("1"))
            sumdormitory = sumdormitory+0.23333333 ;
        else
            sumdormitory = sumdormitory+0.76666667 ;

        //no3
        i1 = 1/(1.00573071*(Math.sqrt(2*Math.PI)));
        i2 = Math.pow(2.718281828, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 1.62068966) /1.00573071, 2));
        sumdormitory = sumdormitory + i1*i2;

        //no4
        i1 = 1/(0.82019283*(Math.sqrt(2*Math.PI)));
        i2 = Math.pow(2.718281828, (-0.5) * Math.pow((Double.parseDouble(rcv1) -4.44827586) /0.82019283, 2));
        sumdormitory = sumdormitory + i1*i2;

        //no5
        if(rcv5.equals("1"))
            sumdormitory = sumdormitory + 0.27868852 ;
        if(rcv5.equals("2"))
            sumdormitory = sumdormitory + 0.26229508 ;
        if(rcv5.equals("3"))
            sumdormitory = sumdormitory + 0.45901639 ;

        //no6
        if(rcv6.equals("1"))
            sumdormitory = sumdormitory + 0.06451613 ;
        if(rcv6.equals("2"))
            sumdormitory = sumdormitory + 0.32258065 ;
        if(rcv6.equals("3"))
            sumdormitory = sumdormitory + 0.33870968 ;
        if(rcv6.equals("4"))
            sumdormitory = sumdormitory + 0.27419355 ;

        //no7
        if(rcv7.equals("1"))
            sumdormitory = sumdormitory+0.015625     ;
        if(rcv7.equals("2"))
            sumdormitory = sumdormitory+0.015625   ;
        if(rcv7.equals("3"))
            sumdormitory = sumdormitory+0.078125   ;
        if(rcv7.equals("4"))
            sumdormitory = sumdormitory+0.25     ;
        if(rcv7.equals("5"))
            sumdormitory = sumdormitory+0.359375  ;
        if(rcv7.equals("6"))
            sumdormitory = sumdormitory+0.28125   ;

        //no8
        if(rcv8.equals("1"))
            sumdormitory = sumdormitory+0.06153846   ;
        if(rcv8.equals("2"))
            sumdormitory = sumdormitory+0.23076923   ;
        if(rcv8.equals("3"))
            sumdormitory = sumdormitory+0.16923077   ;
        if(rcv8.equals("4"))
            sumdormitory = sumdormitory+0.15384615   ;
        if(rcv8.equals("5"))
            sumdormitory = sumdormitory+0.09230769   ;
        if(rcv8.equals("6"))
            sumdormitory = sumdormitory+0.06153846   ;
        if(rcv8.equals("7"))
            sumdormitory = sumdormitory+0.23076923   ;

        //no9
        if(rcv9.equals("1"))
            sumdormitory = sumdormitory+0.35  ;
        if(rcv9.equals("2"))
            sumdormitory = sumdormitory+0.65  ;

    }

    private void calHome() {

        //no1
        double i1 = 1/(1.16057957*(Math.sqrt(2*Math.PI)));
        double i2 = Math.pow(2.718281828, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 2.32758621) / 1.16057957, 2));
        sumhome = sumhome + i1*i2;
        //Toast.makeText(result.this, String.valueOf(i2),Toast.LENGTH_SHORT).show();

        //no2
        if(rcv2.equals("1"))
            sumhome = sumhome+0.33333333 ;
        else
            sumhome = sumhome+0.66666667 ;

        //no3
        i1 = 1/(0.92635669*(Math.sqrt(2*Math.PI)));
        i2 = Math.pow(2.718281828, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 1.81034483) / 0.92635669, 2));
        sumhome = sumhome + i1*i2;

        //no4
        i1 = 1/(.67381228*(Math.sqrt(2*Math.PI)));
        i2 = Math.pow(2.718281828, (-0.5) * Math.pow((Double.parseDouble(rcv1) - 4.39655172) / .67381228, 2));
        sumhome = sumhome + i1*i2;

        //no5
        if(rcv5.equals("1"))
            sumhome = sumhome + 0.81967213 ;
        if(rcv5.equals("2"))
            sumhome = sumhome + 0.14754098 ;
        if(rcv5.equals("3"))
            sumhome = sumhome + 0.03278689 ;

        //no6
        if(rcv6.equals("1"))
            sumhome = sumhome + 0.09677419 ;
        if(rcv6.equals("2"))
            sumhome = sumhome + 0.61290323 ;
        if(rcv6.equals("3"))
            sumhome = sumhome + 0.19354839 ;
        if(rcv6.equals("4"))
            sumhome = sumhome + 0.09677419 ;

        //no7
        if(rcv7.equals("1"))
            sumhome = sumhome+0.140625     ;
        if(rcv7.equals("2"))
            sumhome = sumhome+0.359375     ;
        if(rcv7.equals("3"))
            sumhome = sumhome+0.3750   ;
        if(rcv7.equals("4"))
            sumhome = sumhome+0.0625       ;
        if(rcv7.equals("5"))
            sumhome = sumhome+0.015625     ;
        if(rcv7.equals("6"))
            sumhome = sumhome+0.046875      ;

        //no8
        if(rcv8.equals("1"))
            sumhome = sumhome+0.35384615   ;
        if(rcv8.equals("2"))
            sumhome = sumhome+0.38461538   ;
        if(rcv8.equals("3"))
            sumhome = sumhome+0.13846154   ;
        if(rcv8.equals("4"))
            sumhome = sumhome+0.04615385   ;
        if(rcv8.equals("5"))
            sumhome = sumhome+0.03076923   ;
        if(rcv8.equals("6"))
            sumhome = sumhome+0.03076923   ;
        if(rcv8.equals("7"))
            sumhome = sumhome+0.01538462   ;

        //no9
        if(rcv9.equals("1"))
            sumhome = sumhome+0.51666667  ;
        if(rcv9.equals("2"))
            sumhome = sumhome+0.48333333  ;
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("ออกจากแบบสอบถาม");
        dialog.setPositiveButton("ยกเลิก",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.setNegativeButton("ตกลง",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent j = new Intent(getApplicationContext(), delayed.class);
                startActivity(j);
                finish();
            }
        }).show();
    }

}
