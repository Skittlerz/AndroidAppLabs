package com.braun1792.shippingcalculator;

/**
 * Created by acb on 2016-11-29.
 */

public class Burger {
    static final int BEEF = 100;
    static final int VEGGIE = 170;
    static final int CHICKPEA = 150;
    static final int PROSCIUTTO = 115;
    static final int ASIAGO = 90;
    static final int CREMEFRAICHE = 120;

    private int mPattyCal;
    private int mCheeseCal;
    private int mProsciuttoCal;
    private int mSauceCal;

    public Burger(){
        mPattyCal = BEEF;
        mCheeseCal = ASIAGO;
        mProsciuttoCal = 0;
        mSauceCal = 0;
    }

    public void setPattyCalories(int calories){
        mPattyCal = calories;
    }

    public void setCheeseCalories(int calories){
        mCheeseCal = calories;
    }

    public void setProsciuttoCalories(int calories){
        mProsciuttoCal = calories;
    }

    public void clearProsciuttoCalories(){
        mProsciuttoCal = 0;
    }

    public void setSauceCal(int calories){
        mSauceCal = calories;
    }

    public int getTotalCalories(){
        return mCheeseCal + mSauceCal + mPattyCal + mProsciuttoCal;
    }
}
