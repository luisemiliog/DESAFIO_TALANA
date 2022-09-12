package com.example.desafiotalana.IO.RESPONSES;

import com.google.gson.annotations.SerializedName;

public class FeedResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("date")
    private String date;
    @SerializedName("description")
    private String description;
    @SerializedName("published")
    private String published;
    @SerializedName("author_id")
    private Integer author_id;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "FeedResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", published='" + published + '\'' +
                ", author_id=" + author_id +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getPublished() {
        return published;
    }

    public Integer getAuthor_id() {
        return author_id;
    }
}
