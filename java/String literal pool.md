## String literal pool vs String instance

<br>
모든 레퍼런스 타입의 객체는 `new` 연산을 통하여 객체를 생성하여야 한다.

하지만 String은 new을 사용하게 되면 같은 내용이라고 할지라도 Instance 영역에 생성되게 된다.

String은 레퍼런스 타입으로 new을 통하여 객체를 생성하여 가리킨다.

```java
String s1 = new String("java");
String s2 = new String("java");
```

BUT, String의 값이 같더라도 계속 Instance 영역에 객체가 생성될 것이다. 이와 같은 객체가 수 없이 많은 경우 Instance가 꽉차게 될 것이다.

이러한 비효율성을 극복하기 위하여 JVM은 예외를 두었다.

<br>

그것은…..**String literal Pool**

String literal pool은 `c-value comparator` 에서 new가 없는 문자열에 대하여 해당 String있는지 파악

없을 시 String literal pool 영역에 String 객체를 생성

String literal Pool에 생성 방법

String variable = `“ ”` # String literal 로 생성하면 끝

```java
String s3 = "java";
String s4 = "java"; // "java" 가 String literal pool에 이미 존재
```

### String literal Pool의 단점

instance와 달리 String literal pool은 프로그램 제거할 때 까지 메모리에서 사라지지 않는다.

따라서 문자열을 가공하거나 하는 듯한 연산은 String literal pool 보다는 메소드를 사용하여 `instance` 객체에 저장하자.

# 결론

String 객체를 생성하는 방법은 2가지가 있다.

```java
1. String name = new String(”진호”); // instance의 eden 영역에 생성
2. String name = “진호”; // c-value comparator가 “진호”있는 지 확인 후 없으면 String literal pool 에 생성
```
