package com.example.hc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword,edConfirm;
    TextView tv;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edUsername = findViewById(R.id.editTextRegUsername);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser);


tv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }
});

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String username = edUsername.getText().toString();
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        String confirm = edConfirm.getText().toString();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty() ){
            Toast.makeText(RegisterActivity.this, "Please Fill all details", Toast.LENGTH_SHORT).show();
        }



        else {

            if (password.compareTo(confirm) == 0){
              //  if (isValid(password)){
                    Toast.makeText(RegisterActivity.this, "User Registered !", Toast.LENGTH_SHORT).show();
                //    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                //}
               //else {
                 //  Toast.makeText(RegisterActivity.this, "weak password", Toast.LENGTH_SHORT).show();

               //}

            }
            else {
                Toast.makeText(RegisterActivity.this, "Password Not match!", Toast.LENGTH_SHORT).show();

                edPassword.setText("");
                edConfirm.setText("");

            }

        }
    }
});


    }

}