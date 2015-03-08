package com.example.q21starfish.unitus_hackerson_3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
    private SampleView mView;
    private Bitmap mBitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.p1);
        mView = new SampleView(this);
        setContentView(mView);
    }

    private class SampleView extends View {
        private Paint mPaint;
        private float imageX = 0f;
        private float imageY = 0f;

        public SampleView(Context context) {
            super(context);
            mPaint = new Paint();
        }


        @Override
        protected void onDraw(Canvas canvas) {
            //canvasのカラー
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.background),0,0,mPaint);
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
}