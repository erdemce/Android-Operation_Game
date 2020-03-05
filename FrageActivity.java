package erdem.android.mathe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FrageActivity extends AppCompatActivity {
    MediaPlayer applause, boos;
    Button btn_Submit;
    TextView tv_Punkte, tv_Frage, tv_WelcheFrage, tv_RichtigoderFalsch, tv_Zeit;
    EditText editAntwort;
    int punkte=0;
    int welchefrage=1;
    boolean next=false;
    Frage frage;
    int auswahl;
    int schwerigkeit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frage);
        applause=MediaPlayer.create(this,R.raw.applause4);
        boos=MediaPlayer.create(this,R.raw.boos1);

        btn_Submit=findViewById(R.id.btnSubmit);
        editAntwort=findViewById(R.id.editAntwort);
        tv_Punkte=findViewById(R.id.tv_Punkte);
        tv_Frage=findViewById(R.id.tv_Frage);
        tv_WelcheFrage=findViewById(R.id.tv_welcheFrage);
        //tv_Zeit=findViewById(R.id.tv_Zeit);
        tv_WelcheFrage.setText(welchefrage+". Frage");
        auswahl=getIntent().getIntExtra("auswahl",0);
        schwerigkeit=getIntent().getIntExtra("schwerigkeit",1);

        frage =new Frage(Fragenart.values()[auswahl],schwerigkeit);
        tv_Frage.setText(frage.getText_Frage());
        btn_Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(editAntwort.getText().toString().trim().equals("")){
                    Toast ccc=Toast.makeText(FrageActivity.this,"Bitte schreib den Antwort als Zahl",
                            Toast.LENGTH_LONG);
                    ccc.setGravity(Gravity.CENTER,Gravity.CENTER,Gravity.CENTER);
                    ccc.show();

                }else{
                int antwort = Integer.parseInt(editAntwort.getText().toString().trim());

                    if (antwort==frage.getAntwort()) {
                        applause.start();
                        Toast aaa=Toast.makeText(getApplicationContext(),"RICHTIG",Toast.LENGTH_LONG);
                        aaa.setGravity(Gravity.CENTER,Gravity.CENTER,Gravity.CENTER);
                        aaa.show();
                        punkte = punkte + 10;

                    } else {
                        boos.start();
                        Toast bbb=Toast.makeText(getApplicationContext(),"FALSCH",Toast.LENGTH_LONG);
                        bbb.setGravity(Gravity.CENTER,Gravity.CENTER,Gravity.CENTER);
                        bbb.show();
                        punkte = punkte - 2;
                    }

                    tv_Punkte.setText(punkte + " Punkte");
                    try {
                    synchronized (this) {
                        wait(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    welchefrage++;
                    if(welchefrage>10){
                        Intent intent = new Intent(FrageActivity.this,
                                erdem.android.mathe.ZeunissActivity.class);
                        intent.putExtra("auswahl",auswahl);
                        intent.putExtra("punkte",punkte);
                        startActivity(intent);
                    } else{
                        tv_WelcheFrage.setText(welchefrage+". Frage");
                        editAntwort.setText("");
                        frage =new Frage(Fragenart.values()[auswahl],schwerigkeit);
                        tv_Frage.setText(frage.getText_Frage());
                }
            }}
        });
    }
}