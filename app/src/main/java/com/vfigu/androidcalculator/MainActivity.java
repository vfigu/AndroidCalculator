package com.vfigu.androidcalculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean isOpPressed = false;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private int secondNumberIndex = 0;
    private String currentOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        final TextView calculatorScreen = findViewById(R.id.calculatorScreen);
        final Button button0 = findViewById(R.id.button0);
        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);
        final Button button5 = findViewById(R.id.button5);
        final Button button6 = findViewById(R.id.button6);
        final Button button7 = findViewById(R.id.button7);
        final Button button8 = findViewById(R.id.button8);
        final Button button9 = findViewById(R.id.button9);
        final Button buttonAdd = findViewById(R.id.buttonAdd);
        final Button buttonBackspace = findViewById(R.id.buttonBackspace);
        final Button buttonCE = findViewById(R.id.buttonCE);
        final Button buttonDecimal = findViewById(R.id.buttonDecimal);
        final Button buttonDivide = findViewById(R.id.buttonDivide);
        final Button buttonEquals = findViewById(R.id.buttonEquals);
        final Button buttonInverse = findViewById(R.id.buttonInverse);
        final Button buttonMultiply = findViewById(R.id.buttonMultiply);
        final Button buttonPercent = findViewById(R.id.buttonPercent);
        final Button buttonRoot = findViewById(R.id.buttonRoot);
        final Button buttonSign = findViewById(R.id.buttonSign);
        final Button buttonSquared = findViewById(R.id.buttonSquared);
        final Button buttonSubtract = findViewById(R.id.buttonSubtract);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int id = view.getId();
                switch (id) {
                    case R.id.button0:
                        appendNumber(calculatorScreen,"0");
                        break;
                    case R.id.button1:
                        appendNumber(calculatorScreen,"1");
                        break;
                    case R.id.button2:
                        appendNumber(calculatorScreen,"2");
                        break;
                    case R.id.button3:
                        appendNumber(calculatorScreen,"3");
                        break;
                    case R.id.button4:
                        appendNumber(calculatorScreen,"4");
                        break;
                    case R.id.button5:
                        appendNumber(calculatorScreen,"5");
                        break;
                    case R.id.button6:
                        appendNumber(calculatorScreen,"6");
                        break;
                    case R.id.button7:
                        appendNumber(calculatorScreen,"7");
                        break;
                    case R.id.button8:
                        appendNumber(calculatorScreen,"8");
                        break;
                    case R.id.button9:
                        appendNumber(calculatorScreen,"9");
                        break;
                    case R.id.buttonAdd:
                        function(calculatorScreen,"＋");
                        break;
                    case R.id.buttonBackspace:
                        backspace(calculatorScreen);
                        break;
                    case R.id.buttonC:
                        break;
                    case R.id.buttonCE:
                        calculatorScreen.setText("0");
                        break;
                    case R.id.buttonDecimal:
                        calculatorScreen.append(".");
                        break;
                    case R.id.buttonDivide:
                        function(calculatorScreen,"÷");
                        break;
                    case R.id.buttonEquals:
                        compute(calculatorScreen);
                        break;
                    case R.id.buttonInverse:
                        break;
                    case R.id.buttonMultiply:
                        function(calculatorScreen,"╳");
                        break;
                    case R.id.buttonPercent:
                        break;
                    case R.id.buttonRoot:
                        break;
                    case R.id.buttonSign:
                        break;
                    case R.id.buttonSquared:
                        calculatorScreen.append(".");
                        break;
                    case R.id.buttonSubtract:
                        function(calculatorScreen,"—");
                        break;
                }
            }
        };
        button0.setOnClickListener(calculatorListener);
        button1.setOnClickListener(calculatorListener);
        button2.setOnClickListener(calculatorListener);
        button3.setOnClickListener(calculatorListener);
        button4.setOnClickListener(calculatorListener);
        button5.setOnClickListener(calculatorListener);
        button6.setOnClickListener(calculatorListener);
        button7.setOnClickListener(calculatorListener);
        button8.setOnClickListener(calculatorListener);
        button9.setOnClickListener(calculatorListener);
        buttonAdd.setOnClickListener(calculatorListener);
        buttonBackspace.setOnClickListener(calculatorListener);
        buttonCE.setOnClickListener(calculatorListener);
        buttonDecimal.setOnClickListener(calculatorListener);
        buttonDivide.setOnClickListener(calculatorListener);
        buttonEquals.setOnClickListener(calculatorListener);
        buttonInverse.setOnClickListener(calculatorListener);
        buttonMultiply.setOnClickListener(calculatorListener);
        buttonPercent.setOnClickListener(calculatorListener);
        buttonRoot.setOnClickListener(calculatorListener);
        buttonSign.setOnClickListener(calculatorListener);
        buttonSquared.setOnClickListener(calculatorListener);
        buttonSubtract.setOnClickListener(calculatorListener);


    }

    public void appendNumber(TextView calculatorScreen, String number) {
        String calculatorContent = calculatorScreen.getText().toString();
        int length = calculatorContent.length();
        if(!isOpPressed){
           calculatorScreen.setText(number);
        }
        else if(length == 1 && calculatorContent.charAt(0) == '0'){
           calculatorScreen.setText(number);
        }
        else{
            calculatorScreen.append(number);
        }
    }
    public void function(TextView calculatorScreen, String symbol) {
        String calculatorContent = calculatorScreen.getText().toString();
        int length = calculatorContent.length();
        if (length > 1) {
            if(calculatorContent.charAt(length-1) == ' '){
                calculatorContent = calculatorContent.substring(0, length - 3);
            }
            else if(calculatorContent.charAt(length-1) == '.'){
                calculatorScreen.append("0");
            }
            else if(isOpPressed){
                compute(calculatorScreen);
            }
        }
        firstNumber = Double.parseDouble(calculatorContent);

        currentOp = symbol;

        if(!symbol.equals(".")){
            symbol = ' ' + symbol + ' ';
            secondNumberIndex = calculatorContent.length()+3;
            isOpPressed = true;
        }
        calculatorContent += symbol;
        calculatorScreen.setText(calculatorContent);
    }

    public void compute(TextView calculatorScreen){
        if(isOpPressed){
            String calculatorContent = calculatorScreen.getText().toString();

            int length = calculatorContent.length();
            if (length > 1) {
                if (calculatorContent.charAt(length - 1) != ' ') {
                    String secondNumberString = calculatorContent.substring(secondNumberIndex, length);
                    secondNumber = Double.parseDouble(secondNumberString);

                    if (currentOp.equals("＋")) {
                        secondNumber += firstNumber;
                    }
                    if (currentOp.equals("—")) {
                        secondNumber = firstNumber - secondNumber;
                    }
                    if (currentOp.equals("╳")) {
                        secondNumber *= firstNumber;
                    }
                    if (currentOp.equals("÷")) {
                        secondNumber = firstNumber / secondNumber;
                    }

                    calculatorScreen.setText(String.valueOf(secondNumber));
                    isOpPressed = false;
                }
            }
        }
    }

    public void backspace(TextView calculatorScreen) {
        String calculatorContent = calculatorScreen.getText().toString();
        int length = calculatorContent.length();
        if (length > 1) {
            if(calculatorContent.charAt(length-1) == ' '){
                calculatorContent = calculatorContent.substring(0, length - 3);
            }
            else{
                calculatorContent = calculatorContent.substring(0, length - 1);
            }
            calculatorScreen.setText(calculatorContent);
        }
        else {
            calculatorScreen.setText("0");
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
