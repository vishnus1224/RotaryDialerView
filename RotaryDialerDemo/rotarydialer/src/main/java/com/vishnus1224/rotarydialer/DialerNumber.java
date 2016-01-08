package com.vishnus1224.rotarydialer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/** Represents a number on the rotary dialer.
 * Created by Vishnu on 11/30/2015.
 */
class DialerNumber extends View{

    private int position;
    private Point center;

    private Paint textPaint;
    private Paint backgroundPaint;

    private float circleRadius;

    private static final int NUMBER_TEXT_SIZE = 40;

    public DialerNumber(Context context) {
        super(context);

        initPaint();
    }

    public DialerNumber(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DialerNumber(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public float getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(float circleRadius) {
        this.circleRadius = circleRadius;
    }

    private void initPaint(){

        textPaint = new Paint();
        textPaint.setTextSize(NUMBER_TEXT_SIZE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.GREEN);


        backgroundPaint = new Paint();
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setColor(Color.GRAY);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(center.x, center.y, circleRadius, backgroundPaint);

        // TODO: 12/3/2015 setter for typeface and font size.
        //draw the number on screen.
        canvas.drawText(String.valueOf(position), center.x, center.y + (NUMBER_TEXT_SIZE / 2), textPaint);

    }
    

}
