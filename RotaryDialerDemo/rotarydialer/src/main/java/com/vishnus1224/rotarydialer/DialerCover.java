package com.vishnus1224.rotarydialer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Represents the cover on top of the dialer numbers that rotates when dialing.
 * Created by Vishnu on 12/3/2015.
 */
class DialerCover extends View{

    private Point center;
    private float radius;

    private Paint coverPaint;
    private Paint holePaint;

    private int coverWidth;
    private int coverHeight;

    private DialerNumber[] dialerNumbers;

    double angle = 0;

    public DialerCover(Context context) {
        super(context);
        initPaints();
    }

    public DialerCover(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DialerCover(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public DialerNumber[] getDialerNumbers() {
        return dialerNumbers;
    }

    public void setDialerNumbers(DialerNumber[] dialerNumbers) {
        this.dialerNumbers = dialerNumbers;
    }

    public int getCoverWidth() {
        return coverWidth;
    }

    public void setCoverWidth(int coverWidth) {
        this.coverWidth = coverWidth;
    }

    public int getCoverHeight() {
        return coverHeight;
    }

    public void setCoverHeight(int coverHeight) {
        this.coverHeight = coverHeight;
    }

    private void initPaints(){

        coverPaint = new Paint();
        coverPaint.setAntiAlias(true);
        coverPaint.setStyle(Paint.Style.FILL);
        coverPaint.setColor(Color.GREEN);

        holePaint = new Paint();
        holePaint.setAntiAlias(true);
        holePaint.setTextSize(30);
        holePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }


    @Override
    protected void onDraw(Canvas canvas) {

        // TODO: 12/3/2015 check setting of bitmap as the background. Allocate in the init method.

        Bitmap bmp = Bitmap.createBitmap(coverWidth, coverHeight, Bitmap.Config.ARGB_8888);

        Canvas c = new Canvas(bmp);

        c.drawCircle(center.x, center.y, radius, coverPaint);
        c.save();

        //rotate the cover by the specified angle as it moved by the user in the touch event.
        c.rotate((float)angle, center.x, center.y);

        int size = dialerNumbers.length;

        //draw holes in the bitmap so that numbers below the cover can be seen.
        for(int i = 0; i < size; ++i){
            DialerNumber dialerNumber = dialerNumbers[i];
            c.drawCircle(dialerNumber.getCenter().x, dialerNumber.getCenter().y, dialerNumber.getCircleRadius(), holePaint);
        }

        c.restore();

        canvas.drawBitmap(bmp, 0, 0, null);
    }

}
