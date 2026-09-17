package likelion.BE.docker.repository;

import likelion.BE.docker.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
