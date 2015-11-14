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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ekachart on 12/11/2558.
 */
public class no4 extends Activity {
    private Button next,back;
    private Spinner spin;
    private String No1 ="",No2="",No3="",No4="";
    private TextView num,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no4);
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
    }

    private void getvalue() {
        No1 = getIntent().getStringExtra("No1");
        No2 = getIntent().getStringExtra("No2");
        No3 = getIntent().getStringExtra("No3");
    }

    private void init() {
        num = (TextView) findViewById(R.id.num);
        text = (TextView) findViewById(R.id.text);
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        spin = (Spinner)findViewById(R.id.spinner4);
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

                Intent sentopage = new Intent(getBaseContext(), no5.class);
                sentopage.putExtra("No1",No1);
                sentopage.putExtra("No2",No2);
                sentopage.putExtra("No3",No3);
                No4 = String.valueOf(spin.getSelectedItem());
                sentopage.putExtra("No4",No4);

                if(No4.equals("กรุณาเลือก"))
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
                Intent i = new Intent(getApplicationContext(), no3.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void addListSpinner() {
        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("กรุณาเลือก");
        mylist.add("1");
        mylist.add("2");
        mylist.add("3");
        mylist.add("4");
        mylist.add("5");
        mylist.add("6");
        mylist.add("7");
        ArrayAdapter<String> myadap = new ArrayAdapter<String>(this,R.layout.spinner,mylist);
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
