-- 기존 데이터 삭제 (필요 시)
-- DELETE FROM POSTS;

-- 1. 환영 메시지
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('바이브코딩에 오신 것을 환영합니다!', '이곳은 생각을 나누고 영감을 더하는 공간입니다. 멋진 게시글을 작성해 보세요!', CURRENT_TIMESTAMP, 0);

-- 2. 기술 팁 게시글
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('Spring Boot 4.x와 Java 25 시작하기', '최신 환경에서 웹 애플리케이션을 구축하는 방법은 매우 흥미롭습니다. record와 새로운 문법들을 적극 활용해 보세요.', CURRENT_TIMESTAMP, 15);

-- 3. MyBatis & H2 연동 가이드
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('MyBatis와 H2 Database 연동 팁', '설정 파일에서 jdbc:h2:file:./data/testdb와 같이 파일 모드를 사용하면 데이터를 안전하게 보관할 수 있습니다. MyBatis의 CamelCase 자동 변환 옵션도 잊지 마세요.', CURRENT_TIMESTAMP, 42);

-- 4. 업데이트 예시 데이터
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, UPDATED_AT, VIEWS) 
VALUES ('게시판 리팩토링 완료 소식', 'DTO 클래스들을 Java record로 성공적으로 변환했습니다. 코드가 훨씬 간결해졌네요!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 8);
