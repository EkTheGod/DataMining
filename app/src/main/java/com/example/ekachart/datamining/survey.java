package com.example.ekachart.datamining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ekachart on 8/11/2558.
 */
public class survey extends Activity {
    private RadioGroup radio1,radio2,radio3,radio5,radio6,radio7,radio8,radio9;
    private Spinner spin;
    private EditText edit34;
    private Button show,reset;
    private String No1 ="",No2="",No3="",No4="",No5="",No6="",No7="",No8="",No9="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);

        init();
        buttonshow();
        buttonreset();
        addListSpinner();

    }


    private void init() {
        show = (Button) findViewById(R.id.show);
        reset = (Button) findViewById(R.id.reset);
        spin = (Spinner) findViewById(R.id.spinner4);
        edit34 = (EditText)findViewById(R.id.editText34);
        edit34.setVisibility(View.GONE);
        radio1 =  (RadioGroup)findViewById(R.id.radio1);
        radio2 =  (RadioGroup)findViewById(R.id.radio2);
        radio3 =  (RadioGroup)findViewById(R.id.radio3);
        radio5 =  (RadioGroup)findViewById(R.id.radio5);
        radio6 =  (RadioGroup)findViewById(R.id.radio6);
        radio7 =  (RadioGroup)findViewById(R.id.radio7);
        radio8 =  (RadioGroup)findViewById(R.id.radio8);
        radio9 =  (RadioGroup)findViewById(R.id.radio9);

    }

    private void buttonshow() {
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sentopage = new Intent(getApplicationContext(), result.class);
                sentopage.putExtra("No1",No1);
                sentopage.putExtra("No2", No2);
                sentopage.putExtra("No3", No3);
                No4 = String.valueOf(spin.getSelectedItem());
                sentopage.putExtra("No4",No4);
                sentopage.putExtra("No5",No5);
                sentopage.putExtra("No6",No6);
                sentopage.putExtra("No7",No7);
                sentopage.putExtra("No8",No8);
                sentopage.putExtra("No9", No9);

                if(No1=="") //|| No2=="" || No3=="" || No4=="" || No5=="" || No6=="" || No7=="" || No8=="" || No9=="")
                    Toast.makeText(survey.this, "คุณยังทำแบบทดสอบไม่ครบ", Toast.LENGTH_SHORT).show();
                else
                    startActivity(sentopage);
            }
        });
    }


    private void buttonreset() {
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radio1.clearCheck();
                No1 = "";
                radio2.clearCheck();
                No2 = "";
                radio3.clearCheck();
                No3 = "";
                edit34.setText("");
                radio5.clearCheck();
                No5 = "";
                radio6.clearCheck();
                No6 = "";
                radio7.clearCheck();
                No7 = "";
                radio8.clearCheck();
                No8 = "";
                radio9.clearCheck();
                No9 = "";
            }
        });
    }



    public void onRadioButtonClicked(View view) {
        // Is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            //ข้อ 1
            case R.id.radio_year1:
                if (checked) No1 = "1"; break;
            case R.id.radio_year2:
                if (checked) No1 = "2"; break;
            case R.id.radio_year3:
                if (checked) No1 = "3"; break;
            case R.id.radio_year4:
                if (checked) No1 = "4"; break;

            //ข้อ 2
            case R.id.male:
                if (checked) No2 = "1"; break;
            case R.id.female:
                if (checked) No2 ="2"; break;

            //ข้อ 3
            case R.id.radio31:
                if (checked) {
                    edit34.setVisibility(View.GONE);
                    No3 = "1";
                    edit34.setText("");
                }
                break;
            case R.id.radio32:
                if (checked) {
                    edit34.setVisibility(View.GONE);
                    No3 = "2";
                    edit34.setText("");
                }
                break;
            case R.id.radio33:
                if (checked) {
                    edit34.setVisibility(View.GONE);
                    No3 = "3";
                    edit34.setText("");
                }
                break;
            case R.id.radio34:
                if (checked) {
                    edit34.setVisibility(View.VISIBLE);
                    Toast.makeText(survey.this, "กรุณาใส่ตัวเลข", Toast.LENGTH_SHORT).show();
                    No3 = edit34.getText().toString();
                    while(No3==""){
                    Toast.makeText(survey.this, "กรุณาใส่ตัวเลข", Toast.LENGTH_SHORT).show();
                    No3 = edit34.getText().toString();
                    if(No3.matches("")) {
                        No3 = "";
                    }
                    }
                }
                break;

            //ข้อ 5
            case R.id.krung:
                if (checked) No5 = "1"; break;
            case R.id.around:
                if (checked) No5 = "2"; break;
            case R.id.other:
                if (checked) No5 = "3"; break;

            //ข้อ 6
            case R.id.radio61:
                if (checked) No6 = "1"; break;
            case R.id.radio62:
                if (checked) No6 = "2"; break;
            case R.id.radio63:
                if (checked) No6 = "3"; break;
            case R.id.radio64:
                if (checked) No6 = "4"; break;

            //ข้อ 7
            case R.id.radio71:
                if (checked) No7 = "1"; break;
            case R.id.radio72:
                if (checked) No7 = "2"; break;
            case R.id.radio73:
                if (checked) No7 = "3"; break;
            case R.id.radio74:
                if (checked) No7 = "4"; break;
            case R.id.radio75:
                if (checked) No7 = "5"; break;
            case R.id.radio76:
                if (checked) No7 = "6"; break;

            //ข้อ 8
            case R.id.radio81:
                if (checked) No8 = "1"; break;
            case R.id.radio82:
                if (checked) No8 = "2"; break;
            case R.id.radio83:
                if (checked) No8 = "3"; break;
            case R.id.radio84:
                if (checked) No8 = "4"; break;
            case R.id.radio85:
                if (checked) No8 = "5"; break;
            case R.id.radio86:
                if (checked) No8 = "6"; break;
            case R.id.radio87:
                if (checked) No8 = "7"; break;

            //ข้อ 9
            case R.id.radio91:
                if (checked) No9 = "ใช้"; break;
            case R.id.radio92:
                if (checked) No9 = "ไม่ใช้"; break;

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
