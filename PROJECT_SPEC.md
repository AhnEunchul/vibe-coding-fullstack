# PROJECT_SPEC.md

본 문서는 스프링부트 4.0.1 기반의 최소 기능 웹 애플리케이션인 `vibeapp` 프로젝트에 대한 상세 명세서입니다.

## 1. 프로젝트 개요
- **프로젝트 명**: vibeapp
- **설명**: 최소 기능 스프링부트 애플리케이션을 생성하는 프로젝트입니다.
- **개발 언어**: Java
- **구성 방식**: YAML 기반 설정

## 2. 개발 환경 및 기술 스택
- **JDK**: JDK 25 이상
- **프레임워크**: Spring Boot 4.0.1 이상
- **빌드 도구**: Gradle 9.3.0 이상 (Groovy DSL 사용)
- **뷰 템플릿**: Thymeleaf


## 3. 프로젝트 메타데이터
- **Group**: `com.example`
- **Artifact**: `vibeapp`
- **Main Class Name**: `com.example.vibeapp.VibeApp`
- **Description**: 최소 기능 스프링부트 애플리케이션을 생성하는 프로젝트다.

## 4. 빌드 구성 (build.gradle)
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

## 5. 애플리케이션 설정 (src/main/resources/application.yml)
```yaml
spring:
  application:
    name: vibeapp
  profiles:
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
*작성일: 2026년 2월 23일*
