package com.example.newsapplication;

public class News
{
    public String date;
    public String description;
    public String headline;
    public String newsType;
    public String time;




    public News()
    {

    }

    public News(String date, String description, String headline, String newsType, String time) {
        this.date = date;
        this.description = description;
        this.headline = headline;
        this.newsType = newsType;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
