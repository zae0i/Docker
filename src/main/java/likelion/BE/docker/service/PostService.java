package likelion.BE.docker.service;

import likelion.BE.docker.domain.Post;
import likelion.BE.docker.dto.PostRequest;
import likelion.BE.docker.dto.PostResponse;
import likelion.BE.docker.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostResponse createPost(PostRequest request) {
        Post post = new Post(request.title(), request.content(), request.author());
        Post saved = postRepository.save(post);
        log.info("[게시물 등록] id={}, title={}, author={}", saved.getId(), saved.getTitle(), saved.getAuthor());
        return PostResponse.from(saved);
    }

    public List<PostResponse> getPosts() {
        return postRepository.findAll().stream()
                .map(PostResponse::from)
                .toList();
    }

    public PostResponse getPost(Long id) {
        return PostResponse.from(findPostOrThrow(id));
    }

    @Transactional
    public PostResponse updatePost(Long id, PostRequest request) {
        Post post = findPostOrThrow(id);
        post.update(request.title(), request.content(), request.author());
        return PostResponse.from(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = findPostOrThrow(id);
        postRepository.delete(post);
    }

    private Post findPostOrThrow(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "게시물을 찾을 수 없습니다. id=" + id));
    }
}
