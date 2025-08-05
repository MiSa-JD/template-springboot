package campus.membercampusstudy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 초기 테스트 및 기본 구조 확인을 위한 간단한 엔티티입니다.
 * <p>
 * `id`와 `text` 두 개의 간단한 필드만 가집니다.
 *
 * @author Gemini
 * @since 2025-08-05
 */
@Entity
@Getter
@Setter
public class SimpleText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
}
