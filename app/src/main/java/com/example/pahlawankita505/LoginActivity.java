package com.example.pahlawankita505;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private ImageButton buttonTogglePassword;
    private boolean passwordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi komponen
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonTogglePassword = findViewById(R.id.buttonTogglePassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        // Logika untuk toggle visibility password
        buttonTogglePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordVisible = !passwordVisible;
                if (passwordVisible) {
                    editTextPassword.setTransformationMethod(null);
                    buttonTogglePassword.setImageResource(R.drawable.eyeline); // Icon untuk password terlihat
                } else {
                    editTextPassword.setTransformationMethod(new PasswordTransformationMethod());
                    buttonTogglePassword.setImageResource(R.drawable.eyeclosed); // Icon untuk password tersembunyi
                }

                // Pindahkan kursor ke akhir teks setelah toggle
                editTextPassword.setSelection(editTextPassword.getText().length());
            }
        });

        // Logika untuk tombol login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Periksa apakah username dan password cocok
                if (username.equals("") && password.equals("")) {
                    // Login berhasil, pindah ke MainActivity
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish(); // Tutup LoginActivity agar tidak bisa kembali ke sini
                } else {
                    // Login gagal, tampilkan pesan kesalahan
                    Toast.makeText(LoginActivity.this, "Username atau Password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}