package com.example.hc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });
        CardView familyPhysician = findViewById(R.id.cardFdFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent in =  new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
             in.putExtra("title","Family Physician");
                startActivity(in);
            }
        });
        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                in.putExtra("title","Dietician");
                startActivity(in);
            }
        });
        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                in.putExtra("title","Dentist");
                startActivity(in);
            }
        });
        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                in.putExtra("title","Surgeon");
                startActivity(in);
            }
        });
        CardView cardiologist = findViewById(R.id.cardFDCardiologists);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                in.putExtra("title","Cardiologists");
                startActivity(in);
            }
        });
    }
}