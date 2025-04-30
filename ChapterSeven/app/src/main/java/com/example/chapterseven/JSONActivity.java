package com.example.chapterseven;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jsonactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String jsonString = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            int userId = jsonObject.getInt("userId");
            int id = jsonObject.getInt("id");
            String title = jsonObject.getString("title");
            String body = jsonObject.getString("body");

            Log.d("JSONTest", "\nUserID= " + userId + "\n" + "title= " + title + "\n" + "Body= " + body);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        String jsonArrayString = "[\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 2,\n" +
                "    \"title\": \"qui est esse\",\n" +
                "    \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 3,\n" +
                "    \"title\": \"ea molestias quasi exercitationem repellat qui ipsa sit aut\",\n" +
                "    \"body\": \"et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 4,\n" +
                "    \"title\": \"eum et est occaecati\",\n" +
                "    \"body\": \"ullam et saepe reiciendis voluptatem adipisci\\nsit amet autem assumenda provident rerum culpa\\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\\nquis sunt voluptatem rerum illo velit\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 5,\n" +
                "    \"title\": \"nesciunt quas odio\",\n" +
                "    \"body\": \"repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 6,\n" +
                "    \"title\": \"dolorem eum magni eos aperiam quia\",\n" +
                "    \"body\": \"ut aspernatur corporis harum nihil quis provident sequi\\nmollitia nobis aliquid molestiae\\nperspiciatis et ea nemo ab reprehenderit accusantium quas\\nvoluptate dolores velit et doloremque molestiae\"\n" +
                "  },\n" +
                " ]";
        try {
            JSONArray jsonArray = new JSONArray(jsonArrayString);
            for (int i = 0; i <= jsonArray.length(); i++) {
                JSONObject userObject = jsonArray.getJSONObject(i);
                int userId = userObject.getInt("userId");
                int id = userObject.getInt("id");
                String title = userObject.getString("title");
                String body = userObject.getString("body");

                Log.d("JSONArrayTest", "\nUserID= " + userId + "\nId= " + id + "\n" + "title= " + title + "\n" + "Body= " + body);

            }


        } catch (JSONException e) {
            Log.e("JSON_ERROR", e.getStackTrace().toString());
        }

        String mixed = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Md Noorullah Khan\",\n" +
                "    \"address\": {\n" +
                "        \"street\": \"Dhobighat\",\n" +
                "        \"city\": \"Lalitpur\"\n" +
                "    },\n" +
                "    \"education\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"BCA\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"SEE\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";
        try {
            JSONObject jsonObject = new JSONObject(mixed);
            int id = jsonObject.getInt("id");
            String name = jsonObject.getString("name");
            JSONObject addressObject = jsonObject.getJSONObject("address");
            String street = addressObject.getString("street");
            String city = addressObject.getString("city");
            JSONArray educationArray = jsonObject.getJSONArray("education");
            for (int i = 0; i < educationArray.length(); i++) {
                JSONObject educationObject = educationArray.getJSONObject(i);
                int eduId = educationObject.getInt("id");
                String eduName = educationObject.getString("name");
                Log.d("Education", "id: " + eduId + "\nCourse: " + eduName);
            }
            Log.d("MixedJSONTest",
                    "ID: " + id + "\n" +
                            "Name: " + name + "\n" +
                            "Street: " + street + "\n" +
                            "City: " + city + "\n");

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }
}