package campus.membercampusstudy.controller;

import campus.membercampusstudy.entity.SimpleText;
import campus.membercampusstudy.mapper.SimpleTextMapper;
import campus.membercampusstudy.repository.SimpleTextRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * JPA와 MyBatis를 모두 사용하여 SimpleText 엔티티의 CRUD 작업을 처리하는 컨트롤러입니다.
 *
 * @author Gemini
 * @since 2025-08-05
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "SimpleText API", description = "JPA와 MyBatis를 사용한 텍스트 데이터 관리")
public class SimpleTextController {

    private final SimpleTextRepository simpleTextRepository; // JPA
    private final SimpleTextMapper simpleTextMapper;       // MyBatis

    // =================================================================
    // == JPA Endpoints (/api/jpa/texts)
    // =================================================================

    @Operation(summary = "[JPA] 모든 텍스트 조회", description = "JPA를 사용하여 모든 텍스트를 조회합니다.")
    @GetMapping("/api/jpa/texts")
    public ResponseEntity<List<SimpleText>> getAllTextsByJpa() {
        List<SimpleText> texts = simpleTextRepository.findAll();
        return ResponseEntity.ok(texts);
    }

    @Operation(summary = "[JPA] ID로 텍스트 조회", description = "JPA를 사용하여 ID로 특정 텍스트를 조회합니다.")
    @GetMapping("/api/jpa/texts/{id}")
    public ResponseEntity<SimpleText> getTextByIdByJpa(@PathVariable Long id) {
        return simpleTextRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "[JPA] 텍스트 생성", description = "JPA를 사용하여 새로운 텍스트를 생성합니다.")
    @PostMapping("/api/jpa/texts")
    public ResponseEntity<SimpleText> createTextByJpa(@RequestBody SimpleText simpleText) {
        SimpleText savedText = simpleTextRepository.save(simpleText);
        return ResponseEntity.ok(savedText);
    }

    @Operation(summary = "[JPA] 텍스트 수정", description = "JPA를 사용하여 기존 텍스트를 수정합니다.")
    @PutMapping("/api/jpa/texts/{id}")
    public ResponseEntity<SimpleText> updateTextByJpa(@PathVariable Long id, @RequestBody SimpleText simpleText) {
        if (!simpleTextRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        simpleText.setId(id);
        SimpleText updatedText = simpleTextRepository.save(simpleText);
        return ResponseEntity.ok(updatedText);
    }

    @Operation(summary = "[JPA] 텍스트 삭제", description = "JPA를 사용하여 ID로 텍스트를 삭제합니다.")
    @DeleteMapping("/api/jpa/texts/{id}")
    public ResponseEntity<Void> deleteTextByJpa(@PathVariable Long id) {
        if (!simpleTextRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        simpleTextRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // =================================================================
    // == MyBatis Endpoints (/api/mybatis/texts)
    // =================================================================

    @Operation(summary = "[MyBatis] 모든 텍스트 조회", description = "MyBatis를 사용하여 모든 텍스트를 조회합니다.")
    @GetMapping("/api/mybatis/texts")
    public ResponseEntity<List<SimpleText>> getAllTextsByMyBatis() {
        List<SimpleText> texts = simpleTextMapper.findAll();
        return ResponseEntity.ok(texts);
    }

    @Operation(summary = "[MyBatis] ID로 텍스트 조회", description = "MyBatis를 사용하여 ID로 특정 텍스트를 조회합니다.")
    @GetMapping("/api/mybatis/texts/{id}")
    public ResponseEntity<SimpleText> getTextByIdByMyBatis(@PathVariable Long id) {
        SimpleText text = simpleTextMapper.findById(id);
        return text != null ? ResponseEntity.ok(text) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "[MyBatis] 텍스트 생성", description = "MyBatis를 사용하여 새로운 텍스트를 생성합니다.")
    @PostMapping("/api/mybatis/texts")
    public ResponseEntity<SimpleText> createTextByMyBatis(@RequestBody SimpleText simpleText) {
        simpleTextMapper.insert(simpleText);
        return ResponseEntity.ok(simpleText); // MyBatis insert는 id를 객체에 다시 채워줌
    }

    @Operation(summary = "[MyBatis] 텍스트 수정", description = "MyBatis를 사용하여 기존 텍스트를 수정합니다.")
    @PutMapping("/api/mybatis/texts/{id}")
    public ResponseEntity<SimpleText> updateTextByMyBatis(@PathVariable Long id, @RequestBody SimpleText simpleText) {
        if (simpleTextMapper.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        simpleText.setId(id);
        simpleTextMapper.update(simpleText);
        return ResponseEntity.ok(simpleText);
    }

    @Operation(summary = "[MyBatis] 텍스트 삭제", description = "MyBatis를 사용하여 ID로 텍스트를 삭제합니다.")
    @DeleteMapping("/api/mybatis/texts/{id}")
    public ResponseEntity<Void> deleteTextByMyBatis(@PathVariable Long id) {
        if (simpleTextMapper.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        simpleTextMapper.delete(id);
        return ResponseEntity.noContent().build();
    }
}
