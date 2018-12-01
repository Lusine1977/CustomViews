package com.example.lusine.customviews;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

    public static final String TAG = "CustomTextView";

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    private Path path = new Path();


    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);

    }

    private boolean moving = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());

                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());

                break;
            case MotionEvent.ACTION_UP:

        }
        invalidate();
        return true;
    }
}



