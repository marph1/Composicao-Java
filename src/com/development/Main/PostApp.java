package com.development.Main;

import com.development.Entities.Comment;
import com.development.Entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PostApp {
    public static void main(String... args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Comment c1 = new Comment("Travel to Island?? NICEEE");
        Comment c2 = new Comment("OMG!!");

        Post post = new Post();

        System.out.println("Date: ");
        Date date = sdf.parse(sc.nextLine());

        post.setMoment(date);
        post.setTitle("Incoming to Island");
        post.setContent("UHUUUU");
        post.setLikes(15);

        post.addComment(c1);
        post.addComment(c2);

        System.out.println(post);


    }
}
