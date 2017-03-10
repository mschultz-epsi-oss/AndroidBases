package com.example.melvin.androidbases;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GeometryLayer extends View {
    List<RectangleGeo> list = new ArrayList<>();
    Paint rectangle = new Paint();

    public GeometryLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void addRectangleGeo(RectangleGeo rectangleGeo) {
        list.add(rectangleGeo);
    }

    protected void eraseList() {
        list.clear();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(30, 30, 80, 80, rectangle);
    }
}
