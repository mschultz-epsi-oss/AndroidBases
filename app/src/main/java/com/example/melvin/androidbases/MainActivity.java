package com.example.melvin.androidbases;

import android.content.Context;
import android.graphics.Canvas;
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

        final Context context = getApplicationContext();
        final Canvas canvas = new Canvas();

        final EditText editTextLargeur = (EditText)findViewById(R.id.editTextLargeur);
        final EditText editTextHauteur = (EditText)findViewById(R.id.editTextHauteur);
        Button buttonDraw = (Button)findViewById(R.id.button_draw);
        Button buttonErase = (Button)findViewById(R.id.button_erase);

        buttonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String largeurStr = editTextLargeur.getText().toString();
                String hauteurStr = editTextHauteur.getText().toString();

                if (!(largeurStr.equals("") || hauteurStr.equals(""))) {
                    Integer largeur = Integer.parseInt(largeurStr);
                    Integer hauteur = Integer.parseInt(hauteurStr);

                    System.out.println(largeur);
                    System.out.println(hauteur);

                    RectangleGeo rectangleGeo = new RectangleGeo();
                    rectangleGeo.setHauteur(hauteur);
                    rectangleGeo.setLargeur(largeur);
                    System.out.println(rectangleGeo);

                    GeometryLayer geometryLayer = new GeometryLayer(context);
                    geometryLayer.addRectangleGeo(rectangleGeo);
                    System.out.println(geometryLayer);
                    System.out.println(geometryLayer.listRectangles.size());

//                    geometryLayer.onDraw(canvas);
                } else {
                    System.out.println("Please set width and height");
                }

                System.out.println("button draw clicked");
            }
        });
    }
}
