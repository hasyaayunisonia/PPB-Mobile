package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.delayed.DataItem;
import com.example.crudapi.delayed.DelayedAdapter;
import com.example.crudapi.delayed.DelayedResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DelayedResponseActivity extends AppCompatActivity {
    @BindView(R.id.rvDelayed)
    RecyclerView rvDelayed;
    private List<DataItem> dataItem;
    private DelayedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_response);
        ButterKnife.bind(this);

        RestClient.getService().getDelayed().enqueue(new Callback<DelayedResponse>() {
            @Override
            public void onResponse(Call<DelayedResponse> call, Response<DelayedResponse> response) {
                if (response.isSuccessful()){
                    dataItem = response.body().getData();

                    adapter = new DelayedAdapter(dataItem, DelayedResponseActivity.this);
                    rvDelayed.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvDelayed.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<DelayedResponse> call, Throwable t) {

            }
        });

    }
}