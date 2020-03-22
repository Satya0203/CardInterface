package com.example.basic.cardinterface;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    TextView showvalue,mDisplayDate;
    int counter=0;

    Spinner sp;
    String str[]={"PVR","PVP","TRENDSET","SHOPPERSTOP"};
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Button buttondate;
    public static final String TAG="MAINACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showvalue=findViewById(R.id.textView);
        mDisplayDate=findViewById(R.id.tviewdate);
        buttondate=findViewById(R.id.buttondate);
        sp=findViewById(R.id.spinner);

        sp.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,str);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2)
            {
                Log.d(TAG,"on DATESET:date"+i+""+i1+""+i2);
                String date=i+"/"+i1+"/"+i2;
                mDisplayDate.setText(date);
            }
        };




    }




    public void Dec(View view)
    {
        if(counter>0)
        {
        counter--;

            showvalue.setText(Integer.toString(counter));
        }
        else
        {
            Toast.makeText(this,"Does not Exists",Toast.LENGTH_LONG).show();
        }

    }

    public void Inc(View view)
    {
        counter++;
        showvalue.setText(Integer.toString(counter));
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(this,str[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}

