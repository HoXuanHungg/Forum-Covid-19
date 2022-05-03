package com.dg3.forum.forum.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Like_Comment_Posts {
    private int numberLike;
    private int numberComment;
    private List<String> listNameLike;

    public Like_Comment_Posts(){ }

    public Like_Comment_Posts(int numberLike, int numberComment, List<String> listNameLike){
        this.numberLike = numberLike;
        this.numberComment = numberComment;
        this.listNameLike = listNameLike;
    }
}
