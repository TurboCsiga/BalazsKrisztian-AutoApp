package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class SearchResultActivity extends AppCompatActivity {

    private Button Vissza;
    private TextView Kiir;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        Init();
            Cursor adatok = adatbazis.listaz();
            if (adatok.getCount() == 0){
                Toast.makeText(this, "Nincs az adatbázisban bejegyzés", Toast.LENGTH_SHORT).show();
            } else {
                StringBuilder bobTheBuilder = new StringBuilder();
                while (adatok.moveToNext()) {
                    bobTheBuilder.append("ID: ").append(adatok.getInt(0));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Gyártó: ").append(adatok.getString(1));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Modell: ").append(adatok.getString(2));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Üzemben: ").append(adatok.getInt(3));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append(System.lineSeparator());
                }
                Kiir.setText(bobTheBuilder.toString());
            }

        Vissza.setOnClickListener(v -> {
            Intent Insertre = new Intent(SearchResultActivity.this, MainActivity.class);
            startActivity(Insertre);
            finish();
        });
    };

    private void Init(){
        Vissza = findViewById(R.id.btnSearchVissza);
        Kiir = findViewById(R.id.txtSearchKiir);
        adatbazis = new DBHelper(this);
    }
}
