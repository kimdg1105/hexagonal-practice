# hexagonal-practice

EDA 기반 Microservice 구현

- ## Application Layer
    - Input Port (Interface)
    - Use case
    - Output Port (Interface)
- ## Domain Layer
    - model

- ## Infrastructure Layer
    - jpa adapter
    - kafka adapter
    - web adapter

## Rule

- 유스케이스 단위로 클래스를 생성한다.
- Application Layer는 Domain Layer에 의존한다.
- Domain Layer는 Application Layer에 의존하지 않는다.
