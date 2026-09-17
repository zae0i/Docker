package likelion.BE.docker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "게시물 등록/수정 요청")
public record PostRequest(

        @Schema(description = "제목", example = "스프링부트로 게시판 만들기")
        @NotBlank(message = "제목은 필수입니다.")
        String title,

        @Schema(description = "내용", example = "Swagger와 JPA를 이용해 게시물 CRUD API를 구현해봅니다.")
        @NotBlank(message = "내용은 필수입니다.")
        String content,

        @Schema(description = "작성자", example = "홍길동")
        @NotBlank(message = "작성자는 필수입니다.")
        String author
) {
}
