package com.braun1792.shippingcalculator;

import java.util.Date;

/**
 * Created by braun1792 on 12/5/2016.
 */
public class PersonnelDatabase {

    public Personnel [] employees = new Personnel[5];

    public PersonnelDatabase(){
        initializeDatabase();
    }

    public void initializeDatabase(){
        employees[0] = new Personnel(101,0,"Amanda B","Moose Jaw, SK","2049909023","amanda@work.com","developer",
                Personnel.Role.STAFF,"Michelle","07-09-1987",false);

        employees[1] = new Personnel(102,1,"Jerry","Regina, SK","3068753490","jerry@work.com","jr developer",
                Personnel.Role.STAFF,"Bill","21-03-1990",false);

        employees[2] = new Personnel(103,0,"Sally","Moose Jaw, SK","3065412389","sally@work.com","dba",
                Personnel.Role.SUPERVISOR,"n/a","08-12-1974",true);

        employees[3] = new Personnel(104,0,"Michelle","Saskatoon, SK","3062558741","michelle@work.com","sr developer",
                Personnel.Role.SUPERVISOR,"n/a","17-10-1980",false);

        employees[4] = new Personnel(105,1,"Carl","Moose Jaw, SK","3067891244","carl@work.com","ops",
                Personnel.Role.STAFF,"Sally","12-07-1982",true);
    }
}
