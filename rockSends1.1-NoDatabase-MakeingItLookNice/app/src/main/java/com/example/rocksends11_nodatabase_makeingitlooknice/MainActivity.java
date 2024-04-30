package com.example.rocksends11_nodatabase_makeingitlooknice;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Genral Veribals
    Button logInButton, registerButton;
    Boolean usernameNPasswordCheck;
    EditText userNameCover, passwordCover;
    int errorCounter;
    String userNameStr, passwordStr;

    //Layout Veribals
    TextView userNameErrorMessage,passwordErrorMessage, errorClockCounter;

    //Timer Veribals
    CountDownTimer countDownTimer;
    Boolean errorTimerCheck = false;
    long errorClock = 60000; //1 min
    //long errorClock = 6000; //10 Secs
    long errorClockPass = errorClock;
    String errorClockViewStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorClockCounter = findViewById(R.id.errorClockCounter);
        errorClockCounter.setVisibility(View.INVISIBLE);

        logInButton = findViewById(R.id.logInButton);
        logInButton.setOnClickListener(this);
    }

    public void onClick(View V){
        switch (V.getId()){
            case R.id.logInButton:
                usernameNPasswordCheck = pullUserNPassword();

                if((errorCounter != 5) && (!errorTimerCheck)) {
                    if (usernameNPasswordCheck) {
                        Intent Dashboard = new Intent(MainActivity.this, mapPage.class);
                        startActivity(Dashboard);
                        Toast.makeText(this, "Login Worked", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
                        errorCounter++;
                        if(errorCounter == 5){
                            errorTimerCheck = true;
                        }
                    }
                }
                else if(errorTimerCheck){
                    errorClockRute();
                    errorCounter = 0;
                }
                else{
                    Toast.makeText(this, "You are locked out till the timer has ran out", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public boolean pullUserNPassword(){
        userNameCover = findViewById(R.id.userNameCover);
        userNameStr = userNameCover.getText().toString();
        passwordCover = findViewById(R.id.passwordCover);
        passwordStr = passwordCover.getText().toString();

        if ((userNameStr.equals("asdf")) && (passwordStr.equals("1234"))){
            usernameNPasswordCheck = true;
        }
        else {
            usernameNPasswordCheck = false;
        }

        userNameErrorMessage = findViewById(R.id.userNameErrorMessage);
        passwordErrorMessage = findViewById(R.id.passwordErrorMessage);

        if(!usernameNPasswordCheck) {
            if (userNameStr.equals("")) {
                userNameErrorMessage.setVisibility(View.VISIBLE);
                userNameErrorMessage.setText("Error: No User Name Inputted");
                usernameNPasswordCheck = false;
            } else if (!userNameStr.equals("asdf")) {
                userNameErrorMessage.setVisibility(View.VISIBLE);
                userNameErrorMessage.setText("Error: Wrong User Name inputted");
                usernameNPasswordCheck = false;
            }
            if (passwordStr.equals("")) {
                passwordErrorMessage.setVisibility(View.VISIBLE);
                passwordErrorMessage.setText("Error: No Password Inputted");
                usernameNPasswordCheck = false;
            } else if (!passwordStr.equals("asdf")) {
                passwordErrorMessage.setVisibility(View.VISIBLE);
                passwordErrorMessage.setText("Error: Wrong Password inputted");
                usernameNPasswordCheck = false;
            }
        }

        return usernameNPasswordCheck;
    }

    public void errorClockRute(){
        errorClockPass = errorClock;
        countDownTimer = new CountDownTimer(errorClock, 1000) {
            @Override
            public void onTick(long i) {
                errorClock = i;

                errorTimerCheck = true;

                updateTimer();
            }
            @Override
            public void onFinish() {
                errorClock = errorClockPass * 2;
                errorTimerCheck = false;

                errorClockCounter = findViewById(R.id.errorClockCounter);
                errorClockCounter.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    public void updateTimer(){
        int mins = (int) errorClock / 60000;
        int secs = (int) errorClock % 60000 / 1000;

        errorClockViewStr = "";
        if(mins < 10){
            errorClockViewStr = "0";
        }
        errorClockViewStr += mins;
        errorClockViewStr += ":";
        if(secs < 10){
            errorClockViewStr += "0";
        }
        errorClockViewStr += secs;
        errorClockCounter = findViewById(R.id.errorClockCounter);
        errorClockCounter.setVisibility(View.VISIBLE);
        errorClockCounter.setText("You Are Locked Out Till The Timer Runs Out:\n" + errorClockViewStr);
    }
}