package br.com.kauamendes.springgraphql.service;

import br.com.kauamendes.springgraphql.data.Post;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PostService {

    Map<String, Post> posts = new HashMap<>();

    public Post createPost(String content) {
        var newPost = new Post(UUID.randomUUID().toString(), content);
        posts.put(newPost.id(), newPost);
        return newPost;
    }

    public Post postById(String id) {
        return posts.get(id);
    }
}
