package com.example.hc;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    TextView tv;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    private Button dateButton,timeButton,btnBook,btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_appointment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        tv = findViewById(R.id.textViewBATitle);
        ed1 = findViewById(R.id.editTextBAFullName);
        ed2 = findViewById(R.id.editTextBAAddress);
        ed3 = findViewById(R.id.editTextBAContact);
        ed4 = findViewById(R.id.editTextBAFee);
        btnBook = findViewById(R.id.buttonBA);
        btnBack = findViewById(R.id.buttonBABack);

        dateButton = findViewById(R.id.buttonBADate);
        timeButton = findViewById(R.id.buttonBATime);


        // Edit Texts Not Editable
        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        // Get Data Through Intent

        Intent it = getIntent();
        String title = it.getStringExtra("Item1");
        String fullName = it.getStringExtra("Item2");
        String address = it.getStringExtra("Item3");
        String contact = it.getStringExtra("Item4");
        String fees = it.getStringExtra("Item5");

        tv.setText(title);
        ed1.setText(fullName);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Fees : " + fees + " /-");

        // DAte Picker
        initDatePicker();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        // Time Picker
        initTimePicker();

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timePickerDialog.show();
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Appointment Loading!", Toast.LENGTH_SHORT).show();

                Database db = new Database(getApplicationContext(),"healthcare",null,1);

                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

               // Toast.makeText(getApplicationContext(), "Appointment Loading 2!", Toast.LENGTH_SHORT).show();


                if (db.checkAppointmentExists(username,fullName,address,contact,0,dateButton.getText().toString(),timeButton.getText().toString())==1){
                    Toast.makeText(getApplicationContext(), "Appointment Already Booked!", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addOrder(username,fullName,address,contact,0,dateButton.getText().toString(),timeButton.getText().toString(),Float.parseFloat(fees),"appointment");
                    Toast.makeText(getApplicationContext(), "Your Appointment is Done Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BookAppointmentActivity.this,HomeActivity.class));
                }

                Toast.makeText(getApplicationContext(), "Appointment Not Booked!", Toast.LENGTH_SHORT).show();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointmentActivity.this,FindDoctorActivity.class));
            }
        });


    }
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2 + "/" + i1 + "/" + i);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);


        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog( this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){

    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
    @Override
    public void onTimeSet (TimePicker timePicker, int i, int i1) {
        timeButton.setText(i+" : "+i1);

    }
    };
    Calendar cal = Calendar.getInstance();
    int hrs = cal.get(Calendar.HOUR);
    int mins = cal.get(Calendar.MINUTE);
    int style = AlertDialog.THEME_HOLO_DARK;
    timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins,  true);

        }

}