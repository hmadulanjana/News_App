package com.example.newsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder>
{
    private Context mContext;
    private List<News> mNewsArrayList;

    public RecyclerViewAdapter(Context context, List<News> newsArrayList)
    {
        mContext = context;
        mNewsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_layout, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position)
    {
         News currentNews = mNewsArrayList.get(position);
                holder.headline.setText(currentNews.headline+"");
                holder.date.setText(currentNews.date+"");
                holder.description.setText(currentNews.description+"");
//        String fragment = currentNews.getTime();
//        if(fragment.equals("verifiedNews"))
//        {
//            String newsType = currentNews.getNewsType();
//            if(newsType.equals("verified"))
//            {
//                String headline = currentNews.getHeadline();
//                String date = currentNews.getDate();
//                String description = currentNews.getDescription();
//
//                holder.headline.setText(headline);
//                holder.date.setText(date);
//                holder.description.setText(description);
//            }
//            else
//            {
//                holder.itemView.setVisibility(View.GONE);
//                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
//            }
//        }
//
//        if(fragment.equals("fakeNews"))
//        {
//            String newsType = currentNews.getNewsType();
//            if(newsType.equals("fake"))
//            {
//                String headline = currentNews.getHeadline();
//                String date = currentNews.getDate();
//                String description = currentNews.getDescription();
//
//                holder.headline.setText(headline);
//                holder.date.setText(date);
//                holder.description.setText(description);
//            }
//            else
//            {
//                holder.itemView.setVisibility(View.GONE);
//                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
//            }
//        }
    }

    @Override
    public int getItemCount()
    {
        return mNewsArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder
    {
        public TextView headline, date, description;

        public NewsViewHolder(@NonNull View itemView)
        {
            super(itemView);

            headline = itemView.findViewById(R.id.news_layout_headline);
            date = itemView.findViewById(R.id.news_layout_date);
            description = itemView.findViewById(R.id.news_layout_description);
        }
    }
}
