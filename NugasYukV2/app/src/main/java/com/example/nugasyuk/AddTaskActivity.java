package com.example.nugasyuk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity {

    private EditText judulTugas;
    private EditText tglDeadline;
    private EditText jamDeadline;
    private EditText note;
    private TimePickerDialog timePickerDialog;

    final Calendar calendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        judulTugas = findViewById(R.id.Add_Judul);
        tglDeadline = findViewById(R.id.Add_TglDeadline);
        jamDeadline = findViewById(R.id.Add_JamDeadline);
        note = findViewById(R.id.Add_Note);
        final Button button = findViewById(R.id.addTask);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                displayDate();
            }
        };
        tglDeadline.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });
        jamDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddTaskActivity.this, date,
                        calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(judulTugas.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String judul_tugas = judulTugas.getText().toString();
                String tgl_Deadline = tglDeadline.getText().toString();
                String jam_Deadline = jamDeadline.getText().toString();
                String nnote = note.getText().toString();
                Task tugas = new Task(judul_tugas,tgl_Deadline, jam_Deadline, nnote);
                replyIntent.putExtra("tugas",tugas);
//                replyIntent.putExtra("tgl deadline",tgl_Deadline);
//                replyIntent.putExtra("jam deadline",jam_Deadline);
//                replyIntent.putExtra("catatan",nnote);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    private void displayDate(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        tglDeadline.setText(dateFormat.format(calendar.getTime()));
    }

    private void showTimeDialog(){
        /**
         * Initialize TimePicker Dialog
         */
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                jamDeadline.setText(hour+":"+minute);
            }
        },
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }
}