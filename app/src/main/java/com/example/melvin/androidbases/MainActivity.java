package com.example.melvin.androidbases;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.melvin.androidbases.Model.RectangleGeo;

public class MainActivity extends AppCompatActivity {

    private GeometryLayer geometryLayer;
    private EditText widthField;
    private EditText heightField;
    private Button button_draw;
    private Button button_erase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geometryLayer = (GeometryLayer)findViewById(R.id.calque_dessin);
        widthField = (EditText)findViewById(R.id.editTextLargeur);
        heightField = (EditText)findViewById(R.id.editTextHauteur);
        button_draw = (Button)findViewById(R.id.button_draw);
        button_erase = (Button)findViewById(R.id.button_erase);

//        geometryLayer.addRectangleGeo(new RectangleGeo(200, 300));

        button_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawRect(button_draw);
            }
        });

        button_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearLayer(button_erase);
            }
        });
    }

    private int readIntFromField(EditText field) {
        int value = 0;
        try {
            value = Integer.parseInt(field.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return value;
    }

    public void drawRect(View button) {
        int width = readIntFromField(widthField);
        int height = readIntFromField(heightField);
        if (width > 0 && height > 0) {
            geometryLayer.addRectangleGeo(new RectangleGeo(width, height));
        } else {
            Toast.makeText(this, "Saisie incorrecte", Toast.LENGTH_LONG).show();
        }
    }

    public void clearLayer(View button) {
        geometryLayer.eraseList();
    }
}
