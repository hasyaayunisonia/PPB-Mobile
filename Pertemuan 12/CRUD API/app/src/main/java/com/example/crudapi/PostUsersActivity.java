package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.post.PostResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostUsersActivity extends AppCompatActivity {
    EditText postName, postJob;
    Button kirim;
    TextView status, id, name, job, create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_users);
        ButterKnife.bind(this);

        postName = findViewById(R.id.postName);
        postJob = findViewById(R.id.postJob);
        status = findViewById(R.id.resultStatus);
        id = findViewById(R.id.resultId);
        name = findViewById(R.id.resultName);
        job = findViewById(R.id.resultJob);
        create= findViewById(R.id.resultCreateAt);
        kirim = findViewById(R.id.kirim);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestClient.getService().createPost(postName.getText().toString(),
                        postJob.getText().toString()).enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body() != null) {
                                status.setText(Integer.toString(response.code()));
                                id.setText(response.body().getId());
                                name.setText(response.body().getName());
                                job.setText(response.body().getJob());
                                create.setText(response.body().getCreatedAt());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<PostResponse> call, Throwable t) {

                    }
                });
            }
        });

    }
}