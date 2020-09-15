[SOLID]
1. SRP - 하나의 객체는 하나의 역할만 가진다.
2. OCP - 의존하는 코드는 변경하지 않으면서 변화해야한다. (캡슐화와 이어진다)
3. LSP - 부모 타입이 하는 역할에 자식 타입이 온다고 해서 기능이 동작하지 않으면 안된다.
4. ISP - 클라이언트 관점에서 기능들은 독립적으로 동작해야한다.
5. DIP - 의존할 때는 변화하지 않는 것(즉 인터페이스, 추상 클래스)와 같이 구체적이지 않은 것에 의존해야한다.

[개념]
1. 추상화 
- 해당 객체를 인식할 수 있는 성질의 집합
- 인식의 단위
- 직관적으로 어떤 역할을 할지 인식되는 범위

2. 캡슐화
- 정보의 은닉
- 클라이언트가 알지 않아도 되는 정보를 캡슐화한다.
- 클라이언트가 몰라도 되는 정보는 해당 객체가 변할 수 있는 정보이다.
- 역으로 어떤 객체(함수)가 자주 변화한다면 이것은 캡슐화의 대상이 된다.

[생각하자]
1. 변화할 수 있는 것들을 리스트 업하기
2. 변화할 수 있는 것들이 생성 / 구조 / 행위 인지 판단하기
3. 적용 가능한 패턴을 찾아보기
4. 패턴 적용하여 소스 코기 짜기

[연습하자]
1. Searcher.java 
- 행위 패턴 > 전략 패턴
    - Google API 호출을 Google Custom Search Library로 한다면 Google API 객체 생성 > 팩토리 패턴이 맞을듯함.
    - 현재는 단순히 일반화하여 사용함.
    - 두 개의 패턴이 서로 다르며 적용 가능하다고 할 때.. 어떤 판단 기준을 가지고 선택하는게 좋을까?
    - 변화 가능성 / 은닉화/ 확장성

2. core 디렉토리
- 생성 패턴 > 싱글톤 패턴
