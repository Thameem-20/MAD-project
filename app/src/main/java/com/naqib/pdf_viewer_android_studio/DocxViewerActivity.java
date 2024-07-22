package com.naqib.pdf_viewer_android_studio;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class DocxViewerActivity extends Activity {

    private static final String TAG = "DocxViewerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docx_viewer);

        Intent intent = getIntent();
        Uri uri = intent.getData();

        if (uri != null) {
            try {
                // Create an intent to open the DOCX file using Google Docs Viewer
                Intent viewIntent = new Intent(Intent.ACTION_VIEW, uri);
                viewIntent.setType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                startActivity(viewIntent);
            } catch (Exception e) {
                Log.e(TAG, "Error opening DOCX file", e);
            }
        } else {
            // Handle case where URI is null
            Log.e(TAG, "No document found");
        }
    }
}
