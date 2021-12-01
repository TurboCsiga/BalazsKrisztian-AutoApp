package com.example.mainactivity;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private EditText Gyarto, Modell, Uzemben;
    private Button Felvesz, Vissza;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Init();

        Vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Kereses = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(Kereses);
                finish();
            }
        });
        Felvesz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gyarto = Gyarto.getText().toString().trim();
                String modell = Modell.getText().toString().trim();
                String uzemben = Uzemben.getText().toString().trim();
                if (gyarto.isEmpty() || modell.isEmpty() || uzemben.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Minden mező kitöltése kötelező",
                            Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        if (adatbazis.rogzites(gyarto, modell, uzemben)) {
                            Toast.makeText(getApplicationContext(), "Sikeres rögzítés",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sikeretelen rögzítés",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException ex) {
                        Toast.makeText(getApplicationContext(), "Az üzemidőnek számnak kell lennie",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void Init(){
        Gyarto = findViewById(R.id.txtInsGyarto);
        Modell = findViewById(R.id.txtInsModell);
        Uzemben = findViewById(R.id.txtInsUzemben);
        Felvesz = findViewById(R.id.btnInsFelvesz);
        Vissza = findViewById(R.id.btnInsVissza);
        adatbazis = new DBHelper(this);
    }
}