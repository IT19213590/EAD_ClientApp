package com.example.fuelapp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallApi extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        try{
            URL url = new URL("https://localhost:5001/api/Station");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            result = stringBuilder.toString();
        }catch (Exception e){}
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        System.out.println("result "+ result);
        super.onPostExecute(result);
    }
}
