package com.project.olympos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVothersAdapter extends RecyclerView.Adapter<RVothersAdapter.ViewHolder> {
    private ArrayList<Being> characters;
    private Context context;
    private OthersFragment fragment;
    ArrayList<String> aviliable = new ArrayList<>();

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
        String name = characters.get(position).getName();
        holder.imageView.setImageDrawable(characters.get(position).getImage());
        holder.textView.setText(name);

        //OPEN NOTE RELATED ARTICLE
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aviliable.contains(name))
                    fragment.openArticle(name);
                else
                    Toast.makeText(context, "Este personaje aún no está disponible", Toast.LENGTH_SHORT).show();
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
