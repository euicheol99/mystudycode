<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>햄버거 주문 페이지</h1>
    <h2>오늘의 날짜</h2>

    <%
        Date today = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
    %>
    
    <h4><%=sdf.format(today)%></h4>
    <form action="/JSP/confirmHamburger.do">
        <fieldset>
            <legend>주문자 정보</legend>
            <table>
                <tr>
                    <td>이름 </td>
                    <td><input type="text" name="userName"></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td>요청메시지</td>
                    <td><textarea name="message"></textarea></td>
                </tr>
            </table>
            <br>
        </fieldset>
        
        <fieldset>
            <legend>주문정보</legend>
            <table>
                <tr>
                    <th>햄버거</th>
                    <td>
                        <select name="hamburger">
                            <option>새우버거</option>
                            <option>불고기버거</option>
                            <option>한우버거</option>
                            <option>햄버거</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>토핑</th>
                    <td>
                        <label>
                            <input type="checkbox" name="topping" value="고구마무스">고구마무스
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="치즈크러스트">치즈크러스트
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="치즈바이트">치즈바이트 
                        </label>
                    </td> 
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="topping" value="치즈추가">치즈추가<input type="checkbox" name="topping" value="베이컨,소세지">베이컨,소세지<input type="checkbox" name="topping" value="파인애플">파인애플</td>
                </tr>
                <tr>
                    <th>사이드</th>
                    <td><input type="checkbox" name="side" value="콜라">콜라<input type="checkbox" name="side" value="사이다">사이다<input type="checkbox" name="side" value="환타">환타</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="side" value="핫소스">핫소스<input type="checkbox" name="side" value="파마산">파마산<input type="checkbox" name="side" value="피클">피클</td>
                </tr>
                <tr>
                    <th>결제방식</th>
                    <td><input type="radio" name="payment" value="카드결제">카드결제<input type="radio" name="payment" value="현금결제">현금결제</td>
                </tr>
            </table>
        </fieldset>
        <br>
        <input type="submit" value="주문">
        <input type="reset">
    </form>
</body>
</html>