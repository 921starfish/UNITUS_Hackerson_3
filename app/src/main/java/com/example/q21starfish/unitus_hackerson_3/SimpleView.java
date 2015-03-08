package com.example.q21starfish.unitus_hackerson_3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class SimpleView extends View {

    private Bitmap bmp;
    private Point size;

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

        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        size = new Point();
        disp.getSize(size);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);
        Paint p = new Paint();
        canvas.scale(0.7f, 0.7f);
        canvas.rotate((int)(Math.random()*360));
        canvas.drawBitmap(bmp,(int)(Math.random()*size.x),(int)(Math.random()*size.y),p);

    }

}
