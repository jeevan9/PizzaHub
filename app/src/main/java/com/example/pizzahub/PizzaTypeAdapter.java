package com.example.pizzahub;

/**
 * Created by jeevansai on 18/10/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;


import java.util.ArrayList;
import java.util.List;

public class PizzaTypeAdapter extends RecyclerView.Adapter<PizzaTypeAdapter.PersonViewHolder> {

    Context ctx;
    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        List<Pizza> pizzass=new ArrayList<Pizza>();
        CardView cv;
        Context ctx;
        TextView pizzaType;
        ImageView pizzaPhoto;

        PersonViewHolder(View itemView,Context ctx,List<Pizza> pizzass) {
            super(itemView);
            this.ctx=ctx;
            this.pizzass=pizzass;
            itemView.setOnClickListener(this);
            cv = (CardView)itemView.findViewById(R.id.card1);
            pizzaType = (TextView)itemView.findViewById(R.id.textView1);
            pizzaPhoto = (ImageView)itemView.findViewById(R.id.imageView1);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            Pizza pers=this.pizzass.get(position);
            Intent i=new Intent(this.ctx,VegPizza.class);
            i.putExtra("image_url",pers.imageurl);
            i.putExtra("name",pers.name);
            this.ctx.startActivity(i);
        }
    }

    List<Pizza> pizzas;

    PizzaTypeAdapter(List<Pizza> pizzas, Context ctx){
        this.pizzas = pizzas;
        this.ctx=ctx;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_pizza_type, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v,ctx,pizzas);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.pizzaType.setText(pizzas.get(i).name);
        personViewHolder.pizzaPhoto.setImageResource(pizzas.get(i).imageurl);
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }
}