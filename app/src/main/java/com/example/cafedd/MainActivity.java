package com.example.cafedd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnEnter = findViewById(R.id.enterBtn);
        EditText password = findViewById(R.id.password);
        EditText name = findViewById(R.id.userName);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPassword = password.getText().toString().trim();
                String userName = name.getText().toString().trim();
                if(userName.isEmpty() || userPassword.isEmpty()){
                    Toast.makeText(
                            MainActivity.this,
                            R.string.error_empty_fields,
                            Toast.LENGTH_SHORT).show();
                }
                else lanchNewActivity(userName);


            }
        });

    }

    private void lanchNewActivity(String userName) {
        Intent intent = MakeOrderActivity.newIntent(this, userName);
        startActivity(intent);
    }
}