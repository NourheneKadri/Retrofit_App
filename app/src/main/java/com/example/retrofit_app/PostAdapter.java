package com.example.retrofit_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<RequestPost> postList;
    Context context;

    public PostAdapter(Context context , List<RequestPost> posts){
        this.context= context;
            postList = posts;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
       return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        RequestPost post = postList.get(position);
        holder.userId.setText("UserId : " +  post.getUserId());
        holder.id.setText("Id : " + post.getId());

        holder.title.setText("Title : " + post.getTitle());
        holder.body.setText("Body : " + post.getBody());
        //vous récupérez l'objet RequestPost correspondant à la position donnée à partir
        // de la liste postList, puis vous mettez à jour les vues du titulaire
        // (PostViewHolder) avec les données de cet objet.



    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
    // Cette classe est responsable de la gestion des vues des éléments individuels de la liste dans le RecyclerView.
    public static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView title , id , userId , body;
        public PostViewHolder(@NonNull View itemView) {
            // Définit le constructeur de la classe PostViewHolder, qui prend une vue (itemView) en argument
            super(itemView);
            userId = itemView.findViewById(R.id.user_id_tv);
            // Initialise la variable userId en recherchant la vue avec l'identifiant user_id_tv dans la vue itemView
            id = itemView.findViewById(R.id.id_tv);
            title = itemView.findViewById(R.id.title_tv);
           body = itemView.findViewById(R.id.body_tv);
           //la gestion et de l'affichage des vues des éléments individuels de la liste dans un RecyclerView.
            // est responsable de la gestion des vues des éléments individuels de la liste dans un RecyclerView

        }
    }
}
