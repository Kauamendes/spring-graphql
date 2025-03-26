package br.com.kauamendes.springgraphql.controller;

import br.com.kauamendes.springgraphql.data.Comment;
import br.com.kauamendes.springgraphql.service.CommentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @QueryMapping
    public Comment commentById(@Argument String id) {
        return commentService.commentById(id);
    }

    @MutationMapping
    public Comment createComment(@Argument String content, @Argument String postId) {
        return commentService.createComment(content, postId);
    }
}
