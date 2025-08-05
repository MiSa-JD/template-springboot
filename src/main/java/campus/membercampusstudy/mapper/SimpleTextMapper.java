package campus.membercampusstudy.mapper;

import campus.membercampusstudy.entity.SimpleText;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * SimpleText 엔티티를 위한 MyBatis 매퍼 인터페이스입니다.
 * <p>
 * 이 인터페이스의 메소드들은 XML 파일에 정의된 SQL 쿼리와 매핑됩니다.
 *
 * @author Gemini
 * @since 2025-08-05
 */
@Mapper
public interface SimpleTextMapper {

    /**
     * 모든 SimpleText 데이터를 조회합니다.
     *
     * @return SimpleText 목록
     */
    List<SimpleText> findAll();

    /**
     * ID로 특정 SimpleText 데이터를 조회합니다.
     *
     * @param id 조회할 ID
     * @return SimpleText 객체
     */
    SimpleText findById(Long id);

    /**
     * 새로운 SimpleText 데이터를 저장합니다.
     *
     * @param simpleText 저장할 데이터
     */
    void insert(SimpleText simpleText);

    /**
     * 기존 SimpleText 데이터를 수정합니다.
     *
     * @param simpleText 수정할 데이터
     */
    void update(SimpleText simpleText);

    /**
     * ID로 SimpleText 데이터를 삭제합니다.
     *
     * @param id 삭제할 ID
     */
    void delete(Long id);
}
