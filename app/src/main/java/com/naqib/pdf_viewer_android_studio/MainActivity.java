package com.naqib.pdf_viewer_android_studio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnOpenPdf, btnOpenDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
//        btnOpenPdf = findViewById(R.id.btnOpenPdf);
//        btnOpenDoc = findViewById(R.id.btnOpenDoc);

        // Set click listeners for PDF and DOC buttons
        btnOpenPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("application/pdf");
                startActivity(Intent.createChooser(intent, "Open PDF with"));
            }
        });

        btnOpenDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("application/msword");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivity(Intent.createChooser(intent, "Open DOC with"));
            }
        });
    }
}
