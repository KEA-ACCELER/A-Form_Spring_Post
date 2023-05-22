package com.aform.post.web.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aform.post.domain.post.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class PostDto {
    @Getter
    @RequiredArgsConstructor
    public static class PostCreateRequestDto{
        String postTitle;
        String postDesc;
        String postSurvey;
        Long author;
        LocalDateTime postStartDate;
        LocalDateTime postDueDate;
    
        public Post toEntity(){
            return Post.builder()
                .postTitle(postTitle)
                .postDesc(postDesc)
                .postSurvey(postSurvey)
                .postAuthor(author)
                .postViews(0) // initial value
                .postStartDate(postStartDate)
                .postDueDate(postDueDate)
                .build();
        }
    }  
    
    @Getter
    @RequiredArgsConstructor
    public static class PostResponseDto{
        Long postAuthor;
        Long postPk;
        String postTitle;
        String postDesc;
        String postSurvey;
        int postViews;
        LocalDateTime postStartDate;
        LocalDateTime postDueDate;
    
        @Builder
        public PostResponseDto(Post post){
            this.postAuthor = post.getPostAuthor();
            this.postPk = post.getPostPk();
            this.postTitle = post.getPostTitle();
            this.postDesc = post.getPostDesc();
            this.postSurvey = post.getPostSurvey();
            this.postViews = post.getPostViews();
            this.postStartDate = post.getPostStartDate();
            this.postDueDate = post.getPostDueDate();
        }

    }

    @Getter
    @RequiredArgsConstructor
    public static class PostListResponseDto{
        Long postAuthor;
        Long postPk;
        String postTitle;
        int postViews;
        LocalDateTime postStartDate;
        LocalDateTime postDueDate;  

        @Builder
        public PostListResponseDto(Post post){
            this.postAuthor = post.getPostAuthor();
            this.postPk = post.getPostPk();
            this.postTitle = post.getPostTitle();
            this.postViews = post.getPostViews();
            this.postStartDate = post.getPostStartDate();
            this.postDueDate = post.getPostDueDate();
        }
    }
}
