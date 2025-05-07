package com.example.chapterseven;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalApiActivity extends AppCompatActivity {

    RecyclerView userRecyclerView;
    UserAdapter adapter;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_local_api);
        EditText name=findViewById(R.id.nameInput);
        EditText email=findViewById(R.id.gmailInput);
        Button btn=findViewById(R.id.insertApi);
        userRecyclerView = findViewById(R.id.userRecyclerView);
//        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        userList = new ArrayList<>();
//        adapter = new UserAdapter(userList);
//        userRecyclerView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRecyclerView = findViewById(R.id.userRecyclerView);
                userRecyclerView.setLayoutManager(new LinearLayoutManager(LocalApiActivity.this));
                userList = new ArrayList<>();
                adapter = new UserAdapter(userList);
                userRecyclerView.setAdapter(adapter);

                insertData(name.getText().toString(),email.getText().toString());
                getMultipleUser();

            }
        });


    }
    private void getSingleUser() {
        String url = "http://192.168.120.177:80/php_test/get_user.php?id=1";
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

                            userInfo.append("Name: ").append(name)
                                    .append("\nEmail: ").append(email);



                        } catch (Exception e) {
                            Toast.makeText(LocalApiActivity.this, "Error Parsing the JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LocalApiActivity .this, "Request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }
    public void getMultipleUser() {
        String url = "http://192.168.120.177/php_test/get_users.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                response -> {
                    userList.clear();
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject obj = response.getJSONObject(i);
                            userList.add(new User(obj.getString("name"), obj.getString("email")));
                        }
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        Toast.makeText(this, "Parsing Error", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(this, "Fetch Error: " + error.getMessage(), Toast.LENGTH_SHORT).show()
        );

        requestQueue.add(jsonArrayRequest);
    }



    public void insertData(String name, String email) {
        String url = "http://192.168.120.177/php_test/insert_users.php";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    Toast.makeText(this, "Response: " + response, Toast.LENGTH_LONG).show();
                    getMultipleUser(); // Refresh after insert
                },
                error -> {
                    Toast.makeText(this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }




}