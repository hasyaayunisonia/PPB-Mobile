package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.put.PutResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PutUserActivity extends AppCompatActivity {
    EditText putName, putJob;
    Button kirim;
    TextView status, name, job, update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_user);
        ButterKnife.bind(this);

        putName = findViewById(R.id.putName);
        putJob = findViewById(R.id.putJob);
        status = findViewById(R.id.resultputStatus);
        name = findViewById(R.id.resultputName);
        job = findViewById(R.id.resultputJob);
        update= findViewById(R.id.resultputUpdatedAt);
        kirim = findViewById(R.id.putkirim);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestClient.getService().updatePut(putName.getText().toString(),
                        putJob.getText().toString()).enqueue(new Callback<PutResponse>() {
                    @Override
                    public void onResponse(Call<PutResponse> call, Response<PutResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body() != null) {

                                status.setText(Integer.toString(response.code()));
                                name.setText(response.body().getName());
                                job.setText(response.body().getJob());
                                update.setText(response.body().getUpdatedAt());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<PutResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}