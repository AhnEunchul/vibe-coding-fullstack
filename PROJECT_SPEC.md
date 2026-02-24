# PROJECT_SPEC.md

본 문서는 스프링부트 4.0.1 기반의 최소 기능 웹 애플리케이션인 `vibeapp` 프로젝트에 대한 상세 명세서입니다.

## 1. 프로젝트 개요
- **프로젝트 명**: vibeapp
- **설명**: 최소 기능 스프링부트 애플리케이션을 기반으로 한 도메인 중심의 게시판 서비스입니다.
- **개발 언어**: Java
- **구성 방식**: YAML 기반 설정

## 2. 개발 환경 및 기술 스택
- **JDK**: JDK 25 이상
- **프레임워크**: Spring Boot 4.0.1 이상
- **빌드 도구**: Gradle 9.3.0 이상 (Groovy DSL 사용)
- **뷰 템플릿 Engine**: Thymeleaf
- **프론트엔드 프레임워크**:
    - **Bootstrap 5.3.3** (CDN 방식)
    - **Tailwind CSS** (CDN 방식)
    - **Material Symbols** (구글 폰트 아이콘)

## 3. 프로젝트 아키텍처 (기능형 구조)
도메인(기능)별로 패키지를 분리하여 관리가 용이하게 구성되었습니다.

### 3.1. 자바 패키지 구조 (`src/main/java/com/example/vibeapp`)
- `home/`: 홈페이지 관련 컨트롤러 (`HomeController.java`)
- `post/`: 게시판 관련 전체 레이어
    - `Post.java`: 게시글 도메인 모델
    - `PostController.java`: 게시판 HTTP 요청 처리
    - `PostService.java`: 비즈니스 로직 처리
    - `PostRepository.java`: 인메모리 게시글 데이터 저장소

### 3.2. 뷰 템플릿 구조 (`src/main/resources/templates`)
- `home/`: 홈 화면 템플릿 (`home.html`)
- `post/`: 게시판 관련 템플릿
    - `posts.html`: 게시글 목록 (페이징 포함)
    - `post_detail.html`: 게시글 상세 보기
    - `post_new_form.html`: 게시글 작성 폼
    - `post_edit_form.html`: 게시글 수정 폼

## 4. 주요 기능
- **게시글 관리 (CRUD)**: 게시글 등록, 상세 조회, 수정, 삭제 기능 제공.
- **페이징 처리**: 목록 페이지에서 페이지당 5개의 게시글을 노출하며, 하단 페이지네이션 바를 통해 페이지 이동 가능.
- **인메모리 저장소**: 초기 로딩 시 10개의 더미 데이터를 생성하여 테스트 가능.

## 5. 코드 스타일 및 관례
- **명명 규칙**: 실무 관례(Standard Naming)를 따름.
    - 데이터 조회: `findById`, `findAll`
    - 데이터 생성/수정: `createPost`, `updatePost`
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

server:
  port: 8080
```

---
*최종 업데이트: 2026년 2월 24일*
