package com.example.melvin.androidbases;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GeometryLayer extends View {
    Paint paint = new Paint();
    List<RectangleGeo> listRectangles = new ArrayList<>();

    public GeometryLayer(Context context) {
        super(context);
        init();
    }

    public GeometryLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public GeometryLayer(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init();
    }

    private void init() {
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    protected void addRectangleGeo(RectangleGeo rectangleGeo) {
        listRectangles.add(rectangleGeo);
    }

    protected void eraseList() {
        listRectangles.clear();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (RectangleGeo rectangle : listRectangles) {
            canvas.drawRect(rectangle.getHauteur(), rectangle.getHauteur(), rectangle.getLargeur(), rectangle.getLargeur(), paint);
        }

        invalidate();
    }
}
