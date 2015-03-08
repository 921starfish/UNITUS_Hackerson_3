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
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class ViewTest extends View {

    private Bitmap[] bmp;
    private Point size;

    public ViewTest(Context context, AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        initialize();
    }

    public ViewTest(Context context, AttributeSet attrs){
        super(context,attrs);
        initialize();
    }

    public ViewTest(Context context){
        super(context);
        initialize();
    }

    public void initialize(){
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        size = new Point();
        disp.getSize(size);
    }

    @Override
    protected void onDraw(Canvas canvas){
        bmp = new Bitmap[12];
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);
        Paint p = new Paint();
        canvas.scale(0.5f, 0.5f);


        bmp[0] = BitmapFactory.decodeResource(getResources(),R.drawable.p1);
        bmp[1] = BitmapFactory.decodeResource(getResources(),R.drawable.p2);
        bmp[2] = BitmapFactory.decodeResource(getResources(),R.drawable.p3);
        bmp[3] = BitmapFactory.decodeResource(getResources(),R.drawable.p4);
        bmp[4] = BitmapFactory.decodeResource(getResources(),R.drawable.p5);
        bmp[5] = BitmapFactory.decodeResource(getResources(),R.drawable.p6);
        bmp[6] = BitmapFactory.decodeResource(getResources(),R.drawable.p7);
        bmp[7] = BitmapFactory.decodeResource(getResources(),R.drawable.p8);
        bmp[8] = BitmapFactory.decodeResource(getResources(),R.drawable.p9);
        bmp[9] = BitmapFactory.decodeResource(getResources(),R.drawable.p10);
        bmp[10] = BitmapFactory.decodeResource(getResources(),R.drawable.p11);
        bmp[11] = BitmapFactory.decodeResource(getResources(),R.drawable.p12);


        for(int i = 0;i<12;i++){
            // canvas.rotate((int)(Math.random()*360));
            int x = (int)(Math.random()*size.x);
            int y = (int)(Math.random()*size.y);
            canvas.drawBitmap(bmp[i], x, y, p);
        }
    }
}
