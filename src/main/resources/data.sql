-- 1. 환영 메시지
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('바이브코딩에 오신 것을 환영합니다!', '이곳은 생각을 나누고 영감을 더하는 공간입니다. 멋진 게시글을 작성해 보세요!', CURRENT_TIMESTAMP, 10);

-- 2. 기술 팁 게시글
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('Spring Boot 4.x와 Java 25 시작하기', '최신 환경에서 웹 애플리케이션을 구축하는 방법은 매우 흥미롭습니다. record와 새로운 문법들을 적극 활용해 보세요.', CURRENT_TIMESTAMP, 25);

-- 3. MyBatis & H2 연동 가이드
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('MyBatis와 H2 Database 연동 팁', '설정 파일에서 jdbc:h2:file:./data/testdb와 같이 파일 모드를 사용하면 데이터를 안전하게 보관할 수 있습니다.', CURRENT_TIMESTAMP, 42);

-- 4. 업데이트 예시 데이터
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, UPDATED_AT, VIEWS) 
VALUES ('게시판 리팩토링 완료 소식', 'DTO 클래스들을 Java record로 성공적으로 변환했습니다. 코드가 훨씬 간결해졌네요!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18);

-- 5. 새로운 테크 트렌드
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('2026년 웹 개발 트렌드 전망', 'AI 기반 코딩 도구의 발전과 새로운 런타임 경쟁이 웹 생태계를 어떻게 변화시킬지 기대됩니다.', CURRENT_TIMESTAMP, 5);

-- 6. 개발자 라이프
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('개발자의 번아웃 탈출기', '지속 가능한 개발을 위해서는 적절한 휴식과 취미 생활이 필수적입니다. 여러분만의 휴식 방법은 무엇인가요?', CURRENT_TIMESTAMP, 12);

-- 7. 알고리즘 공부
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('효율적인 알고리즘 학습법', '단순히 문제를 많이 풀기보다 하나의 문제를 다양한 방식으로 최적화해보는 연습이 성장에 더 큰 도움이 됩니다.', CURRENT_TIMESTAMP, 30);

-- 8. 프로젝트 관리
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('성공적인 협업을 위한 커밋 메시지 규칙', 'Conventional Commits 규칙을 따르면 프로젝트 히스토리를 훨씬 체계적으로 관리할 수 있습니다.', CURRENT_TIMESTAMP, 22);

-- 9. 보안 상식
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('웹 취약점 방어의 기본: SQL Injection', 'PreparedStatement나 MyBatis의 #{} 문법을 사용하면 SQL 인젝션 공격을 효과적으로 방어할 수 있습니다.', CURRENT_TIMESTAMP, 50);

-- 10. 마무리 인사
INSERT INTO POSTS (TITLE, CONTENT, CREATED_AT, VIEWS) 
VALUES ('첫 번째 마일스톤 완료!', '우리 프로젝트의 기초 인프라 구축이 거의 마무리되었습니다. 다음 단계인 도메인 로직 구현으로 넘어가볼까요?', CURRENT_TIMESTAMP, 100);
