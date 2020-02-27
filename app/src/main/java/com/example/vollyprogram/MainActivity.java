package com.example.vollyprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.vollyprogram.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String url="http://androindian.com/apps/example_app/api.php";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        requestQueue= Volley.newRequestQueue(MainActivity.this);

        binding.reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("name",binding.name.getText().toString().trim());
                    jsonObject.put("mobile",binding.mobile.getText().toString().trim());
                    jsonObject.put("email",binding.mail.getText().toString().trim());
                    jsonObject.put("pswrd",binding.password.getText().toString().trim());
                    jsonObject.put("baction","register_user");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST, url, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String res = response.getString("response");

                                    if (res.equalsIgnoreCase("failed")) {
                                        String res1 = response.getString("user");
                                        Toast.makeText(MainActivity.this, res1, Toast.LENGTH_SHORT).show();

                                    } else if (res.equalsIgnoreCase("success")) {
                                        String res1 = response.getString("user");
                                        Toast.makeText(MainActivity.this, res1, Toast.LENGTH_SHORT).show();

                                    } else {
                                        String res1 = response.getString("user");
                                        Toast.makeText(MainActivity.this, res1, Toast.LENGTH_SHORT).show();

                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                }
                );
                requestQueue.add(jsonObjectRequest);
            }
        });


    }
}
