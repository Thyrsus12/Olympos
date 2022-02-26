package com.project.olympos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVgodsAdapter extends RecyclerView.Adapter<RVgodsAdapter.ViewHolder> {
    private ArrayList<Being> characters;
    private Context context;
    private GodsFragment fragment;

    public RVgodsAdapter(ArrayList<Being> characters, Context context, GodsFragment fragment) {
        this.characters = characters;
        this.context = context;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public RVgodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVgodsAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageDrawable(characters.get(position).getImage());
        holder.textView.setText(characters.get(position).getName());

        //OPEN NOTE RELATED ARTICLE
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.openArticle(position);
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
