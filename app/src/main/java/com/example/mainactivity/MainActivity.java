package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnKeres, btnUj;
    private EditText Gyarto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();

        btnKeres.setOnClickListener(v -> {
            Intent Kereses = new Intent(MainActivity.this, SearchResultActivity.class);
            startActivity(Kereses);
            finish();
        });
        btnUj.setOnClickListener(v -> {
            Intent Insertre = new Intent(MainActivity.this, InsertActivity.class);
            startActivity(Insertre);
            finish();
        });
    }

    private void Init() {
        btnKeres = findViewById(R.id.btnMainKeres);
        btnUj = findViewById(R.id.btnMainUj);
        Gyarto = findViewById(R.id.txtGyarto);
    }
}