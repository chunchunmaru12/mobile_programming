package com.example.chapterseven;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_api_example);
        getMultipleUser();
    }

    private void getSingleUser() {
        String url = "https://jsonplaceholder.typicode.com/users/10";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            StringBuilder userInfo = new StringBuilder();

                            String name = response.getString("name");
                            String email = response.getString("email");
                            String phone = response.getString("phone");

                            // Append details to StringBuilder
                            userInfo.append("Name: ").append(name)
                                    .append("\nEmail: ").append(email)
                                    .append("\nPhone: ").append(phone);

                            TextView placeHolder = findViewById(R.id.textUser);
                            placeHolder.setText(userInfo.toString());

                        } catch (Exception e) {
                            Toast.makeText(ApiExampleActivity.this, "Error Parsing the JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ApiExampleActivity.this, "Request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }
    public void getMultipleUser(){
        String url = "https://jsonplaceholder.typicode.com/users";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArrayResponse) {
                        try {
                            StringBuilder userInfo = new StringBuilder();


                            for(int i =0;i<=jsonArrayResponse.length();i++){
                               JSONObject response=jsonArrayResponse.getJSONObject(i);
                               String name= response.getString("name");
                                String email = response.getString("email");
                                String phone = response.getString("phone");

                                userInfo.append("\nName: ").append(name)
                                        .append("\nEmail: ").append(email)
                                        .append("\nPhone: ").append(phone);
                            }
                            TextView placeHolder = findViewById(R.id.textUser);
                            placeHolder.setText(userInfo.toString());

                        } catch (Exception e) {
                            Toast.makeText(ApiExampleActivity.this, "Error Parsing the JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ApiExampleActivity.this, "Request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);


    }


}