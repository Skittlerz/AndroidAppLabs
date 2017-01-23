package com.braun1792.travelmilescalculator;

/**
 * Created by braun1792 on 1/23/2017.
 */
public class TravelCalculator {

    String toCity;
    String fromCity;
    int distance;
    double price;
    int bonusMiles;

    TravelCalculator(String to, String from){
        this.toCity = to;
        this.fromCity = from;
        this.distance = 0;
        this.price = 0.0;
        this.bonusMiles = 0;
    }

    public int getDistance(){

        if((toCity.equals("Regina") && fromCity.equals("Edmonton")) ||
                ((toCity.equals("Edmonton")) && fromCity.equals("Regina")))
        {
            distance = 691;
        }else if((toCity.equals("Regina") && fromCity.equals("Vancouver")) ||
                ((toCity.equals("Vancouver")) && fromCity.equals("Regina")))
        {
            distance = 1335;
        }if((toCity.equals("Vancouver") && fromCity.equals("Edmonton")) ||
                ((toCity.equals("Edmonton")) && fromCity.equals("Vancouver")))
        {
            distance = 809;
        }

        return distance;

    }

    public double getTicketPrice(){

        if((toCity.equals("Regina") && fromCity.equals("Edmonton")) ||
                ((toCity.equals("Edmonton")) && fromCity.equals("Regina")))
        {
            price = 175.00;
        }else if((toCity.equals("Regina") && fromCity.equals("Vancouver")) ||
                ((toCity.equals("Vancouver")) && fromCity.equals("Regina")))
        {
            price = 245.00;
        }if((toCity.equals("Vancouver") && fromCity.equals("Edmonton")) ||
                ((toCity.equals("Edmonton")) && fromCity.equals("Vancouver")))
        {
            price = 195.00;
        }

        return price;

    }

    public int getBonusMiles(){

        if((toCity.equals("Regina") && fromCity.equals("Edmonton")) ||
                ((toCity.equals("Edmonton")) && fromCity.equals("Regina")))
        {
            bonusMiles = (int) (getDistance() * 0.10);
        }else if((toCity.equals("Regina") && fromCity.equals("Vancouver")) ||
                ((toCity.equals("Vancouver")) && fromCity.equals("Regina")))
        {
            bonusMiles = (int) (getDistance() * 0.18);
        }if((toCity.equals("Vancouver") && fromCity.equals("Edmonton")) ||
                ((toCity.equals("Edmonton")) && fromCity.equals("Vancouver")))
        {
            bonusMiles = (int) (getDistance() * 0.12);
        }

        return bonusMiles;
    }
}
