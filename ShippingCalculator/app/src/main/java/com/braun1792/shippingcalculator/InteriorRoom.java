package com.braun1792.shippingcalculator;

/**
 * Created by braun1792 on 12/20/2016.
 */
public class InteriorRoom {

    static final int WINDOW_AREA = 16;
    static final int DOOR_AREA = 21;
    static final int SQR_FEET_PER_GAL = 275;

    private double mLength;
    private double mWidth;
    private double mHeight;

    private int mDoors;
    private int mWindows;


    public double getmLength() {
        return mLength;
    }

    public void setmLength(double mLength) {
        this.mLength = mLength;
    }

    public double getmWidth() {
        return mWidth;
    }

    public void setmWidth(double mWidth) {
        this.mWidth = mWidth;
    }

    public double getmHeight() {
        return mHeight;
    }

    public void setmHeight(double mHeight) {
        this.mHeight = mHeight;
    }

    public int getmDoors() {
        return mDoors;
    }

    public void setmDoors(int mDoors) {
        this.mDoors = mDoors;
    }

    public int getmWindows() {
        return mWindows;
    }

    public void setmWindows(int mWindows) {
        this.mWindows = mWindows;
    }

    public double wallSurface(){
        return 2*mLength*mHeight + 2*mWidth*mHeight + mLength*mWidth;
    }

    public int doorWindowArea(){
        return mDoors*DOOR_AREA + mWindows*WINDOW_AREA;
    }

    public double surfaceArea(){
        return wallSurface() - doorWindowArea();
    }

    public int gallons(){
        return (int) Math.ceil(surfaceArea()) / SQR_FEET_PER_GAL;
    }
}
