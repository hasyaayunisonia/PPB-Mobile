package com.example.crudapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crudapi.api.RestClient;
import com.example.crudapi.singleuser.SingleUserResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserActivity extends AppCompatActivity {
    TextView singleName, singleLastName;
    ImageView singleAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);
        ButterKnife.bind(this);

        singleName = findViewById(R.id.single_tv_name);
        singleLastName = findViewById(R.id.single_tv_last_name);
        singleAvatar = findViewById(R.id.single_img_avatar);

        RestClient.getService().getSingleUser().enqueue(new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(@NonNull Call<SingleUserResponse> call, @NonNull Response<SingleUserResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    singleName.setText(response.body().getData().getFirstName());
                    singleLastName.setText(response.body().getData().getLastName());
                    Glide.with(singleAvatar).load(response.body().getData().getAvatar()).into(singleAvatar);
                }
            }

            @Override
            public void onFailure(@NonNull Call<SingleUserResponse> call, @NonNull Throwable t) {

            }
        });
    }
}