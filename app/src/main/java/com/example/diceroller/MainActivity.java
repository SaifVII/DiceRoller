package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.ArrayList;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
int score = 0;
ArrayList<String> questions = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        questions.add("If you could go anywhere in the world, where would you go?");
        questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
        questions.add("If you could eat only one food for the rest of your life, what would that be?");
        questions.add("If you won a million dollars, what is the first thing you would buy?");
        questions.add("If you could spaned the day with one fictional character, who would it be?");
        questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onButtonClick(View view){
        int userguess;
        EditText userinput;
        userinput = this.findViewById(R.id.editText);
        userguess = Integer.valueOf(userinput.getText().toString());

        TextView scoreview = this.findViewById(R.id.score);
        TextView tv = this.findViewById(R.id.numberTextView);

        Random r = new Random();
        int number = r.nextInt(6) + 1;

        tv.setText(Integer.toString(number));

        TextView cong = this.findViewById(R.id.textView2);
        if (number == userguess){
            cong.setTextSize(30);
            cong.setText("Congratulations");
            score++;
            scoreview.setText(Integer.toString(score));
        }
        else{
            cong.setTextSize(30);
            cong.setText("Try Again");

        }


    }
    public void icebreaker(View view) {
        TextView cong = this.findViewById(R.id.textView2);
        Random r = new Random();
        int number = r.nextInt(questions.size());
        cong.setText(questions.get(number));
        cong.setTextSize(10);

    }
    public void addNewIcebreaker(View view) {
        Intent intent = new Intent(this, AddNewIcebreaker.class);
        startActivityForResult(intent, 101);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String newIcebreaker = data.getStringExtra("icebreaker");
        if(!newIcebreaker.equals("0")){
            questions.add(newIcebreaker);
        }
    }

}
