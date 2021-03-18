# Chapter 03
## JPA
### Entity 클래스에는 절대 Setter 메소드를 만들지 않는다.  
> 기본적으로는 생성자를 통해 최종값을 채우고 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가하자.  
> (무작정 setter를 만들면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 구분할 수가 없다.)  
___
###JPA Repository
> ibatis, MyBatis 등에서 Dao라고 불리는 DB Layer 접근자이다.  
> 인터페이스로 생성하고 JpaRepository<Entity클래스, PK타입>을 상속하면 기본 CRUD 메소드가 자동으로 생성된다.  
> * 주의 : Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다. 따라서 도메인 패키지에서 함께 관리한다.(Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없다.)  

