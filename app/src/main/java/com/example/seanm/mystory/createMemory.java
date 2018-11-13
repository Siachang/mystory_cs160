package com.example.seanm.mystory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class createMemory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_memory);


        Intent intent = getIntent();

        if (intent.hasExtra("question")) {
            String question = intent.getStringExtra("question");
            TextView title = findViewById(R.id.memoryTitle);
            title.setText(question);
        } else {
            // Do something else
        }


        Button cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        Button save = findViewById(R.id.saveButton);
        // IMPLEMENT SAVE BUTTON



    }
}
