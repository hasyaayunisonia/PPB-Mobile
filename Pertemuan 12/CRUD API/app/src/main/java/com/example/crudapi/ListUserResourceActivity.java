package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.listuserresource.DataItemListResource;
import com.example.crudapi.listuserresource.ListUserResourceAdapter;
import com.example.crudapi.listuserresource.ListUserResourceResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserResourceActivity extends AppCompatActivity {

    @BindView(R.id.rvListUserResource)
    RecyclerView rvListUserResource;

    private List<DataItemListResource> dataItemListResource;
    private ListUserResourceAdapter listUserResourceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_resource);

        ButterKnife.bind(this);

        RestClient.getService().getListResource().enqueue(new Callback<ListUserResourceResponse>() {
            @Override
            public void onResponse(Call<ListUserResourceResponse> call, Response<ListUserResourceResponse> response) {
                if (response.isSuccessful()){
                    dataItemListResource = response.body().getData();

                    listUserResourceAdapter = new ListUserResourceAdapter(dataItemListResource, ListUserResourceActivity.this);
                    rvListUserResource.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUserResource.setAdapter(listUserResourceAdapter);
                }
            }

            @Override
            public void onFailure(Call<ListUserResourceResponse> call, Throwable t) {

            }
        });
    }
}