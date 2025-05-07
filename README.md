# hackerthon5-Res9ueTeam-BE
커널360 5기 해커톤 9조

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
