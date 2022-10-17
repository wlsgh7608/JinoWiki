# 브라우저가 웰컴페이지를 요청했다고 가정하자.

### 전체 디렉토리 구조

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/32e726d6-a2ef-4d2a-89de-5597215ebe23/Untitled.png)

1. **_web.xml_**

사용자의 모든 요청을 `DispatcherServlet`이 전달받음

`DispatcherServlet`은 `servlet-context.xml`으로 넘겨짐

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b05b5f45-c66c-4671-9972-c4827555b41f/Untitled.png)

2. **_servlet-context.xml_**

com.ssafy.bookstore의 @Controller, @Repository , @Sevice , @Component을 가진 클래스를 `bean` 에게 매핑

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5268f813-c3c5-46c3-ae44-640074cad56d/Untitled.png)

3. **_homeController_**

웰컴페이지(url : / , method : get)이므로 name 메소드 실행하여 문자열 `home` 리턴

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e221b9c1-5e80-4232-a677-fd9972f2ddac/Untitled.png)

4. **_servlet-content.xml_**

servlet-content은 결과값 home에 prefix, suffix을 붙여 `DispatcherServlet`에게 전달

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8595d2a4-f1f6-49db-b645-90694c845beb/Untitled.png)

5. DispatcherServlet은 `home.jsp`을 실행한 결과 html 사용자에게 보냄
