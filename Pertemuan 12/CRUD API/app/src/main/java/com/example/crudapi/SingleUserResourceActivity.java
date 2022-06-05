package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.singleresource.SingleUserResourceResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserResourceActivity extends AppCompatActivity {
    TextView name, color, pantone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user_resource);
        ButterKnife.bind(this);

        name = findViewById(R.id.tv_nameSingleResource);
        color = findViewById(R.id.tv_colorSingleResource);
        pantone = findViewById(R.id.tv_pantoneSingleResource);

        RestClient.getService().getSingleResource().enqueue(new Callback<SingleUserResourceResponse>() {
            @Override
            public void onResponse(Call<SingleUserResourceResponse> call, Response<SingleUserResourceResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    name.setText(response.body().getData().getName());
                    color.setText(response.body().getData().getColor());
                    pantone.setText(response.body().getData().getPantoneValue());
                }
            }

            @Override
            public void onFailure(Call<SingleUserResourceResponse> call, Throwable t) {

            }
        });
    }
}