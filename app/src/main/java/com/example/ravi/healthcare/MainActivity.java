package com.example.ravi.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button login,register,skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login= (Button) findViewById(R.id.login);
        register= (Button) findViewById(R.id.register);
        skip= (Button) findViewById(R.id.skip);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        skip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==login){
            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
         if(v==register){
            Intent intent1=new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent1);
        }
        if(v==skip){
            Intent intent1=new Intent(getApplicationContext(),NevigationDrawer.class);
            startActivity(intent1);
        }

    }
}
