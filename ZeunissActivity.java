package erdem.android.mathe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ZeunissActivity extends AppCompatActivity {

    ImageButton btn_Stern1,btn_Stern2,btn_Stern3, btn_Stern4, btn_Stern5;
    Button btn_Reply,btn_HM;
    TextView tv_Ergebnis;
    int auswahl,punkte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeuniss);
        btn_Stern1=findViewById(R.id.btn_Stern1);
        btn_Stern2=findViewById(R.id.btn_Stern2);
        btn_Stern3=findViewById(R.id.btn_Stern3);
        btn_Stern4=findViewById(R.id.btn_Stern4);
        btn_Stern5=findViewById(R.id.btn_Stern5);
        btn_Reply=findViewById(R.id.btn_Reply);
        btn_HM=findViewById(R.id.btn_HM);
        tv_Ergebnis=findViewById(R.id.tv_Ergebnis);

        auswahl=getIntent().getIntExtra("auswahl",0);
        punkte=getIntent().getIntExtra("punkte",0);

        if (punkte<=90){btn_Stern5.setVisibility(View.GONE);}
        if (punkte<=80){btn_Stern4.setVisibility(View.GONE);}
        if (punkte<=70){btn_Stern3.setVisibility(View.GONE);}
        if (punkte<=60){btn_Stern2.setVisibility(View.GONE);}
        if (punkte<=50){btn_Stern1.setVisibility(View.GONE);}
        tv_Ergebnis.setText("Punkte: "+punkte+" / 100");

        btn_Reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZeunissActivity.this,
                        erdem.android.mathe.FrageActivity.class);
                intent.putExtra("auswahl",auswahl);
                startActivity(intent);
            }
        });

        btn_HM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZeunissActivity.this,
                        erdem.android.mathe.MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
