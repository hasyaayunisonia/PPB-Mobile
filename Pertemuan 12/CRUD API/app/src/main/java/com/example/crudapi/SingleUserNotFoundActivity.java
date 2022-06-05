package com.example.crudapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.singleuser.SingleUserResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserNotFoundActivity extends AppCompatActivity {
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user_not_found);
        ButterKnife.bind(this);

        status = findViewById(R.id.responseStatusSingleNotFound);

        RestClient.getService().getSingleUserNotFound().enqueue(new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(@NonNull Call<SingleUserResponse> call, @NonNull Response<SingleUserResponse> response) {
                if (response.isSuccessful()){
                    status.setText(Integer.toString(response.code()));
                } else {
                    status.setText(Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<SingleUserResponse> call, @NonNull Throwable t) {

            }
        });
    }
}