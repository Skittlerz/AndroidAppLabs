package com.braun1792.shippingcalculator;

/**
 * Created by acb on 2016-12-04.
 */

public class Painting {

    private String mDescription;
    private int mId;

    public Painting(String descrip, int id){
        mDescription = descrip;
        mId = id;
    }

    public String getDescription(){
        return mDescription;
    }

    public void setDescription(String descrip){
        mDescription = descrip;
    }

    public int getId(){
        return mId;
    }

    public void setId(int id){
        mId = id;
    }
}
