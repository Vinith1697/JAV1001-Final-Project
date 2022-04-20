package com.example.contactbook;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList person_id, person_name, person_contact;

    CustomAdapter(Activity activity, Context context, ArrayList person_id, ArrayList person_name, ArrayList person_contact){
        this.activity = activity;
        this.context = context;
        this.person_id = person_id;
        this.person_name = person_name;
        this.person_contact = person_contact;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        //setting the values of person
        holder.person_id_txt.setText(String.valueOf(person_id.get(position)));
        holder.person_name_txt.setText(String.valueOf(person_name.get(position)));
        holder.person_contact_txt.setText(String.valueOf(person_contact.get(position)));

        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(person_id.get(position)));
                intent.putExtra("name", String.valueOf(person_name.get(position)));
                intent.putExtra("contact", String.valueOf(person_contact.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return person_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView person_id_txt, person_name_txt, person_contact_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            person_id_txt = itemView.findViewById(R.id.person_id_txt);
            person_name_txt = itemView.findViewById(R.id.person_name_txt);
            person_contact_txt = itemView.findViewById(R.id.person_contact_txt);

            mainLayout = itemView.findViewById(R.id.mainLayout);

        }

    }

}
