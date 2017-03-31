package com.example.ravi.healthcare;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import  com.example.ravi.healthcare.model.Patient;
import  com.example.ravi.healthcare.model.JasonParser;
import  com.example.ravi.healthcare.model.Error;
import com.loopj.android.http.JsonHttpResponseHandler;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class RegisterActivity extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    private Calendar calendar;
    EditText date,fname,lname,mobile;
    Button register;
    private int year, month, day;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        date = (EditText) findViewById(R.id.dob);
        fname= (EditText) findViewById(R.id.firstname);
        lname= (EditText) findViewById(R.id.lastname);
        mobile= (EditText) findViewById(R.id.mobile);
        register= (Button) findViewById(R.id.register);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            };

        });


    }

    public void save(View view){
        Patient patient=new Patient(fname.getText().toString(),lname.getText().toString(),mobile.getText().toString(),JasonParser.dateParser(date.getText().toString()));
        String patientJson=JasonParser.getJSON(patient);
        Log.d("Json Patient",patientJson);

        RestCall.post(getApplicationContext(),"patients",patientJson,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("",String.valueOf(response));

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable t, JSONArray response) {
                Log.d("",String.valueOf(response));
                ShowError(response);
                Log.d("",String.valueOf(t));
            }
        });

    }
    void ShowError(JSONArray  response){
        LinearLayout ll = (LinearLayout) findViewById(R.id.errorcontainer);
        ll.removeAllViews();
        ArrayList<Error> errors=new ArrayList<Error>();
        errors = (ArrayList<Error>) JasonParser.jsonArrayToErrorList(response);
        final int N = errors.size(); // total number of textviews to add

        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (Object object:errors) {
            Error error=(Error)object;
            // create a new textview
            TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something
            rowTextView.setText(error.getMessage());
            rowTextView.setTextColor(Color.RED);
            // add the textview to the linearlayout
            ll.addView(rowTextView);

            // save a reference to the textview for later
            //myTextViews[i] = rowTextView;
        }
    };





}
