package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuelapp.APIInterface.IUserAPI;
import com.example.fuelapp.Database.DBHandler;
import com.example.fuelapp.Database.DBMaster;
import com.example.fuelapp.models.APIClient;
import com.example.fuelapp.models.Login;
import com.example.fuelapp.models.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextView email;
    private TextView password;
    DBHandler dbHandler = new DBHandler(LoginActivity.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Button button = (Button) findViewById(R.id.btn_login);
        email = findViewById(R.id.user_email);
        password = findViewById(R.id.user_password);

        Cursor cursor = dbHandler.getcredencials();

        if (cursor != null){

            while(cursor.moveToNext()) {
                email.setText(cursor.getString(1));
                password.setText(cursor.getString(2));
                break;
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                Intent sign = new Intent(getApplicationContext(),FuelStationActivity.class);
//                startActivity(sign);

                onSignin();

            }
        });
    }

    protected void onSignin(){
        String email = this.email.getText().toString();
       String password = this.password.getText().toString();
        Login login = new Login(email,password);

        IUserAPI iuserapi = APIClient.getRetrofit().create(IUserAPI.class);
        Call<ResponseLogin> call = iuserapi.Login(login);
        call.enqueue(new Callback<ResponseLogin>() {

            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                Log.e("LoginActivity", "Response code " +response.code());


            if(response.code() == 200){
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                if(dbHandler.actionRegister(response.body().getData().getEmail(),response.body().getData().getPassword())){
                if(response.body().getData().getUserRole().contentEquals("Owner")) {
                    Log.e("LoginActivity", "id " + response.body().getData().getId());
                    Intent i = new Intent(LoginActivity.this, OwnerStationActivity.class);
                    i.putExtra("id", response.body().getData().getId());
                    i.putExtra("Name", response.body().getData().getName());
                    i.putExtra("Address", response.body().getData().getAddress());
                    i.putExtra("Email", response.body().getData().getEmail());
                    i.putExtra("NiC", response.body().getData().getNIC());
                    startActivity(i);


                }else{

                    Intent i = new Intent(LoginActivity.this ,FuelStationActivity.class);
                    i.putExtra("id",response.body().getData().getId());
                    i.putExtra("Name",response.body().getData().getName());
                    i.putExtra("Address",response.body().getData().getAddress());
                    i.putExtra("Email",response.body().getData().getEmail());
                    i.putExtra("NiC",response.body().getData().getNIC());
                    i.putExtra("NiC",response.body().getData().getVehicleNumber());
                    i.putExtra("NiC",response.body().getData().getVehicleTypeId());
                    startActivity(i);



                }


                }else{
                    Log.e("LoginActivity", "Sqlitie faield " );
                }
            }else{
                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login API Called Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}