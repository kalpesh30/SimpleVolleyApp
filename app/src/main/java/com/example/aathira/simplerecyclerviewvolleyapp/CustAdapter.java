package com.example.aathira.simplerecyclerviewvolleyapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustAdapter extends RecyclerView.Adapter<CustAdapter.CustViewHolder> {

    private Users user[] ;
    private static Context context;
    CustAdapter(Context context, Users user[]){
        this.context = context ;
        this.user = user ;
    }

    @NonNull
    @Override
    public CustViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext()) ;
        View view = inflater.inflate(R.layout.list_item_view,viewGroup,false) ;
        return new CustViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustViewHolder custViewHolder, int i) {
        Users U = user[i] ;
        custViewHolder.tv1.setText(U.getLogin());

    }

    @Override
    public int getItemCount() {
        return user.length;
    }

    public class CustViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        ImageView img1;

        public CustViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv_tv1) ;
            img1 = itemView.findViewById(R.id.iv_img1) ;
        }
    }
}
