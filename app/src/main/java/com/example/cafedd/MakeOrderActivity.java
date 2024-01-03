package com.example.cafedd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MakeOrderActivity extends AppCompatActivity {
    private static final String EXTRA_USER_NAME = "userName";
    private TextView tvGreeting;
    private RadioGroup drink;
    private RadioButton teaBtn;
    private RadioButton coffeeBtn;
    private CheckBox sugar;
    private CheckBox milk;
    private CheckBox lemon;
    private Spinner tea;
    private Spinner coffee;
    private Button makeOrder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        Intent intent = getIntent();
        initViews();
        String userName = intent.getStringExtra(EXTRA_USER_NAME);
        String greeting = getString(R.string.hello_s_what_do_you_want, userName);
        tvGreeting.setText(greeting);



    }

    private void initViews() {
        tvGreeting = findViewById(R.id.tvGreeting);
        drink = findViewById(R.id.rbDrink);
        teaBtn = findViewById(R.id.rbTea);
        coffeeBtn = findViewById(R.id.rbCoffee);
        sugar = findViewById(R.id.sugar);
        milk = findViewById(R.id.milk);
        lemon = findViewById(R.id.lemon);
        tea = findViewById(R.id.spinnerTea);
        coffee = findViewById(R.id.spinnerCoffie);
        makeOrder = findViewById(R.id.btnMakeOrder);

    }

    public static Intent newIntent(Context context, String userName){
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        return intent;
    }
}