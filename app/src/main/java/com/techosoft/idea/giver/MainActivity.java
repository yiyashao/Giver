package com.techosoft.idea.giver;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button naviWant;
    Button naviGive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Test: ","Gets to the ON CREATE");
        //declear the buttons and setup listeners
        naviWant = (Button) findViewById(R.id.btnWant);
        naviWant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("Test: ","Gets to the listener");
                goToWantForm();
            }
        });
        naviGive = (Button) findViewById(R.id.btnGive);
        naviGive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goToGiveForm();
            }
        });

    }


    //handle the listener actions
    private void goToWantForm() {
        Log.d("Test: ","Enters the form call");
        Intent intent = new Intent(this, FormWant.class);
        startActivity(intent);
    }

    private void goToGiveForm() {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }


}
