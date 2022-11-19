Best Case

```java
String word = "World";
// 성능 상, 가독성 최상
logger.debug("Hello {}", word);
```

logger.debug() 메소드가 실행 되기전 Log Level을 확인하기전 ("Hello {}", word) 의 문자열 연산을 하기 때문인데 해당 logger는 문자열 연산이 일어나지 않는다.

- " + " 와 같은 연산이 없기 떄문에
- 메소드 호출과 같은 추가 기능이 없기때문.
- SLF4J의 치환문자 { } 를 활용해라.
