# `동기` vs `비동기`

**HTTP Method**

- `GET` - 쿼리스트링이 url에 넘어간다.
- `POST` - 파라미터가 `body`에 포함( request.getParameter)로 파싱 가능

### Request

<img src="https://user-images.githubusercontent.com/62232531/200177503-c245df44-f75c-4995-b4a6-acc72a2abb94.png">

`Parameter` 는 웹 컨테이너에 의해 자동으로 파싱됨

Spring에서는 `body`을 직접 파싱해야 함 ⇒ **`@PathVariable`**

### Response

<img src="https://user-images.githubusercontent.com/62232531/200177526-da821fee-5990-4114-890a-f569051d2ec0.png">

response - `header` `outbuffer`

**`outbuffer`**에 html을 다 넣기에는 유지보수하기 힘듦

⇒ jsp을 이용하여 유지보수!

## `동기` vs `비동기`

<img src="https://user-images.githubusercontent.com/62232531/200177564-67e0c175-988e-4db4-8c4c-058cd4611441.png">

### 동기

요청을 보냈을 때 응답이 돌아와야 다음 동작을 수행할 수 있다.

B작업이 모두 진행 될때까지 A작업은 대기해야한다. ⇒ `Blocking`

**요청과 응답의 순서가 유지**

### 페이지 전체 갱신!!!

### 비동기

- XHR 객체를 사용한 Web 2.0

요청을 보냈을 때 응답 상태와 상관없이 다음 동작을 수행 할 수 있다.

B작업이 시작하면 동시에 A작업이 실행된다. ⇒ `NonBlocking`

B작업은 결과값이 나오는대로 출력된다.

**순서를 보장 하지 않음**

# 결론

## `동기`의 경우 Controller(전체) 가장 적합함

## `비동기`의 경우 RestController(부분)이 가장 적합함

<br>

# RESTful은 B2B에 적합함!!!
