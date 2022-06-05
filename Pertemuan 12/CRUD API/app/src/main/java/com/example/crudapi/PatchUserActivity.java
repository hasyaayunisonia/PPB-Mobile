package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.patch.PatchResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatchUserActivity extends AppCompatActivity {
    EditText patchName, patchJob;
    Button kirim;
    TextView status, name, job, update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patch_user);

        ButterKnife.bind(this);

        patchName = findViewById(R.id.patchName);
        patchJob = findViewById(R.id.patchJob);
        status = findViewById(R.id.resultpatchStatus);
        name = findViewById(R.id.resultpatchName);
        job = findViewById(R.id.resultpatchJob);
        update= findViewById(R.id.resultpatchUpdatedAt);
        kirim = findViewById(R.id.patchkirim);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestClient.getService().updatePatch(patchName.getText().toString(),
                        patchJob.getText().toString()).enqueue(new Callback<PatchResponse>() {
                    @Override
                    public void onResponse(Call<PatchResponse> call, Response<PatchResponse> response) {
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
                    public void onFailure(Call<PatchResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}