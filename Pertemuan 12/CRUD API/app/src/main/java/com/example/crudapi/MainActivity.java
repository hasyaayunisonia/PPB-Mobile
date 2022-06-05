package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12, button13, button14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.listusers);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListUserActivity.class);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.singleuser);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SingleUserActivity.class);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.singleusernotfound);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleUserNotFoundActivity.class));
            }
        });

        button4 = (Button) findViewById(R.id.listresource);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListUserResourceActivity.class));
            }
        });

        button5 = (Button) findViewById(R.id.singleresource);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleUserResourceActivity.class));
            }
        });

        button6 = (Button) findViewById(R.id.singleresourcenotfound);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleUserNotFoundActivity.class));
            }
        });

        button7 = (Button) findViewById(R.id.create);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PostUsersActivity.class));
            }
        });

        button8 = (Button) findViewById(R.id.update);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PutUserActivity.class));
            }
        });

        button9 = (Button) findViewById(R.id.update2);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PatchUserActivity.class));
            }
        });

        button10 = (Button) findViewById(R.id.delete);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DeleteUserActivity.class));
            }
        });

        button11 = (Button) findViewById(R.id.register);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterSuccessfulActivity.class));
            }
        });


        button12 = (Button) findViewById(R.id.register2);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterUnsuccessfulActivity.class));
            }
        });

        button13 = (Button) findViewById(R.id.loginunsuccessful);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginUnsuccessfulActivity.class));
            }
        });

        button14 = (Button) findViewById(R.id.delayed);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DelayedResponseActivity.class));
            }
        });
    }
}