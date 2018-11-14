package com.example.seanm.mystory;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class QuestionsActivity extends AppCompatActivity {




    private ArrayList<questionCard> questions;
    private questionCardAdapter adapter;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        questions = new ArrayList<>();
        context = this;




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //RETRIEVE QUESTIONS


        initRecyclerView(questions);
    }



    private void initRecyclerView(ArrayList<questionCard> questions) {

        //getting the recyclerview from xml
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //creating recyclerview adapter
        adapter = new questionCardAdapter(this, questions);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

}
