package com.aidooit.aidooit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>{


    private Context Ctx;
    private List<People> peopleList;
    public View view;

    public PeopleAdapter(Context ctx, List<People> peopleList) {
        Ctx = ctx;
        this.peopleList = peopleList;
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        this.view = inflater.inflate(R.layout.people_list_layout, null);
        PeopleViewHolder holder = new PeopleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        final People people = peopleList.get(position);

        holder.nameTextView.setText(people.getName());
        holder.mobileTextView.setText(people.getMobile());
        holder.phoneTextView.setText(people.getPhone());
        holder.emailTextView.setText(people.getEmail());
        holder.imageView.setImageDrawable(Ctx.getResources().getDrawable(people.getPhoto()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = people.getName();
                Toast toast = Toast.makeText(view.getContext(), msg , Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        if (people.getMobile().isEmpty())
        {
            holder.mobileLayout.setVisibility(View.GONE);
        }

        if (people.getPhone().isEmpty())
        {
            holder.phoneLayout.setVisibility(View.GONE);
        }

        if (people.getEmail().isEmpty())
        {
            holder.emailLayout.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView nameTextView;
        TextView mobileTextView;
        TextView phoneTextView;
        TextView emailTextView;

        LinearLayout mobileLayout;
        LinearLayout phoneLayout;
        LinearLayout emailLayout;




        public PeopleViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            mobileTextView = itemView.findViewById(R.id.mobileTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);

            mobileLayout = itemView.findViewById(R.id.mobileLayout);
            phoneLayout = itemView.findViewById(R.id.phoneLayout);
            emailLayout = itemView.findViewById(R.id.emailLayout);


        }
    }
}
