package com.example.recyclerviewlinearandhorizontal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterCallback{

    RecyclerView recyclerView1,recyclerView2;
    int preselectedItem=-1;
    List<MovieClass> mlist=new ArrayList<>();
    RecyclerViweAdapterVertical adapterVertical;
    RecyclerViewAdaperHorizontal adaperHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1=findViewById(R.id.recyclerview_vertical_xml);
        recyclerView2=findViewById(R.id.recyclerview_horizontal_xml);


        mlist.add(new MovieClass(R.drawable.blooddiamond,"Blood Diamond","8",false));
        mlist.add(new MovieClass(R.drawable.django,"Django Unchained","8.4",false));
        mlist.add(new MovieClass(R.drawable.endgame,"End Game","8.6",false));
        mlist.add(new MovieClass(R.drawable.godfather,"The Godfather","9.2",false));
        mlist.add(new MovieClass(R.drawable.gonegirl,"Gone Girl (2014)","8.1",false));
        mlist.add(new MovieClass(R.drawable.imitationgame,"The Imitation Game (2014)","8",false));
        mlist.add(new MovieClass(R.drawable.oneday,"One Day (2011)","7",false));
        mlist.add(new MovieClass(R.drawable.seven,"Seven","8.6",false));

        adapterVertical=new RecyclerViweAdapterVertical(mlist,getApplicationContext(),this);
        recyclerView1.setAdapter(adapterVertical);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        adaperHorizontal=new RecyclerViewAdaperHorizontal(mlist,getApplicationContext());
        recyclerView2.setAdapter(adaperHorizontal);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager);


    }

    @Override
    public void onClickCallback(MovieClass movieClass,int position) {
        MovieClass movie=mlist.get(position);
        movie.setSelected(true);
        mlist.set(position,movie);

        if(preselectedItem>-1){
            MovieClass preSelectedMovie=mlist.get(preselectedItem);
            movie.setSelected(false);
            mlist.set(preselectedItem,preSelectedMovie);
            Log.d("pre", "pre-selected Movie name:"+mlist.get(preselectedItem).getMovieTitle());
        }

        preselectedItem=position;
        adapterVertical.updateList(mlist);
        Log.d("pre", "Selected Movie name:"+mlist.get(position).getMovieTitle());
        Toast.makeText(this, "Thanks For Your Feedback & pre =position="+preselectedItem, Toast.LENGTH_SHORT).show();
    }
}
