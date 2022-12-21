## 학습 목표

mvc가 어떻게 생기게 되었는지 알 수 있다.

<br>

### Servlet, jsp 으로 회원관리 구현하기

- 회원은 username, age 만으로 이루어져 있다.

## Servlet으로 회원리스트 기능 구현하기

```java
@WebServlet(name="memberListServlet",urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write(" <meta charset=\"UTF-8\">");
        w.write(" <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write(" <thead>");
        w.write(" <th>id</th>");
        w.write(" <th>username</th>");
        w.write(" <th>age</th>");
        w.write(" </thead>");
        w.write(" <tbody>");
        for (Member member : members) {
            w.write(" <tr>");
            w.write(" <td>" + member.getId() + "</td>");
            w.write(" <td>" + member.getUsername() + "</td>");
            w.write(" <td>" + member.getAge() + "</td>");
            w.write(" </tr>");
        }
        w.write(" </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");


    }
}
```

servlet은 java 파일 안에 뷰(View)화면을 위한 HTML을 작성하는 것이 매우 불편하다.

또한 디버깅으로 찾기에 어려움이 있다.!

내가 만약 </table>을 </tbale>로 작성해도 빨간줄이 뜨지 않는다....

그래서 나온것이 jsp!!

## JSP로 회원리스트 기능 구현하기

```jsp
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>

<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
  <%
    for (Member member : members) {
      out.write(" <tr>");
      out.write(" <td>" + member.getId() + "</td>");
      out.write(" <td>" + member.getUsername() + "</td>");
      out.write(" <td>" + member.getAge() + "</td>");
      out.write(" </tr>");
    }
  %>
  </tbody>
</table>
</body>
</html>
```

이제 뷰 작업을 위한 HTML과 동적 컨텐츠를 제공하는 자바 코드가 어느정도 분리가 되었지만

비지니스 로직이 jsp에 노출이 되어있고, 완벽한 분리가 되어있지 않고 있다.
그래서 나온 것이 MVC 패턴!!

<br>

## MVC패턴

이제 우리는 Servlet을 컨트롤러로 사용하고, JSP을 뷰로 사용해서 MVC패턴을 적용할 수 있다.

Servlet의 비즈니스 로직을 처리한 결과를

request.setAttribute()을 통해 데이터를 보관하고

request.getAttribute()을 통하여 조회할 수 있다.

MVC 패턴을 적용하며 회원리스트 기능 구현하기
<img src="https://user-images.githubusercontent.com/62232531/208922566-9c4aedd2-f511-41a3-92d2-bb80635b6a4a.png">

컨트롤러(servlet)

````java
@WebServlet(name="mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members =memberRepository.findAll();
        request.setAttribute("members",members);
        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
```j
회원객체리스트를 request.setAttribute()을 이용하여 보관



뷰(jsp)
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
  <c:forEach var="item"  items="${members}">
    <tr>
      <td>${item.id}</td>
      <td>${item.username}</td>
      <td>${item.age}</td>
    </tr>


  </c:forEach>

  </tbody>
</table>
</body>
</html>
````

뷰에서는 jstl 문법을 사용하여 members 객체를 쉽게 빼올 수 있다.

<br>

출처 - 스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술 - 인프런
