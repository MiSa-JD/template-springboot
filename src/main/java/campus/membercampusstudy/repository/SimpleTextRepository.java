package campus.membercampusstudy.repository;

import campus.membercampusstudy.entity.SimpleText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SimpleText 엔티티를 위한 JPA 리포지토리입니다.
 *
 * @author Gemini
 * @since 2025-08-05
 */
@Repository
public interface SimpleTextRepository extends JpaRepository<SimpleText, Long> {
}
