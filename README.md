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
- 레이어 이동간 데이터는 Dto 클래스를 이용한다.
- Application Layer는 Domain Layer에 의존한다.
- Domain Layer는 Application Layer에 의존하지 않는다.

## TODO

- Dto 클래스 생성 근거 (매 Usecase에 in/out 클래스를 매번 구현? 어느정도 합의?)
