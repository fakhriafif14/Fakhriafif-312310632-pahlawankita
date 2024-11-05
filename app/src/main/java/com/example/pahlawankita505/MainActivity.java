package com.example.pahlawankita505;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Array of button IDs for easier initialization
        int[] buttonIds = {
                R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
                R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10
        };

        // Set up click listeners for each button
        for (int i = 0; i < buttonIds.length; i++) {
            int index = i + 1; // 1 through 10
            Button button = findViewById(buttonIds[i]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    // Set destination activity based on index
                    if (index % 2 == 0) { // contoh logika: genap ke isitext2
                        intent = new Intent(MainActivity.this, isitext2.class);
                    } else { // ganjil ke isitext
                        intent = new Intent(MainActivity.this, isitext.class);
                    }
                    intent.putExtra("PAHLAWAN_INDEX", index); // Pass the index to the next activity
                    startActivity(intent);
                }
            });
        }

        // Initialize and set listener for the logout button
        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the logout action, e.g., go back to login activity
                Intent logoutIntent = new Intent(MainActivity.this, LoginActivity.class);
                logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(logoutIntent);
                finish(); // Finish MainActivity so it is removed from the back stack
            }
        });
    }
}
