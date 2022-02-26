package com.project.olympos;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVothersAdapter extends RecyclerView.Adapter<RVothersAdapter.ViewHolder> {
    private ArrayList<Being> characters;
    private Context context;
    private OthersFragment fragment;

    public RVothersAdapter (ArrayList<Being> characters, Context context, OthersFragment fragment) {
        this.characters = characters;
        this.context = context;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public RVothersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new RVothersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVothersAdapter.ViewHolder holder, int position) {
        Drawable image = characters.get(position).getImage();
        String name = characters.get(position).getName();
        holder.imageView.setImageDrawable(image);
        holder.textView.setText(name);

        //OPEN NOTE RELATED ARTICLE
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.openArticle(position, name, image);
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.openArticle(position, name, image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivCharacter);
            textView = itemView.findViewById(R.id.tvName);
        }
    }
}
