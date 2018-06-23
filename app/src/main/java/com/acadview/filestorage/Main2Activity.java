package com.acadview.filestorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    TextView name;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name1);
        button = findViewById(R.id.button);



       // data read
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BufferedReader input = null;
                File file = null;

                try{
                    file = getBaseContext().getFileStreamPath("userData");

                   input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                   String line;

                   StringBuffer buffer = new StringBuffer();

                    while ((line = input.readLine())!= null){
                        buffer.append(line).append("\n");

                        }
                    input.close();

                    String data = buffer.toString();
                    name.setText(data);

                    } catch (FileNotFoundException e) {
                    e.printStackTrace();

                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                }
        });

//        //read data
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                BufferedReader input = null;
//                File file = null;
//
//                StringBuilder builder = new StringBuilder();
//
//                try{
//                    file = getBaseContext().getFileStreamPath("userdata");
//
//
//
//                    FileReader reader = new FileReader(file.getPath());
//                    BufferedReader bufferedReader = new BufferedReader(reader);
//
//                    String line;
//                    while ((line = bufferedReader.readLine())!=null){
//                        builder.append(line);
//                    }
//
//                    reader.close();
//
//                }
//                catch (FileNotFoundException e) {
//                    e.printStackTrace();
//
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//                name.setText(builder.toString());
//
//            }
//        });




    }
}
