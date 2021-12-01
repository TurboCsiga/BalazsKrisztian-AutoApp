package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {

    private Button btnVissza;
    private TextView txtKiir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        Init();
    }

    private void Init(){
        btnVissza = findViewById(R.id.SearchVissza);
        txtKiir = findViewById(R.id.txtvwKiir);
    }
}