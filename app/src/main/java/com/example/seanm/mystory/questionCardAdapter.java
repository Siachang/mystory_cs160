package com.example.seanm.mystory;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class questionCardAdapter extends RecyclerView.Adapter<questionCardAdapter.questionCardViewHolder> {

    private Context mCtx;
    private List<questionCard> cardList;


    public questionCardAdapter(Context mCtx, List<questionCard> cardList) {
        this.mCtx = mCtx;
        this.cardList = cardList;


        if (cardList.isEmpty()){
            String[] questions = mCtx.getResources().getStringArray(R.array.suggested_questions);
            String q = questions[new Random().nextInt(questions.length)];
            cardList.add(new questionCard("Team myStory", q));
        }


    }

    @Override
    public questionCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.question_cards, null);

        return new questionCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(questionCardViewHolder holder, int position) {
        //getting the card of the specified position
        final questionCard card = cardList.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(card.getName());

        final String msg = card.getMessage();

        holder.answerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    //CONNECT TO CREATE EVENT VIEW
                Intent intent = new Intent(mCtx, createMemory.class);
                intent.putExtra("question", msg);
                mCtx.startActivity(intent);

            }
        });


        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // DELETE QUESTION FROM QUEUE




            }
        });




        holder.textViewMessage.setText(card.getMessage());
        holder.textViewName.setText(card.getName());


    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }


    class questionCardViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewMessage;
        Button answerButton, deleteButton;

        ImageView imageView;

        public questionCardViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);
            imageView = itemView.findViewById(R.id.imageView);
            answerButton = itemView.findViewById(R.id.answerButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }





}


