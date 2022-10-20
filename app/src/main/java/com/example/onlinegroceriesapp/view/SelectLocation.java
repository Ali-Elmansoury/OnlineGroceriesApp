package com.example.onlinegroceriesapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinegroceriesapp.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SelectLocation extends AppCompatActivity {
    Button submit;
    ImageView back;
    ArrayList<String> countries = new ArrayList<String>();
    static String w,z;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_location);
        submit=findViewById(R.id.submit);
        back=findViewById(R.id.back);
        submit.setOnClickListener(view -> {
            Intent intent = new Intent(this,HomeScreen.class);
            intent.putExtra("country",w);
            intent.putExtra("city",z);
            startActivity(intent);
        });
        back.setOnClickListener(view -> {
            finish();
        });

        JsonParser jsonParser = new JsonParser();
        Object obj = jsonParser.parse(loadJSONFile());
        JsonObject jsonObject = (JsonObject) obj;
        for (String x:jsonObject.keySet())
        {
            countries.add(x);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.country);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                w=countries.get(i);
                ArrayList<String>cities=new ArrayList<String>();
                JsonArray jsonArray = (JsonArray) jsonObject.get(countries.get(i));
                for (int j = 0;j<jsonArray.size();j++)
                {
                    cities.add(String.valueOf(jsonArray.get(j)));
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(SelectLocation.this, android.R.layout.simple_spinner_item,cities);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Spinner spinner = findViewById(R.id.city);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        z=cities.get(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public String loadJSONFile() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("countries.json");
            int size = inputStream.available();
            byte[] byteArray = new byte[size];
            inputStream.read(byteArray);
            inputStream.close();
            json = new String(byteArray, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return json;
    }
}
