package erdem.android.mathe;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnAddition, btnSubtraktion,btnMultiplikation,btnDivision;
    int Auswahl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddition=findViewById(R.id.btnAddition);
        btnSubtraktion=findViewById(R.id.btnSubtraktion);
        btnMultiplikation=findViewById(R.id.btnMultiplikation);
        btnDivision=findViewById(R.id.btnDivision);

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        erdem.android.mathe.SchwerigkeitActivity.class);
                intent.putExtra("auswahl",0);
                startActivity(intent);
            }
        });

        btnSubtraktion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        erdem.android.mathe.SchwerigkeitActivity.class);
                intent.putExtra("auswahl",1);
                startActivity(intent);
            }
        });

        btnMultiplikation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        erdem.android.mathe.SchwerigkeitActivity.class);
                intent.putExtra("auswahl",2);
                startActivity(intent);
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        erdem.android.mathe.SchwerigkeitActivity.class);
                intent.putExtra("auswahl",3);
                startActivity(intent);
            }
        });


    }
}
