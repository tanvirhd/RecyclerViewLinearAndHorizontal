package com.example.recyclerviewlinearandhorizontal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViweAdapterVertical extends RecyclerView.Adapter<RecyclerViweAdapterVertical.ViewHolder> {

    private static final String TAG = "RV_AdapterVertical";
    private List<MovieClass> movieList =new ArrayList<MovieClass>();
    private Context context;
    private AdapterCallback adapterCallback;

    public RecyclerViweAdapterVertical(List<MovieClass> modelList, Context context,AdapterCallback callback) {
        this.movieList = modelList;
        this.context = context;
        this.adapterCallback=callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movieclass_vertical_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder:called");
        final int pos=position;
        holder.movie_image.setImageResource(movieList.get(position).getMovieImage());
        holder.movie_title.setText(movieList.get(position).getMovieTitle());
        holder.movie_rating.setText(movieList.get(position).getMovieRating());
/*        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, holder.movie_title.getText(), Toast.LENGTH_SHORT).show();
            }
        });*/

        final MovieClass movieModelClass=movieList.get(position);

        holder.btn_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterCallback.onClickCallback(movieModelClass,pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void updateList(List<MovieClass> movieList){
        this.movieList=movieList;
        notifyDataSetChanged();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        ImageView movie_image;
        TextView movie_title, movie_rating;
        Button btn_rate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btn_rate=itemView.findViewById(R.id.btn_rate);
            linearLayout=itemView.findViewById(R.id.linearItem_layout_xml);
            movie_image =itemView.findViewById(R.id.movie_image_xml);
            movie_title =itemView.findViewById(R.id.movie_title_xml);
            movie_rating =itemView.findViewById(R.id.movie_rating_xml);
        }
    }
}
