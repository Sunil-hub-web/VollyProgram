package com.example.vollyprogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.vollyprogram.databinding.LogimPageBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    LogimPageBinding binding;
    String Url=" http://androindian.com/apps/example_app/api.php";
    RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.logim_page);

        binding.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });
        binding.reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject object=new JSONObject();
                try {
                    object.put("mobile",binding.mobile.getText().toString().trim());
                    object.put("pswrd",binding.password.getText().toString().trim());
                    object.put("baction","login_user");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mRequestQueue= Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.POST, Url, object,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
//                                try {
//                                    Toast.makeText(getApplicationContext(),response.getString("response").concat(" "+response
//                                                    //.getString("data"))
//                                           // ,Toast.LENGTH_LONG).show();
//
                                  Toast.makeText(getApplicationContext(),response+"", Toast.LENGTH_SHORT).show();

                                  Intent intent = new Intent(Login.this,ViewPage.class);
                                  startActivity(intent);
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                               // Log.e("Error",""+error);

                                Toast.makeText(getApplicationContext(), "Error"+error, Toast.LENGTH_SHORT).show();

                            }
                        });

                mRequestQueue.add(objectRequest);

            }
        });
    }
}
