package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.security.PrivateKey;

public class InsertActivity extends AppCompatActivity {
    private EditText Gyarto, Modell, Uzemben;
    private Button Felvesz, Vissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Init();


    }

    private void Init(){
        Gyarto = findViewById(R.id.txtInsGyarto);
        Modell = findViewById(R.id.txtInsModell);
        Uzemben = findViewById(R.id.txtInsUzemben);
        Felvesz = findViewById(R.id.btnInsFelvesz);
        Vissza = findViewById(R.id.btnInsVissza);
    }
}