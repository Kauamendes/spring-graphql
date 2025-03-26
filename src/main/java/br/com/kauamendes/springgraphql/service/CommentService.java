package br.com.kauamendes.springgraphql.service;

import br.com.kauamendes.springgraphql.data.Comment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentService {

    Map<String, Comment> comments = new HashMap<>();

    public Comment createComment(String content, String postId) {
        var newComment = new Comment(UUID.randomUUID().toString(), content, postId);
        comments.put(newComment.id(), newComment);
        return newComment;
    }

    public Comment commentById(String id) {
        return comments.get(id);
    }
}
