# 브라우저가 웰컴페이지를 요청했다고 가정하자.

### 전체 디렉토리 구조

<img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F32e726d6-a2ef-4d2a-89de-5597215ebe23%2FUntitled.png?table=block&id=1391de04-4fad-4af9-86bd-7251814da286&spaceId=7ea9111c-81e4-4df3-ae22-1260e4d0da86&width=2000&userId=95771340-6e22-4a0f-ac96-8c479e99bd1f&cache=v2">

1. **_web.xml_**

사용자의 모든 요청을 `DispatcherServlet`이 전달받음

`DispatcherServlet`은 `servlet-context.xml`으로 넘겨짐

<img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fb05b5f45-c66c-4671-9972-c4827555b41f%2FUntitled.png?table=block&id=ebfc4287-260a-4425-b911-0135485c5717&spaceId=7ea9111c-81e4-4df3-ae22-1260e4d0da86&width=2000&userId=95771340-6e22-4a0f-ac96-8c479e99bd1f&cache=v2">

2. **_servlet-context.xml_**

com.ssafy.bookstore의 @Controller, @Repository , @Sevice , @Component을 가진 클래스를 `bean` 에게 매핑

<img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F5268f813-c3c5-46c3-ae44-640074cad56d%2FUntitled.png?table=block&spaceId=7ea9111c-81e4-4df3-ae22-1260e4d0da86&id=02b2865c-871f-44fb-9b29-3afe95dba702&width=2000&userId=95771340-6e22-4a0f-ac96-8c479e99bd1f&cache=v2">

3. **_homeController_**

웰컴페이지(url : / , method : get)이므로 name 메소드 실행하여 문자열 `home` 리턴

<img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fe221b9c1-5e80-4232-a677-fd9972f2ddac%2FUntitled.png?table=block&id=39816d1b-df8d-4eee-8891-340346f29a42&spaceId=7ea9111c-81e4-4df3-ae22-1260e4d0da86&width=2000&userId=95771340-6e22-4a0f-ac96-8c479e99bd1f&cache=v2">

4. **_servlet-content.xml_**

servlet-content은 결과값 home에 prefix, suffix을 붙여 `DispatcherServlet`에게 전달

<img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F8595d2a4-f1f6-49db-b645-90694c845beb%2FUntitled.png?table=block&id=15b15cb1-9acd-4b2b-a797-1caea811c5ae&spaceId=7ea9111c-81e4-4df3-ae22-1260e4d0da86&width=2000&userId=95771340-6e22-4a0f-ac96-8c479e99bd1f&cache=v2">

5. DispatcherServlet은 `home.jsp`을 실행한 결과 html 사용자에게 보냄
