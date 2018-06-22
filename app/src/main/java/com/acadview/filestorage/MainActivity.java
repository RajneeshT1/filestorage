package com.acadview.filestorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText name, email, phone, city;
    Button button;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.text);
        city = findViewById(R.id.city);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);

        String[] state = {"haryana", "himachal", "punjab"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, state);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);


                String userName = name.getText().toString();
                String userEmail = email.getText().toString();
                String userPhone = phone.getText().toString();
                String userCity = city.getText().toString();
                String spinnerData = spinner.getSelectedItem().toString();

                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("Required Filed");
                    return;

                }
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Required Filed");
                    return;

                }
                if (TextUtils.isEmpty(phone.getText().toString())) {
                    phone.setError("Required Filed");
                    return;

                }
                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("Required Filed");
                    return;

                }
                if (TextUtils.isEmpty(city.getText().toString())) {
                    city.setError("Required Filed");
                    return;

                }
                //write data

                String totalData = "Name : " + userName + "\n" + "Email : " + userEmail + "\n" + "Phone : " + userPhone + "\n" + "City : " + userCity + "\n" + "SpinnerData : " + spinnerData ;

                FileOutputStream fos;
                try {

                    fos = openFileOutput("userData", MODE_PRIVATE);
                    fos.write(totalData.getBytes());

                    fos.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                startActivity(intent);
            }


        });

    }
}
