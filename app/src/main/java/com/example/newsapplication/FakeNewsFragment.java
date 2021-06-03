package com.example.newsapplication;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class FakeNewsFragment extends Fragment
{
    private static final String TAG = "FakeNewsFragment";
    private View fakeNewsView;

    private RecyclerViewAdapter RecyclerViewAdapter;
    private List<News> newsArrayList;
    private RecyclerView fakeNewsList;
    private RequestQueue requestQueue;


    public FakeNewsFragment() {
    }


    //real time database reference
    DatabaseReference reference;
    FirebaseDatabase rootNode;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fakeNewsView =  inflater.inflate(R.layout.fragment_fake_news, container, false);

        fakeNewsList = fakeNewsView.findViewById(R.id.fake_news_list);
        fakeNewsList.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        fakeNewsList.setLayoutManager(linearLayoutManager);

        newsArrayList = new ArrayList<>();
     //   requestQueue = Volley.newRequestQueue(getContext());

      //  URLChecking();

        loadNews();

        return fakeNewsView;
    }


    @Override
    public void onStart() {
       // loadNews();
        super.onStart();
    }

    @Override
    public void onResume() {
       // loadNews();
        super.onResume();
    }

    private void loadNews() {

        //init firebase
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference().child("News");
        newsArrayList.clear();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {




                    News newsModel=dataSnapshot.getValue(News.class);
                    newsArrayList.add(newsModel);
                   // newsArrayList.add(newsModel);
//                    if(newsModel.getNewsType().equals("fake")){
//                        newsArrayList.add(newsModel);
//
//                    }




                }

                RecyclerViewAdapter = new RecyclerViewAdapter(getContext(), newsArrayList);
                fakeNewsList.setAdapter(RecyclerViewAdapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {


                Log.e(TAG,"Error :"+error.getMessage());
            }
        });

    }



}
