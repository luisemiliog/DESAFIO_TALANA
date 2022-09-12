package com.example.desafiotalana.CORE.ADAPTER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiotalana.IO.RESPONSES.FeedResponse;
import com.example.desafiotalana.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class FeedAdapter  extends RecyclerView.Adapter<FeedAdapter.Vista>{
    Context context;
    ArrayList items;

    public FeedAdapter(Context context, ArrayList items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Vista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_card,parent,false);
        Vista holder = new Vista(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Vista holder, int position) {
        FeedResponse response = (FeedResponse) items.get(position);
        holder.id.setText(response.getId().toString());
        holder.contenido.setText(response.getTitle());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Vista extends RecyclerView.ViewHolder{
        public TextView id,contenido;
        public Vista(View itemView){
            super(itemView);
            id= itemView.findViewById(R.id.id_card);
            contenido= itemView.findViewById(R.id.contenido_card);
        }
    }
}
