package com.example.ekachart.datamining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ekachart on 12/11/2558.
 */
public class no6 extends Activity {
    private Button next,back;
    private String No1 ="",No2="",No3="",No4="",No5="",No6="";
    private TextView num,text;
    private RadioButton r1,r2,r3,r4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no6);
        init();
        setFont();
        getvalue();
        buttonClick();
    }

    private void setFont() {
        final Typeface type = Typeface.createFromAsset(getAssets(), "SukhumvitSet.ttc");
        num.setTypeface(type);  text.setTypeface(type);
        r1.setTypeface(type);   r2.setTypeface(type);
        r3.setTypeface(type);   r4.setTypeface(type);
    }

    private void getvalue() {
        No1 = getIntent().getStringExtra("No1");
        No2 = getIntent().getStringExtra("No2");
        No3 = getIntent().getStringExtra("No3");
        No4 = getIntent().getStringExtra("No4");
        No5 = getIntent().getStringExtra("No5");
    }

    private void init() {
        num = (TextView) findViewById(R.id.num);
        text = (TextView) findViewById(R.id.text);
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);
        r4 = (RadioButton)findViewById(R.id.r4);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            //ข้อ 1
            case R.id.r1:
                if (checked) No6 = "1";
                break;
            case R.id.r2:
                if (checked) No6 = "2";
                break;
            case R.id.r3:
                if (checked) No6 = "3";
                break;
            case R.id.r4:
                if (checked) No6 = "4";
                break;
        }
    }

    private void buttonClick() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Toast toast = Toast.makeText(getApplicationContext(), "คุณยังไม่ตอบแบบสอบถาม",
                        Toast.LENGTH_SHORT);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);

                Intent sentopage = new Intent(getBaseContext(), no7.class);
                sentopage.putExtra("No1",No1);
                sentopage.putExtra("No2",No2);
                sentopage.putExtra("No3",No3);
                sentopage.putExtra("No4",No4);
                sentopage.putExtra("No5",No5);
                sentopage.putExtra("No6",No6);

                if(No6=="")
                   toast.show();
                else {

                    startActivity(sentopage);
                    finish();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), no5.class);
                startActivity(i);
                finish();
            }
        });
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
                finish();
            }
        }).show();
    }
}
