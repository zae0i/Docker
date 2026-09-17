package likelion.BE.docker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import likelion.BE.docker.domain.Post;

import java.time.LocalDateTime;

@Schema(description = "게시물 응답")
public record PostResponse(

        @Schema(description = "게시물 ID", example = "1")
        Long id,

        @Schema(description = "제목", example = "스프링부트로 게시판 만들기")
        String title,

        @Schema(description = "내용", example = "Swagger와 JPA를 이용해 게시물 CRUD API를 구현해봅니다.")
        String content,

        @Schema(description = "작성자", example = "홍길동")
        String author,

        @Schema(description = "생성 일시", example = "2026-09-17T10:00:00")
        LocalDateTime createdAt,

        @Schema(description = "수정 일시", example = "2026-09-17T10:00:00")
        LocalDateTime updatedAt
) {
    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
