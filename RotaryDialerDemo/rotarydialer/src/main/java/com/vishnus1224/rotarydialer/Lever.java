package com.vishnus1224.rotarydialer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/** Represents the finger stopper on the rotary dialer.
 * Created by Vishnu on 12/12/2015.
 */
class Lever extends View {

    private float centerX;
    private float centerY;

    private float dialerRadius;

    private RectF locationRect = new RectF();

    private Paint leverPaint;

    public Lever(Context context) {
        super(context);
        initPaint();
    }

    public Lever(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Lever(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getDialerRadius() {
        return dialerRadius;
    }

    public void setDialerRadius(float dialerRadius) {
        this.dialerRadius = dialerRadius;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public RectF getLocationRect() {
        return locationRect;
    }

    public void setLocationRect(RectF locationRect) {
        this.locationRect = locationRect;
    }

    private void initPaint(){
        leverPaint = new Paint();
        leverPaint.setAntiAlias(true);
        leverPaint.setStrokeWidth(50);
        leverPaint.setStyle(Paint.Style.FILL);
        leverPaint.setColor(Color.BLUE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: allocate in the constructor.
        Bitmap stopper = BitmapFactory.decodeResource(getResources(), R.drawable.stopper);


        float x  = (float) (centerX + dialerRadius * Math.cos(Math.toRadians(45)));
        float y  = (float) (centerY + dialerRadius * Math.sin(Math.toRadians(45)));

        int left = (int) (centerX + dialerRadius /2);
        int top = (int) (centerY + Math.abs(y - centerY) / 2);

        int bitmapWidth = (int) (dialerRadius * 0.5f);

        int bitmapHeight = (int) (Math.abs(y - centerY) * 0.5f);

        Bitmap resizedBitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888);

        Canvas c = new Canvas(resizedBitmap);

        Rect source = new Rect(0, 0, stopper.getWidth(), stopper.getHeight());

        Rect dest = new Rect(0, 0, bitmapWidth, bitmapHeight);

        c.drawBitmap(stopper, source, dest, null);

        locationRect.set(left, top, left + bitmapWidth, top + bitmapHeight);

        canvas.drawBitmap(resizedBitmap, left, top, null);

    }

}
