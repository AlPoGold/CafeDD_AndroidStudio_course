package com.example.cafedd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;



public class OrderDetailedActivity extends AppCompatActivity {
    public static final String EXTRA_USER_NAME = "userName";
    private static final String EXTRA_USER_DRINK = "userDrink";
    private static final String EXTRA_USER_ADDITIONS = "userAdditions";
    private static final String EXTRA_USER_DRINK_TYPE = "userDrinkType";

    private String userName;
    private String userDrink;
    private String additions;
    private String drinkType;

    private TextView userNameView;
    private TextView userDrinkView;
    private TextView userDrinkType;
    private TextView userDrinkAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detailed);

        setUpVariables();
        setUpFields();

    }

    private void setUpFields() {
        userNameView = findViewById(R.id.textViewName_res);
        userDrinkView = findViewById(R.id.textViewDrink_res);
        userDrinkType = findViewById(R.id.textViewTypeDrink_res);
        userDrinkAdd = findViewById(R.id.textViewAdditivies_res);

        userNameView.setText(userName);
        userDrinkView.setText(userDrink);
        userDrinkType.setText(drinkType);
        userDrinkAdd.setText(additions);

    }

    private void setUpVariables() {
        userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        userDrink = getIntent().getStringExtra(EXTRA_USER_DRINK);
        additions = getIntent().getStringExtra(EXTRA_USER_ADDITIONS);
        drinkType = getIntent().getStringExtra(EXTRA_USER_DRINK_TYPE);
    }


    public static Intent newIntent(Context context, String userName, String userDrink, ArrayList<String> additions, String drinkType){
        Intent intent = new Intent(context, OrderDetailedActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        intent.putExtra(EXTRA_USER_DRINK, userDrink);
        intent.putExtra(EXTRA_USER_ADDITIONS, String.join(",", additions));
        intent.putExtra(EXTRA_USER_DRINK_TYPE, drinkType);
        return intent;
    }
}