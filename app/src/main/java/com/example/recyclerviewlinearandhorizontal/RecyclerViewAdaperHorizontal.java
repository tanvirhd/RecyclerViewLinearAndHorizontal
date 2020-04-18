package com.example.recyclerviewlinearandhorizontal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdaperHorizontal extends  RecyclerView.Adapter<RecyclerViewAdaperHorizontal.VH>{

    private  List<MovieClass> list=new ArrayList<>();
    Context context;

    public RecyclerViewAdaperHorizontal(List<MovieClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movieclass_horizontal_layout,parent,false);
        VH vh=new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.movie_image.setImageResource(list.get(position).getMovieImage());
        holder.movie_title.setText(list.get(position).getMovieTitle());
        holder.movie_rating.setText(list.get(position).getMovieRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class VH extends RecyclerView.ViewHolder{

        //LinearLayout linearLayout;
        CircleImageView movie_image;
        TextView movie_title, movie_rating;

        public VH(@NonNull View itemView) {
            super(itemView);

            //linearLayout=itemView.findViewById(R.id.linearItem_layout_xml);
            movie_image =itemView.findViewById(R.id.iv_movie_image_xml);
            movie_title =itemView.findViewById(R.id.tv_movie_title);
            movie_rating =itemView.findViewById(R.id.tv_movie_rating);
        }
    }
}
