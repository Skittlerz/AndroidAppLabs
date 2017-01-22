package com.comp259.acb.autocalc;


/**
 * Created by acb on 2016-12-21.
 */

public class Auto{

    static final double STATE_TAX = .07;
    static final double INTEREST_RATE = .09;

    private double mPrice;
    private double mDownPayment;
    private int mLoanTerm;

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public double getmDownPayment() {
        return mDownPayment;
    }

    public void setmDownPayment(double mDownPayment) {
        this.mDownPayment = mDownPayment;
    }

    public int getmLoanTerm() {
        return mLoanTerm;
    }

    public void setmLoanTerm(String term) {

        if(term.contains("2")){
            mLoanTerm = 2;
        }else if (term.contains("3")){
            mLoanTerm = 3;
        }else {
            mLoanTerm = 4;
        }
    }

    public double taxAmount(){
        return mPrice * STATE_TAX;
    }

    public double totalCost(){
        return mPrice + taxAmount();
    }
    public double borrowedAmount(){
        return totalCost() - mDownPayment;
    }

    public double interestAmount(){
        return borrowedAmount() * INTEREST_RATE;
    }

    public double monthlyPayment(){
        return borrowedAmount() / (mLoanTerm * 12);
    }
}
