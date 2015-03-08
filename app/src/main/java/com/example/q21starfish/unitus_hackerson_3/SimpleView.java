package com.example.q21starfish.unitus_hackerson_3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SimpleView extends View {

    private Bitmap bmp;

    public SimpleView(Context context, AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        initialize();
    }

    public SimpleView(Context context, AttributeSet attrs){
        super(context,attrs);
        initialize();
    }

    public SimpleView(Context context){
        super(context);
        initialize();
    }

    public void initialize(){
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.p1);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);
        Paint p = new Paint();
        canvas.scale(0.7f, 0.7f);
        canvas.rotate(60);
        canvas.drawBitmap(bmp,250,100,p);

    }

}
