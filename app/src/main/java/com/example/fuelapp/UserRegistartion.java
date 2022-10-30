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

public class UserRegistartion extends AppCompatActivity {


    private TextView name;
    private TextView Email;
    private TextView Password;
    private TextView PhoneNo;
    private TextView NIC;
    private TextView Address;
    private TextView UserRole;
    private TextView VehicleTypeId;
    private TextView CarNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registartion);


        getSupportActionBar().hide();

        Button button = (Button) findViewById(R.id.btn_next1);

        name = findViewById(R.id.user_name);
        Email = findViewById(R.id.user_email);
        Password = findViewById(R.id.user_password);
        NIC = findViewById(R.id.user_nic);
        Address = findViewById(R.id.user_address);
        CarNo = findViewById(R.id.user_car);



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
        String PhoneNo = "0723456780";
        String CarNo = this.CarNo.getText().toString();
        String NIC = this.NIC.getText().toString();
        String Address = this.Address.getText().toString();
        String UserRole = "Customer";
        String VehicleTypeId;
        String VehicleNumber = "6358bdcd672ebe8e2ca026c0";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        String NICPattern1 = "[0-9]{7}+0[0-9]{4}";
        String NICPattern2 = "[0-9]{9}[Vv]";


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

        else if (!Email.matches(emailPattern) )
        {
            this.Email.setError("Incorrect Email Entered. Please enter again correctly");
            this.Email.requestFocus();
            return;
        }

        else if(Password.isEmpty() || Password.length() < 8){
            this.Password.setError("Password must contain 8 characters");
            this.Password.requestFocus();
            return;
        }

        else if (!Password.matches(passwordPattern) )
        {
            this.Password.setError("Incorrect password Entered.Password should contain lowercase upper case and special character ");
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

        else if(!NIC.matches(NICPattern1) && !NIC.matches(NICPattern2) ){
            this.NIC.setError("NIC is not in correct form according to both and new NIC");
            this.NIC.requestFocus();
            return;
        }

        User user = new User(name, Email, Password, PhoneNo,NIC, Address, UserRole,VehicleNumber,CarNo);

        IUserAPI iuseapi = APIClient.getRetrofit().create(IUserAPI.class);
        Call<ResponseUser> call = iuseapi.CreateUser(user);

        call.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                Log.e("Response", "Response code : "+ response.code());

                if(response.code() == 200){
                    Log.e("Response", "test : "+response.body().getData());
                    Toast.makeText(UserRegistartion.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(login);
                }
                else{
                    Toast.makeText(UserRegistartion.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Toast.makeText(UserRegistartion.this, "SignUp API Called Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}