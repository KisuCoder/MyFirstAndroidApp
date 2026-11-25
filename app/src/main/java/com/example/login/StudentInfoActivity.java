package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_student_info);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnLogout).getRootView(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvUsername = findViewById(R.id.tvUsername);
        TextView tvStudentNumber = findViewById(R.id.tvStudentNumber);
        TextView tvStudentName = findViewById(R.id.tvStudentName);
        TextView tvProgram = findViewById(R.id.tvProgram);
        TextView tvYearLevel = findViewById(R.id.tvYearLevel);
        Button btnLogout = findViewById(R.id.btnLogout);

        // Retrieve username from intent if passed
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        if (username != null && !username.isEmpty()) {
            tvUsername.setText(username);
        }

        // Set declared student number and student details
        tvStudentNumber.setText("2024-1002289");
        tvStudentName.setText("Manalang, Wil Conrad L.");
        tvProgram.setText("BSCS-ML");
        tvYearLevel.setText("3rd Year");

        btnLogout.setOnClickListener(v -> {
            Intent loginIntent = new Intent(StudentInfoActivity.this, MainActivity.class);
            loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(loginIntent);
            finish();
        });
    }
}
