package com.example.nugasyuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4;
//    String string1, string2, string3, string4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView1 = findViewById(R.id.myTextTask);
        textView2 = findViewById(R.id.myTglDeadline);
        textView3 = findViewById(R.id.myJamDeadline);
        textView4 = findViewById(R.id.myTextNote);

        Intent intent = getIntent();

        Task task = intent.getParcelableExtra("task");

        textView1.setText(task.getJudulTugas());
        textView2.setText(task.getTanggal());
        textView3.setText(task.getJam());
        textView4.setText(task.getNote());
    }

//    public void getData() {
//        if(getIntent().hasExtra("tugas") && getIntent().hasExtra("catatan") ) {
//            string1 = getIntent().getStringExtra("tugas");
//            string2 = getIntent().getStringExtra("deadline");
//            string3 = getIntent().getStringExtra("deadline");
//            string4 = getIntent().getStringExtra("catatan");
//        } else {
//            Toast.makeText(this,"Nothing",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void setData(){
//        textView1.setText(string1);
//        textView2.setText(string2);
//        textView3.setText(string3);
//        textView4.setText(string4);
//    }
}