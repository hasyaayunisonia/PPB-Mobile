package com.example.crudapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudapi.api.RestClient;
import com.example.crudapi.registersuccessful.BodyRegister;
import com.example.crudapi.registersuccessful.RegisterResponse;
import com.example.crudapi.registerunsuccessful.BodyRegisterUnsuccessful;
import com.example.crudapi.registerunsuccessful.RegisterUnsuccessfulResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUnsuccessfulActivity extends AppCompatActivity {
    @BindView(R.id.registerEmail)
    EditText Email;
    @BindView(R.id.registerPassword)
    EditText Password;
    @BindView(R.id.btnRegister)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_unsuccessful);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegister)
    public void onViewClicked() {

        BodyRegisterUnsuccessful bodyRegisterUnsuccessful =  new BodyRegisterUnsuccessful();
        bodyRegisterUnsuccessful.setEmail(Email.getText().toString());

        RestClient.getService().postRegisterUnsuccessful(bodyRegisterUnsuccessful).enqueue(new Callback<RegisterUnsuccessfulResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<RegisterUnsuccessfulResponse> call, Response<RegisterUnsuccessfulResponse> response) {
                Toast.makeText(getApplicationContext(),"error : Missing password",Toast.LENGTH_SHORT).show();
                Log.i("Response",response.message());
            }

            @Override
            public void onFailure(Call<RegisterUnsuccessfulResponse> call, Throwable t) {

            }
        });
    }
}