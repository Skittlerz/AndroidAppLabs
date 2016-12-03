package com.braun1792.shippingcalculator;

/**
 * Created by acb on 2016-12-03.
 */

public class SimpleExpression {

    private Integer mOperand1;
    private Integer mOperand2;
    private String mOperator;
    private Integer mValue;

    public SimpleExpression(){
        mOperand1 = 0;
        mOperand2 = 0;
        mOperator = "+";
        mValue = 0;
    }

    public void setOperand1(int v){
        mOperand1 = v;
    }

    public int getOperand1(){
        return mOperand1;
    }

    public void setOperand2(int v){
        mOperand2 = v;
    }

    public int getOperand2(){
        return mOperand2;
    }

    public void setOperator(String op){
        mOperator = op;
    }

    public String getOperator(){
        return mOperator;
    }

    public Integer getValue(){
        computeValue();
        return mValue;
    }

    public void clearOperands(){
        setOperand1(0);
        setOperand2(0);
    }

    public void computeValue(){
        mValue = 0;
        if(mOperator.contentEquals("+")){
            mValue = mOperand1 + mOperand2;
        }else if(mOperator.contentEquals("-")){
            mValue = mOperand1 - mOperand2;
        }else if(mOperator.contentEquals("*")){
            mValue = mOperand1 * mOperand2;
        }else if(mOperator.contentEquals("/") && mOperand2 != 0){
            mValue = mOperand1 / mOperand2;
        }else{
            mValue = mOperand1 % mOperand2;
        }
    }

}
