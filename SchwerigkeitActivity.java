package erdem.android.mathe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SchwerigkeitActivity extends AppCompatActivity {

    TextView tv_Fragentyp;
    Button btn_Einfach, btn_Mitte, btn_Schwer;
    int auswahl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schwerigkeit);

       tv_Fragentyp=findViewById(R.id.Fragentyp);
       btn_Einfach=findViewById(R.id.btn_Einfach);
       btn_Mitte=findViewById(R.id.btn_Mitte);
       btn_Schwer=findViewById(R.id.btn_Schwer);
       auswahl=getIntent().getIntExtra("auswahl",0);


       btn_Einfach.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(SchwerigkeitActivity.this,
                       erdem.android.mathe.FrageActivity.class);
               intent.putExtra("auswahl",auswahl);
               intent.putExtra("schwerigkeit",1);
               startActivity(intent);
           }
       });

        btn_Mitte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchwerigkeitActivity.this,
                        erdem.android.mathe.FrageActivity.class);
                intent.putExtra("auswahl",auswahl);
                intent.putExtra("schwerigkeit",2);
                startActivity(intent);
            }
        });

        btn_Schwer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchwerigkeitActivity.this,
                        erdem.android.mathe.FrageActivity.class);
                intent.putExtra("auswahl",auswahl);
                intent.putExtra("schwerigkeit",3);
                startActivity(intent);
            }
        });


    }
}
