package com.example.q21starfish.unitus_hackerson_3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class SampleView extends View {
    Bitmap mBitmap;
    private Paint mPaint;
    private float imageX = 0f;
    private float imageY = 0f;

    public SampleView(Context context) {
        super(context);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //canvasのカラー
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background),0,0,mPaint);
        //アンチエイリアス
        mPaint.setAntiAlias(true);
        //カラー設定（デフォルトはBLACK）
        mPaint.setColor(Color.BLUE);

        //画像表示
        canvas.drawBitmap(mBitmap,
                imageX - mBitmap.getWidth() / 2,
                imageY - mBitmap.getHeight() / 2,
                mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //触る
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            imageX = event.getX();
            imageY = event.getY();
        }
        //触ったままスライド
        else if(event.getAction() == MotionEvent.ACTION_MOVE){
            imageX = event.getX();
            imageY = event.getY();
        }

        //離す
        else if(event.getAction() == MotionEvent.ACTION_UP){
            imageX = event.getX();
            imageY = event.getY();
        }

        // 再描画の指示
        invalidate();

        return true;
    }
}