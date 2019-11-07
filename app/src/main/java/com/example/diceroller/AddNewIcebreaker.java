package com.example.diceroller;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNewIcebreaker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_icebreaker);
    }


    public void cancelButton(View view){
        newIcebreaker(1);
    }
    public void saveButton(View view){
        newIcebreaker(0);
    }
    public void newIcebreaker(int option){
        String icebreaker;
        if(option== 1){
            icebreaker= "0";
        }
        else{
            EditText editText = (EditText) findViewById(R.id.editText);
            icebreaker= editText.getText().toString();
        }
        Intent intent = new Intent();
        intent.putExtra("icebreaker", icebreaker);
        setResult(RESULT_OK, intent);
        finish();
    }
}


