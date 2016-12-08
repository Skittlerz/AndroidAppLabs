package com.braun1792.shippingcalculator;

import android.os.Bundle;
import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.braun1792.shippingcalculator.Personnel.*;

import java.text.ParseException;

/**
 * Created by acb on 2016-12-04.
 */

public class MyActivity extends AppCompatActivity{

    ImageView ivIcon;
    EditText etId;
    EditText etName;
    EditText etAddress;
    EditText etPhone;
    EditText etEmail;
    EditText etBirthdate;
    TextView tvAge;
    Spinner mSpinner;
    EditText etPositon;
    Spinner rSpinner;
    EditText etSupervisor;
    Button btnNext;
    Button btnPrevious;
    private static final String TAG = ".MyActivity";

    ArrayAdapter<CharSequence> mAdapter;
    ArrayAdapter<CharSequence> rAdapter;

    PersonnelDatabase pd;

    int record;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);

        //set views
        ivIcon = (ImageView) findViewById(R.id.ivIcon);
        etId = (EditText) findViewById(R.id.etId);
        etName = (EditText) findViewById(R.id.etName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etBirthdate = (EditText) findViewById(R.id.etBirthdate);
        tvAge = (TextView) findViewById(R.id.tvAgeNumber);
        etPositon = (EditText) findViewById(R.id.etPosition);
        etSupervisor = (EditText) findViewById(R.id.etSupervisor);
        mSpinner = (Spinner) findViewById(R.id.spnMarried);
        rSpinner = (Spinner) findViewById(R.id.spnRole);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrevious = (Button) findViewById(R.id.btnPrev);

        //Set the married spinner
        mAdapter = ArrayAdapter.createFromResource(this,R.array.married_array, android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);

        //set the role spinner
        rAdapter = ArrayAdapter.createFromResource(this,R.array.role_array, android.R.layout.simple_spinner_item);
        rAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rSpinner.setAdapter(rAdapter);

        registerListeners();

        //create the database and set record
        pd = new PersonnelDatabase();
        record = 0;

        showRecord(record);
    }

    public View.OnClickListener pagination = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnNext:
                    nextRecord();
                    break;
                case R.id.btnPrev:
                    previousRecord();
                    break;
            }
        }
    };

    public AdapterView.OnItemSelectedListener dropDownOptions = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            switch(adapterView.getId()) {
                case R.id.spnMarried:
                    boolean married = false;
                    if (i == 0) {
                        married = true;
                    }
                    pd.employees[record].setMarried(married);
                    break;
                case R.id.spnRole:
                    Role role;
                    if(i == 0){
                        role = Role.STAFF;
                    }else{
                        role = Role.SUPERVISOR;
                    }
                    pd.employees[record].setRole(role);
                    break;
            }
            //Toast used for debugging
            //Toast.makeText(getApplicationContext(), "married:"+pd.employees[record].isMarried() +
            //" role:" + pd.employees[record].getRole(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    public void registerListeners(){

        btnNext.setOnClickListener(pagination);
        btnPrevious.setOnClickListener(pagination);
        mSpinner.setOnItemSelectedListener(dropDownOptions);
        rSpinner.setOnItemSelectedListener(dropDownOptions);
    }

    public void showRecord(int r){

        etId.setText(Integer.toString(pd.employees[r].getPersonnelID()));
        etName.setText(pd.employees[r].getName());
        etAddress.setText(pd.employees[r].getAddress());
        etPhone.setText(pd.employees[r].getPhone());
        etEmail.setText(pd.employees[r].getEmail());
        etBirthdate.setText(pd.employees[r].getBirthdate());
        tvAge.setText(Integer.toString(pd.employees[r].getAge()));
        etPositon.setText(pd.employees[r].getPosition());
        etSupervisor.setText(pd.employees[r].getSupervisor());
        ivIcon.setImageResource(pd.employees[r].getPictureID());

        //if(pd.employees[r].getPictureID() == 0){
            //ivIcon.setImageResource(R.drawable.female);
        //}else{
            //ivIcon.setImageResource(R.drawable.male);
        //}

        if(pd.employees[r].isMarried()){
            mSpinner.setSelection(0);
        }else{
            mSpinner.setSelection(1);
        }


        if(pd.employees[r].getRole() == Role.STAFF){
            rSpinner.setSelection(0);
        }else{
            rSpinner.setSelection(1);
        }

    }

    public void saveRecord(int r){
        try {
            pd.employees[r].setPersonnelID(Integer.parseInt(etId.getText().toString()));
            pd.employees[r].setName(etName.getText().toString());
            pd.employees[r].setAddress(etAddress.getText().toString());
            pd.employees[r].setPhone(etPhone.getText().toString());
            pd.employees[r].setEmail(etEmail.getText().toString());
            pd.employees[r].setBirthdate(etBirthdate.getText().toString());
            pd.employees[r].setPosition(etPositon.getText().toString());
            pd.employees[r].setSupervisor(etSupervisor.getText().toString());

            }catch (ParseException pe){
                Log.e(TAG, "Error parsing birthdate");
        }
    }

    public void nextRecord(){

        saveRecord(record);

        if(record < pd.employees.length-1){
            record++;
        } else {
            record = 0;
        }

        showRecord(record);
    }

    public void previousRecord(){

        saveRecord(record);

        if(record == 0){
            record = pd.employees.length-1;
        }else{
            record--;
        }

        showRecord(record);
    }


}
