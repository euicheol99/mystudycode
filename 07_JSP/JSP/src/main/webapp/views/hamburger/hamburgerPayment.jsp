<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String name = (String)request.getAttribute("name");
    int phone = (int)request.getAttribute("phone");
    String address = (String)request.getAttribute("address");
    String message = (String)request.getAttribute("message");
    String hamburger = (String)request.getAttribute("hamburger");
    String[] toppingList = (String[])request.getAttribute("toppingList");
    String[] sideList = (String[])request.getAttribute("sideList");
    String payment = (String)request.getAttribute("payment");
    int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charget="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>피자 결제 페이지</h1>

    <h2> 주문내역</h2>

    [주문자 정보]
    <ol>
        <li>성함 : <%=name%></li>
        <li>전화번호: <%=phone%></li>
        <li>주소 : <%=address%></li>
        <li>요청사항 : <%=message%></li>
    </ol>
    <br>

    [주문 정보]
    <ol>
        <li>햄버거: <%= hamburger %></li>
        <li>토핑: <%= toppingList != null ? String.join(",", toppingList) : "없음" %></li>
        <li>사이드: <%= sideList != null ? String.join(",", sideList) : "없음" %></li>
        <li>결제방식: <%= payment != null ? payment : "선택되지 않음" %></li>
    </ol>

    <h3>위와 같이 주문하셨습니다.</h3>
    <h2>총 가격 : <%=price%>원</h2>
</body>
</html>