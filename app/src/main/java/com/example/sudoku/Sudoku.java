package com.example.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Sudoku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up click listener for the About button
        findViewById(R.id.about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutActivity();
            }
        });

        // Handling Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to start the About activity
    private void openAboutActivity() {
        Intent intent = new Intent(Sudoku.this, About.class);
        startActivity(intent);
    }

    // Inflate the menu when the activity is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); // Assuming you have a menu.xml file under res/menu
        return true;
    }

    // Handle menu item selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            openSettingsActivity(); // Method to open Settings activity
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    // Method to start the Settings activity
    private void openSettingsActivity() {
        Intent intent = new Intent(Sudoku.this, Settings.class);
        startActivity(intent);
    }
}
