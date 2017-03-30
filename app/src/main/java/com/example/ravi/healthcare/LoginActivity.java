package com.example.ravi.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
EditText mobile,password;
    Button login,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobile= (EditText) findViewById(R.id.mobile);
        password= (EditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.login);
        reg= (Button) findViewById(R.id.movereg);

    }

    @Override
    public void onClick(View v) {
        if(v==reg){
            Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);
        }
    }
}
