package com.example.cafedd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MakeOrderActivity extends AppCompatActivity {
    private static final String EXTRA_USER_NAME = "userName";
    private TextView tvGreeting;
    private String userName;
    private RadioGroup drink;
    private RadioButton teaBtn;
    private RadioButton coffeeBtn;
    private TextView userChoseDrink;
    private CheckBox sugar;
    private CheckBox milk;
    private CheckBox lemon;
    private Spinner tea;
    private Spinner coffee;
    private Button makeOrder;
    private String userDrink;
    private String drinkType;
    private ArrayList<String> additions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);

        initViews();
        setUpName();


        drink.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                if(teaBtn.getId()==id){
                    onUserChoseTea();
                }else onUserChoseCoffee();
            }
        });

        teaBtn.setChecked(true);

        makeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMakeUserOrder();
                lanchNewActivity();
            }
        });


    }

    private void lanchNewActivity() {
        Intent intent = OrderDetailedActivity.newIntent(this, userName, userDrink, additions, drinkType);
        startActivity(intent);
    }

    private void onMakeUserOrder() {
        additions = new ArrayList<>();
        if(sugar.isChecked()){
            additions.add(sugar.getText().toString());
        }

        if(milk.isChecked()){
            additions.add(milk.getText().toString());
        }

        if(teaBtn.isChecked() && lemon.isChecked()){
            additions.add(lemon.getText().toString());
        }



        if(teaBtn.isChecked()){
            drinkType = tea.getSelectedItem().toString();
        } else if (coffeeBtn.isChecked()) {
            drinkType = coffee.getSelectedItem().toString();
        }

    }

    private void onUserChoseCoffee() {
        userDrink = getString(R.string.coffee);
        String additivesLabel = getString(R.string.additives, userDrink);
        userChoseDrink.setText(additivesLabel);
        lemon.setVisibility(View.INVISIBLE);

        tea.setVisibility(View.INVISIBLE);
        coffee.setVisibility(View.VISIBLE);


    }

    private void onUserChoseTea() {
        userDrink = getString(R.string.tea);
        String additivesLabel = getString(R.string.additives, userDrink);
        userChoseDrink.setText(additivesLabel);
        lemon.setVisibility(View.VISIBLE);
        tea.setVisibility(View.VISIBLE);
        coffee.setVisibility(View.INVISIBLE);
    }

    private void setUpName() {
        Intent intent = getIntent();
        userName = intent.getStringExtra(EXTRA_USER_NAME);
        String greeting = getString(R.string.hello_s_what_do_you_want, userName);
        tvGreeting.setText(greeting);
    }

    private void initViews() {
        tvGreeting = findViewById(R.id.tvGreeting);
        drink = findViewById(R.id.rbDrink);
        teaBtn = findViewById(R.id.rbTea);
        coffeeBtn = findViewById(R.id.rbCoffee);
        userChoseDrink = findViewById(R.id.drink);
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