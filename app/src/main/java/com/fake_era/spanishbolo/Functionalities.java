package com.fake_era.spanishbolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Functionalities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functionalities);
    }

    public void goto_quiz(View view) {
        Intent myIntent = new Intent(this, quiz.class);

        startActivity(myIntent);
    }

    public void to_spanish(View view) {
        Intent myIntent = new Intent(this, toSpanish.class);

        startActivity(myIntent);
    }

    public void tricky_words(View view) {
    }

    public void Notes(View view) {
    }
}
