package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LoadWebtoonData {
    private String title;
    private List<String> authors;
    private String description;
    private String link;
    private String updatedDate;
    private String count;

    public LoadWebtoonData(){
        authors = new ArrayList<>();
    }

    public void addAuthor(String author){
        authors.add(author);
    }
}
