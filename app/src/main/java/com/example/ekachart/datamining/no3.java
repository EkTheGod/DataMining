package com.example.ekachart.datamining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ekachart on 12/11/2558.
 */
public class no3 extends Activity {
    private Spinner spin;
    private Boolean c4 = false;
    private Button next,back;
    private String No1 ="",No2="",No3="";
    private TextView num,text;
    private RadioButton r1,r2,r3,r4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no3);
        init();
        setFont();
        getvalue();
        addListSpinner();
        buttonClick();
    }

    private void setFont() {
        final Typeface type = Typeface.createFromAsset(getAssets(), "SukhumvitSet.ttc");
        num.setTypeface(type);  text.setTypeface(type);
        next.setTypeface(type); back.setTypeface(type);
        r1.setTypeface(type);   r2.setTypeface(type);
        r3.setTypeface(type);   r4.setTypeface(type);
    }

    private void getvalue() {
        No1 = getIntent().getStringExtra("No1");
        No2 = getIntent().getStringExtra("No2");
    }

    private void init() {
        num = (TextView) findViewById(R.id.num);
        text = (TextView) findViewById(R.id.text);
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        spin = (Spinner)findViewById(R.id.spinner34);
        spin.setVisibility(View.GONE);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);
        r4 = (RadioButton)findViewById(R.id.r4);
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

                if(c4)
                    No3 = String.valueOf(spin.getSelectedItem());

                Intent sentopage = new Intent(getBaseContext(), no4.class);
                sentopage.putExtra("No1",No1);
                sentopage.putExtra("No2",No2);
                sentopage.putExtra("No3",No3);

                if(No3=="")
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
                Intent i = new Intent(getApplicationContext(), no2.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.r1:
                if (checked) {
                    spin.setVisibility(View.GONE);
                    No3 = "1";
                    c4 = false;
                }
                break;
            case R.id.r2:
                if (checked) {
                    spin.setVisibility(View.GONE);
                    No3 = "2";
                    c4 = false;
                }
                break;
            case R.id.r3:
                if (checked) {
                    spin.setVisibility(View.GONE);
                    No3 = "3";
                    c4 = false;
                }
                break;
            case R.id.r4:
                if (checked) {
                    spin.setVisibility(View.VISIBLE);
                    c4 = true;
                }
        }
    }

    private void addListSpinner() {
        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("");
        mylist.add("1");
        mylist.add("2");
        mylist.add("3");
        mylist.add("4");
        mylist.add("5");
        mylist.add("6");
        mylist.add("7");
        ArrayAdapter<String> myadap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mylist);
        myadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(myadap);
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
