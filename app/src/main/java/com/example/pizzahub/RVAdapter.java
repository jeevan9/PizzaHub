package com.example.pizzahub;

/**
 * Created by jeevansai on 01/11/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    Context ctx;
    public static class PersonViewHolder extends RecyclerView.ViewHolder{
        List<Pizza_Order> personss=new ArrayList<Pizza_Order>();
        CardView cv;
        Context ctx;
        TextView order;
        Button accept;
        Button reject;

        PersonViewHolder(View itemView,Context ctx,List<Pizza_Order> personss) {
            super(itemView);
            this.ctx=ctx;
            this.personss=personss;
         //   itemView.setOnClickListener(this);
            cv = (CardView)itemView.findViewById(R.id.cv);
            order = (TextView)itemView.findViewById(R.id.orders);
            accept = (Button) itemView.findViewById(R.id.accept);
            reject = (Button) itemView.findViewById(R.id.reject);
        }
/*
        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            String pers=this.personss.get(position);
            Intent i=new Intent(this.ctx,PersonDetails.class);
            i.putExtra("order_num",pers.photoId);
            i.putExtra("name",pers.name);
            i.putExtra("age",pers.age);
            this.ctx.startActivity(i);
        }
  */  }

    List<Pizza_Order> persons;

    RVAdapter(List<Pizza_Order> persons, Context ctx){
        this.persons = persons;
        this.ctx=ctx;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void delete_accept(int position)
    {
        persons.remove(position);

        notifyItemRemoved(position);
        notifyItemRangeChanged(position,getItemCount());

    }
    public void delete_reject(int position)
    {
        persons.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,getItemCount());

    }
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v,ctx,persons);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, final int i) {
        personViewHolder.order.setText(persons.get(i).orderss);
        personViewHolder.accept.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                String result=AdminLogin.uo.get(i);
                String res[]=result.split(" ");
                AdminAccept aa=new AdminAccept(ctx);
                aa.execute(res[0],res[1]);
                delete_accept(i);
                //Toast.makeText(ctx,"Accept Clicked at pos : "+i,Toast.LENGTH_SHORT).show();
            }
        });
        personViewHolder.reject.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String result=AdminLogin.uo.get(i);
                String res[]=result.split(" ");
                AdminReject aa=new AdminReject(ctx);
                aa.execute(res[0],res[1]);
                delete_reject(i);
                // Toast.makeText(ctx,"Reject Clicked at pos "+i,Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}