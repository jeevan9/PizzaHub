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
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class PizzaTypeAdapter extends RecyclerView.Adapter<PizzaTypeAdapter.PersonViewHolder> {

    Context ctx;
    public static int p2=0,q2=0,r2=0,cp2=0,cq2=0,cr2=0,cps2=0,cqs2=0,crs2=0,cpm2=0,cqm2=0,crm2=0,cpl2=0,cql2=0,crl2=0;
    public static  String s="";
    public static ArrayList<Integer> item_count1=new ArrayList<>();

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            List<Pizza> pizzass = new ArrayList<Pizza>();
        CardView cv;
        Context ctx;
        TextView pizzaType;
        ImageView pizzaPhoto;


        PersonViewHolder(View itemView, Context ctx, List<Pizza> pizzass) {
            super(itemView);
            this.ctx = ctx;
            this.pizzass = pizzass;
            itemView.setOnClickListener(this);
            cv = (CardView) itemView.findViewById(R.id.card1);
            pizzaType = (TextView) itemView.findViewById(R.id.textView1);
            pizzaPhoto = (ImageView) itemView.findViewById(R.id.imageView1);
            // pizzaPhoto.setOnClickListener(this);
            //pizzaType.setOnClickListener(this);
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
    PizzaTypeAdapter()
    {

    }

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
        item_count1.add(i,0);
      /*  final int po=i;
        personViewHolder.pizzaPhoto.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
               Toast.makeText(ctx,po+" th Photo clicked ",Toast.LENGTH_SHORT).show();
            }
        });
        personViewHolder.pizzaType.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                Intent i=new Intent(ctx,VegPizza.class);
                i.putExtra("image_url",pizzas.get(po).imageurl);
                i.putExtra("name",pizzas.get(po).name);
                ctx.startActivity(i);

                Toast.makeText(ctx,po+" th PizzaType clicked ",Toast.LENGTH_SHORT).show();
            }
        });*/
     }

    @Override
    public int getItemCount(){
        return pizzas.size();

    }
}