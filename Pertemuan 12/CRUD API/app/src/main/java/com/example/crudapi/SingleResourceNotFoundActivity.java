package com.example.crudapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.singleresource.SingleUserResourceResponse;
import com.example.crudapi.singleuser.SingleUserResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleResourceNotFoundActivity extends AppCompatActivity {
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_resource_not_found);
        ButterKnife.bind(this);

        status = findViewById(R.id.responseStatusSingleResourceNotFound);

        RestClient.getService().getSingleResourceNotFound().enqueue(new Callback<SingleUserResourceResponse>() {
            @Override
            public void onResponse(@NonNull Call<SingleUserResourceResponse> call, @NonNull Response<SingleUserResourceResponse> response) {
                if (response.isSuccessful()){
                    status.setText(Integer.toString(response.code()));
                } else {
                    status.setText(Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<SingleUserResourceResponse> call, @NonNull Throwable t) {

            }
        });
    }
}