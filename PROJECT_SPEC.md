# PROJECT_SPEC.md

본 문서는 스프링부트 4.0.1 기반의 도메인 중심 게시판 웹 애플리케이션인 `vibeapp` 프로젝트에 대한 상세 명세서입니다.

## 1. 프로젝트 개요
- **프로젝트 명**: vibeapp
- **설명**: 최소 기능 스프링부트 애플리케이션을 기반으로 한 도메인 중심의 게시판 서비스입니다.
- **개발 언어**: Java
- **구성 방식**: YAML 기반 설정

## 2. 개발 환경 및 기술 스택
- **JDK**: JDK 25 이상
- **프레임워크**: Spring Boot 4.0.1 이상
- **빌드 도구**: Gradle 9.3.0 이상 (Groovy DSL 사용)
- **데이터베이스**: H2 (파일 기반, `./data/testdb`)
- **ORM/매퍼**: MyBatis (XML 매퍼 방식)
- **트랜잭션**: Spring `DataSourceTransactionManager` + `@EnableTransactionManagement`
- **뷰 템플릿 Engine**: Thymeleaf
- **프론트엔드 프레임워크**:
    - **Bootstrap 5.3.3** (CDN 방식)
    - **Tailwind CSS** (CDN 방식)
    - **Material Symbols** (구글 폰트 아이콘)

## 3. 프로젝트 아키텍처 (기능형 구조)
도메인(기능)별로 패키지를 분리하여 관리가 용이하게 구성되었습니다.

### 3.1. 자바 패키지 구조 (`src/main/java/com/example/vibeapp`)

#### `home/`
- `HomeController.java`: 홈페이지 요청 처리

#### `post/` — 게시판 전체 레이어
| 파일 | 역할 |
|------|------|
| `Post.java` | 게시글 도메인 모델 |
| `PostTag.java` | 게시글 태그 도메인 모델 |
| `PostController.java` | 게시판 HTTP 요청 처리 |
| `PostService.java` | 비즈니스 로직 처리 (`@Transactional` 적용) |
| `PostRepository.java` | MyBatis 기반 게시글 데이터 접근 |
| `PostTagRepository.java` | MyBatis 기반 태그 데이터 접근 |
| `PostCreateDto.java` | 게시글 등록 요청 DTO (태그 포함) |
| `PostUpdateDto.java` | 게시글 수정 요청 DTO (태그 포함) |
| `PostResponseDto.java` | 게시글 상세 응답 DTO (태그 포함) |
| `PostListDto.java` | 게시글 목록 응답 DTO |
| `MyBatisConfig.java` | MyBatis 설정, 트랜잭션 매니저 빈 등록 |
| `H2ConsoleConfig.java` | H2 콘솔 접근 설정 |
| `DatabaseLogConfig.java` | 애플리케이션 기동 시 DB 접속 정보 로깅 |

### 3.2. 뷰 템플릿 구조 (`src/main/resources/templates`)
- `home/`: 홈 화면 템플릿 (`home.html`)
- `post/`: 게시판 관련 템플릿
    - `posts.html`: 게시글 목록 (페이징 포함)
    - `post_detail.html`: 게시글 상세 보기
    - `post_new_form.html`: 게시글 작성 폼 (태그 입력 포함)
    - `post_edit_form.html`: 게시글 수정 폼 (태그 입력 포함)

### 3.3. MyBatis 매퍼 구조 (`src/main/resources/mapper`)
- `post/PostMapper.xml`: 게시글 CRUD 및 페이징 쿼리
- `post/PostTagMapper.xml`: 태그 저장/조회/삭제 쿼리

## 4. 주요 기능
- **게시글 관리 (CRUD)**: 게시글 등록, 상세 조회, 수정, 삭제 기능 제공.
- **태그 관리**: 게시글 등록·수정 시 쉼표(,) 구분 태그 입력, 저장 및 조회.
- **페이징 처리**: 목록 페이지에서 페이지당 5개의 게시글을 노출하며, 하단 페이지네이션 바를 통해 페이지 이동 가능.
- **조회수 증가**: 게시글 상세 조회 시 조회수 자동 증가.
- **트랜잭션 관리**: 게시글 등록/수정과 태그 등록/수정을 단일 트랜잭션으로 처리하여 데이터 정합성 보장.
- **H2 콘솔**: `/h2-console` 경로에서 개발 중 DB 데이터 직접 확인 가능.

## 5. 코드 스타일 및 관례
- **명명 규칙**: 실무 관례(Standard Naming)를 따름.
    - 데이터 조회: `findById`, `findAll`, `findByPostNo`
    - 데이터 생성/수정: `createPost`, `updatePost`, `save`
    - 데이터 삭제: `deletePost`, `deleteByPostNo`
- **Git Commit Convention**: Conventional Commits 준수.

## 6. 빌드 구성 (build.gradle)
```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '4.0.1'
    id 'io.spring.dependency-management' version '1.1.4'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:4.0.0'
    implementation 'com.h2database:h2'
}
```

## 7. 애플리케이션 설정 (application.yml)
```yaml
spring:
  application:
    name: vibeapp
  profiles:
    active: dev
  thymeleaf:
    cache: false
    mode: HTML
    encoding: UTF-8
    prefix: classpath:/templates/
    suffix: .html
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:file:./data/testdb;NON_KEYWORDS=USER;AUTO_SERVER=TRUE
    username: sa
    password:
  sql:
    init:
      mode: always
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        web-allow-others: true

mybatis:
  mapper-locations: classpath:mapper/**/*.xml
  type-aliases-package: com.example.vibeapp.post
  configuration:
    map-underscore-to-camel-case: true

logging:
  level:
    org.springframework.boot.autoconfigure: DEBUG
  file:
    name: ./logs/app.log

debug: true

server:
  port: 8080
```

---
*최종 업데이트: 2026년 2월 24일*
