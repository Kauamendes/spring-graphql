package br.com.kauamendes.springgraphql.controller;

import br.com.kauamendes.springgraphql.data.Post;
import br.com.kauamendes.springgraphql.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public Post postById(@Argument String id) {
        return postService.postById(id);
    }

    @MutationMapping
    public Post createPost(@Argument String content) {
        return postService.createPost(content);
    }
}
