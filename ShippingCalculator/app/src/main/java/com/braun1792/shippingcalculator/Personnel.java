package com.braun1792.shippingcalculator;

import android.text.Editable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by acb on 2016-12-04.
 */

public class Personnel {

    private int personnelID;
    private int pictureID;
    private String name;
    private String address;
    private String phone;
    private String  email;
    private String position;
    private Role role;
    private String supervisor;
    private Date birthdate;
    private int age;
    private boolean married;

    public Personnel(){}

    public Personnel(int personId, int picId, String name, String address, String phone, String email,
                     String position, Role role, String supervisor, String birthdate, boolean married){
        try {
            setPersonnelID(personId);
            setPictureID(picId);
            setName(name);
            setAddress(address);
            setPhone(phone);
            setEmail(email);
            setPosition(position);
            setRole(role);
            setSupervisor(supervisor);
            setBirthdate(birthdate);
            setMarried(married);
        }catch (ParseException pe){

        }
    }

    public void setPersonnelID(int personnelID){
        this.personnelID = personnelID;
    }

    public int getPersonnelID(){
        return this.personnelID;
    }
    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getBirthdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        String bday = sdf.format(birthdate);
        return bday;
    }

    public void setBirthdate(String birthdate) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            this.birthdate = sdf.parse(birthdate);
            setAge();

    }

    public int getAge(){
        return this.age;
    }

    public void setAge(){

        if(birthdate != null) {
            Date now = new Date();
            Calendar a = getCalendar(birthdate);
            Calendar b = getCalendar(now);
            int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
            if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
                diff--;
            }
            this.age = diff;
        }
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.CANADA);
        cal.setTime(date);
        return cal;
    }


    public enum Role{
        STAFF, SUPERVISOR
    }

}
