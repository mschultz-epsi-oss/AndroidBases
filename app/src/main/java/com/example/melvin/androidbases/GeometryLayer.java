package com.example.melvin.androidbases;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.melvin.androidbases.Model.RectangleGeo;

import java.util.ArrayList;

public class GeometryLayer extends View {
    private ArrayList<RectangleGeo> listRectangles = new ArrayList<>();

    public GeometryLayer(Context context) {
        super(context);
    }

    public GeometryLayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GeometryLayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GeometryLayer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected void addRectangleGeo(RectangleGeo rectangleGeo) {
//        System.out.println("addRectangleGeo");
        listRectangles.add(rectangleGeo);
        invalidate();
    }

    protected void eraseList() {
        listRectangles.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint brush = new Paint();
        brush.setColor(Color.BLACK);
        brush.setStrokeWidth(5);
        brush.setStyle(Paint.Style.STROKE);
        for (RectangleGeo rect : listRectangles) {
            canvas.drawRect(0, 0, rect.getWidth(), rect.getHeight(), brush);
        }
    }
}
