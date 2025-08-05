-- 기존 테이블이 있다면 삭제
DROP TABLE IF EXISTS simple_text;

-- 새로운 테이블 생성
CREATE TABLE simple_text (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255)
);
