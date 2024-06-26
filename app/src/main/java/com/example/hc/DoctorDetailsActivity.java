package com.example.hc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {

                    {"Doctor Name: Mutayyab Imran", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: Ali Haider", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name: Imran Khan", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name: Nawaz Sharif", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: Bilal Khan", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details2 =
            {

                    {"Doctor Name: Adeeb ul Hassan", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: mumtaz baagi", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name: ayesha khan", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name: shaikh rasheed", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: shahbaz sahrif", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details3 =
            {

                    {"Doctor Name: Shahrukh shah", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: ikram ali", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name: usman khawaja", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name: muhammad ali", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: naeem irfan", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details4 =
            {

                    {"Doctor Name: Ahsan Sajjad", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: shahbaz shah", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name: qadir patel", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name: Asif khan", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: bhutto shah", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details5 =
            {

                    {"Doctor Name: haseeb siddique", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: Sameer khan", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name: Mahad Khan", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name: Ali khan", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name: Usman Qadir", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No:7798989898", "800"}
            };
    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    SimpleAdapter sa;
    HashMap<String,String> item;
    ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it =getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details =  doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
    }
});

list =new ArrayList();

for (int i=0; i<doctor_details.length;i++){
    item = new HashMap<String, String>();
    item.put("line1",doctor_details[i][0]);
    item.put("line2",doctor_details[i][1]);
    item.put("line3",doctor_details[i][2]);
    item.put("line4",doctor_details[i][3]);
    item.put("line5","Cons Fees: "+doctor_details[i][4] + "/-");
    list.add(item);
}
sa =new SimpleAdapter(this,list,
        R.layout.multi_lines,
        new String[]{"line1","line2","line3","line4","line5"},
        new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}

);
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("Item1",title);

               it.putExtra("Item2",doctor_details[i][0]);
               it.putExtra("Item3",doctor_details[i][1]);
               it.putExtra("Item4",doctor_details[i][3]);
               it.putExtra("Item5",doctor_details[i][4]);
               startActivity(it);
           }
       });

    }
}