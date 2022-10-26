package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuelapp.APIInterface.IUserAPI;
import com.example.fuelapp.models.APIClient;
import com.example.fuelapp.models.ResponseUser;
import com.example.fuelapp.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private TextView name;
    private TextView Email;
    private TextView Password;
    private TextView PhoneNo;
    private TextView NIC;
    private TextView Address;
    private TextView UserRole;
    private TextView VehicleTypeId;
    private TextView VehicleNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        Button button = (Button) findViewById(R.id.btn_next1);

          name = findViewById(R.id.user_name);
        Email = findViewById(R.id.user_email);
         Password = findViewById(R.id.user_password);
        NIC = findViewById(R.id.user_nic);
        Address = findViewById(R.id.user_address);



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Intent login = new Intent(getApplicationContext(),RegisterStationActivity.class);
                //startActivity(login);
                onSubmit();
            }
        });
    }

    public void  onSubmit(){
         String name = this.name.getText().toString();
        String Email = this.Email.getText().toString();
        String Password = this.Password.getText().toString();
        String PhoneNo = "0765467890";
        String NIC = this.NIC.getText().toString();
        String Address = this.Address.getText().toString();
        String UserRole = "Owner";
        String VehicleTypeId;
        String VehicleNumber;

        if(name.isEmpty()){
            this.name.setError("Name is required");
            this.name.requestFocus();
            return;
        }

        else if(Email.isEmpty()){
            this.Email.setError("Email is required");
            this.Email.requestFocus();
            return;
        }

        else if(Password.isEmpty() || Password.length() < 8){
            this.Password.setError("Password must contain 8 characters");
            this.Password.requestFocus();
            return;
        }

        else if(Address.isEmpty()){
            this.Address.setError("Address is required");
            this.Address.requestFocus();
            return;
        }

        else if(NIC.isEmpty()){
            this.NIC.setError("NIC is required");
            this.NIC.requestFocus();
            return;
        }

        User user = new User(name, Email, Password, PhoneNo,NIC, Address, UserRole);

        IUserAPI  iuseapi = APIClient.getRetrofit().create(IUserAPI.class);
        Call<ResponseUser> call = iuseapi.CreateUser(user);

        call.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                Log.e("Response", "Response code : "+ response.code());

                if(response.code() ==200){
                    Log.e("Response", "test : "+response.body().getData());
                    Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                   Intent login = new Intent(getApplicationContext(),RegisterStationActivity.class);
                    startActivity(login);
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "SignUp API Called Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}