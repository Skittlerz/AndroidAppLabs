package com.braun1792.shippingcalculator;

/**
 * Created by braun1792 on 11/14/2016.
 */
public class ShipItem {

    //shipping constants
    static final double BASE = 3.0;
    static final double ADDED = .50;
    static final int BASE_WEIGHT = 16;
    static final double EXTRA_OUNCES = 4.0;

    //data members
    private Integer mWeight;
    private Double mBaseCost;
    private Double mAddedCost;
    private Double mTotalCost;

    public ShipItem(){
        mWeight = 0;
        mBaseCost = BASE;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
    }

    public void setWeight(int weight){
        mWeight = weight;
        computeCosts();
    }

    public void computeCosts(){
        mAddedCost = 0.0;
        mBaseCost = BASE;

        if (mWeight <= 0){
            mBaseCost = 0.0;
        }else if (mWeight > BASE_WEIGHT){
            mAddedCost = Math.ceil((double)(mWeight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED;
        }

        mTotalCost = mBaseCost + mAddedCost;
    }

    public double getBaseCost(){
        return mBaseCost;
    }

    public double getAddedCost(){
        return mAddedCost;
    }

    public double getTotalCost(){
        return mTotalCost;
    }
}
