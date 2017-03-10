package com.example.melvin.androidbases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextLargeur = (EditText)findViewById(R.id.editTextLargeur);
        final EditText editTextHauteur = (EditText)findViewById(R.id.editTextHauteur);
        Button buttonDraw = (Button)findViewById(R.id.button_draw);
        Button buttonErase = (Button)findViewById(R.id.button_erase);

        buttonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int largeur = Integer.parseInt(editTextLargeur.getText().toString());
                int hauteur = Integer.parseInt(editTextHauteur.getText().toString());

                System.out.println("button draw clicked");
                System.out.println(largeur);
                System.out.println(hauteur);
            }
        });
    }
}
