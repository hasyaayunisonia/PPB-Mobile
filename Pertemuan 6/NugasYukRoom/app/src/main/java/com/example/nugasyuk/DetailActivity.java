package com.example.nugasyuk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
   TextView textView1, textView2, textView3;
   String string1, string2, string3;
    ImageView imageView;
    private TaskViewModel mTaskViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView1 = findViewById(R.id.myTextTask);
        textView2 = findViewById(R.id.myTextDeadline);
        textView3 = findViewById(R.id.myTextNote);

        getData();
        setData();
    }

    public void getData() {
        if(getIntent().hasExtra("string1") && getIntent().hasExtra("string2") && getIntent().hasExtra("string3")) {
            string1 = getIntent().getStringExtra("string1");
            string2 = getIntent().getStringExtra("string2");
            string3 = getIntent().getStringExtra("string3");
        } else {
            Toast.makeText(this,"Nothing",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        textView1.setText(string1);
        textView2.setText(string2);
        textView3.setText(string3);
    }

}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//    }