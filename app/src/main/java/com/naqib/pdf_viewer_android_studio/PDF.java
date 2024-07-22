package com.naqib.pdf_viewer_android_studio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;

public class PDF extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfView = findViewById(R.id.pdfView);

        // Get the Intent that started this activity and extract the data
        Intent intent = getIntent();
        Uri pdfUri = intent.getData();

        if (pdfUri != null) {
            // Load PDF from the provided URI
            pdfView.fromUri(pdfUri).load();
        } else {
            // Handle case where no URI is provided (optional)
            pdfView.fromAsset("AhmadThameemATSresume (5).pdf").load();
        }
    }
}
