package com.vishnus1224.rotarydialer;

/**
 * Created by Vishnu on 12/6/2015.
 */
class Util {


    /**
     * Detect if the given point lies in the circle.
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @param dialerNumber The circle represented as a number on the dialer.
     * @return true if point is inside the circle specified by the dialer number, false otherwise.
     */
    public static boolean pointLiesInCircle(float x, float y, DialerNumber dialerNumber){

        float deltaX = Math.abs(dialerNumber.getCenter().x - x);

        if(deltaX > dialerNumber.getCircleRadius()){
            return false;
        }

        float deltaY = Math.abs(dialerNumber.getCenter().y - y);

        if(deltaY > dialerNumber.getCircleRadius()){
            return false;
        }

        if(deltaX + deltaY <= dialerNumber.getCircleRadius()){
            return true;
        }

        return (deltaX * deltaX + deltaY * deltaY <= dialerNumber.getCircleRadius() * dialerNumber.getCircleRadius());
    }

    /**
     * Determines the angle between two points from the center is degrees.
     * @param x1 The x coordinate of the first point.
     * @param y1 The y coordinate of the first point.
     * @param x2 The x coordinate of the second point.
     * @param y2 The y coordinate of the second point.
     * @param centerX The x coordinate of the center point.
     * @param centerY The y coordinate of the center point.
     * @return The angle in degrees between the supplied points.
     */
    public static double angleBetweenPointsInDegrees(float x1, float y1, float x2, float y2, float centerX, float centerY){

        double firstAngle = Math.atan2(y1 - centerY, x1 - centerX);
        double secondAngle = Math.atan2(y2 - centerY, x2 - centerX);

        return Math.toDegrees(secondAngle - firstAngle);
    }


    /**
     * Checks if the point lies between two circles.
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @param centerX The x coordinate of the center.
     * @param centerY The y coordinate of the center.
     * @param radiusInnerCircle Radius of the smaller circle.
     * @param radiusOuterCircle Radius of the larger circle.
     * @return true if the point is in between the two circles, false otherwise.
     */
    public static boolean pointLiesBetweenCircles(float x, float y, float centerX, float centerY, float radiusInnerCircle, float radiusOuterCircle){

        float deltaX = Math.abs(centerX - x);

        if(deltaX > radiusOuterCircle && deltaX < radiusInnerCircle){
            return false;
        }

        float deltaY = Math.abs(centerY - y);

        if(deltaY > radiusOuterCircle && deltaY < radiusInnerCircle){
            return false;
        }

        float deltaXSquared = deltaX * deltaX;
        float deltaYSquared = deltaY * deltaY;

        return (deltaXSquared + deltaYSquared <= radiusOuterCircle * radiusOuterCircle) && (deltaXSquared + deltaYSquared >= radiusInnerCircle * radiusInnerCircle);
    }

}
