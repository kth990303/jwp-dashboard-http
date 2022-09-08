# 톰캣 구현하기
## HTTP 서버 구현 요구사항
- `http://localhost:8080/index.html` 페이지에 접근 가능하다.
- 접근한 페이지의 `js`, `css` 파일을 불러올 수 있다.
- `uri`의 `QueryString`을 파싱하는 기능이 있다.

## 로그인 구현 요구사항
- 로그인 여부에 따라 다른 페이지로 이동시킨다.
  - 로그인에 성공하면 응답 헤더에 http status code를 `302`로 반환하고 `/index.html`로 리다이렉트 한다.
  - 로그인에 실패하면 `401.html`로 리다이렉트한다.
- POST로 들어온 요청의 Request Body를 파싱할 수 있다.
  - `http://localhost:8080/register` 으로 접속하면 회원가입 페이지(`register.html`)를 보여준다.
- 로그인에 성공하면 HTTP Reponse의 헤더에 `Set-Cookie`가 존재한다.
- 서버에 세션을 관리하는 클래스가 있고, 쿠키로부터 전달 받은 `JSESSIONID` 값이 저장된다.

## 스레드 구현 요구사항
- Executors로 Thread Pool 적용
- 동시성 컬렉션 사용하기