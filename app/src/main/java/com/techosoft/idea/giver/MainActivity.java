package com.techosoft.idea.giver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //some code to start with
        try{

            final Button buttonSendWantedRequest= (Button) this.findViewById(R.id.buttonSendWantedRequest);
            buttonSendWantedRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "hello world!", Toast.LENGTH_SHORT).show();
                    backToList();
                    kill_activity();
                }
            });

        }catch(Exception e){

        }
    }

    public void backToList(){
        Intent intent = new Intent(this, NaviList.class);
        String aMessage = "This is a message";
        intent.putExtra(EXTRA_MESSAGE, aMessage);
        startActivity(intent);

        /*Intent intent = new Intent(OldActivity.this, NewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);*/
    }

    void kill_activity(){
        finish();
    }
}
