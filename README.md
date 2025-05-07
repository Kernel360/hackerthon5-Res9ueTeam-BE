# hackerthon5-Res9ueTeam-BE
커널360 5기 해커톤 9조

## Local 환경 설정 (application-local.yml)
- application-local-template.yml 파일을 복사해서 application-local.yml을 생성하세요.

```cp src/main/resources/application-local-template.yml src/main/resources/application-local.yml```

### domain 아래 본인의 디렉토리(e.g. expenses)에 사용하실 디렉토리를 생성
### 해당 디렉토리의 아래와 구조로 작업
```
└── expenses
    ├── controller
    │   └── ExpenseController.java
    ├── service
    │   └── ExpenseService.java
    ├── repository
    │   └── ExpenseRepository.java
    ├── entity
    │   └── Expense.java
    └── dto
        ├── ExpenseRequestDto.java
        └── ExpenseResponseDto.java
```
