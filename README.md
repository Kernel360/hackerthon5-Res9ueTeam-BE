# hackerthon5-Res9ueTeam-BE
커널360 5기 해커톤 9조

## 🎯 프로젝트 소개
Res9ue Team의 개인 지출 관리서비스 paylog 는 개인의 재정 상태를 체계적으로 파악하고, 지출과 수입을 보다 효율적으로 관리할 수 있도록 설계된 솔루션입니다.
사용자는 일상 속 다양한 지출 내역과 수입 정보를 손쉽게 기록하고, 이를 기반으로 카테고리별 분석을 통해 소비 패턴을 직관적으로 파악할 수 있습니다.

## 🛠 기술 스택
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Gradle
- Swagger (API 문서화)

## ERD
<img width="829" alt="스크린샷 2025-05-09 오전 11 16 31" src="https://github.com/user-attachments/assets/22b2b40e-8984-4b12-89f3-a37a0abb4ab0" />

## 와이어프레임
https://docs.google.com/presentation/d/1_WrHlgVfzsGPOvOLiX3fcW49o77jRFrEaQY-C-p8giE/edit?slide=id.g3559da418c2_0_0#slide=id.g3559da418c2_0_0

## Local 환경 설정 (application-local.yml)
- application-local-template.yml 파일을 복사해서 application-local.yml을 생성하세요.

```cp src/main/resources/application-local-template.yml src/main/resources/application-local.yml```

### domain 아래 본인의 디렉토리(e.g. expenses)에 사용하실 디렉토리를 생성
### 해당 디렉토리의 아래와 구조로 작업
```
├── controller
│   └── ExpenseController.java
│   └── ***Controller.java
├── service
│   └── ExpenseService.java
│   └── ***Service.java
├── repository
│   └── ExpenseRepository.java
│   └── ***Repository.java
├── entity
│   └── Expense.java
│   └── ***.java
└── dto
    ├── ExpenseRequestDto.java
    ├── ExpenseResponseDto.java
    ├── ***RequestDto.java
    └── ***ResponseDto.java
```

### Auditing 사용법
### Entity에서 extends BaseTimeEntity 추가
```
// Auditing 예제
@Entity
public class Expense extends BaseTimeEntity {
    // createdAt, updatedAt 필드 자동 포함됨
}
```
