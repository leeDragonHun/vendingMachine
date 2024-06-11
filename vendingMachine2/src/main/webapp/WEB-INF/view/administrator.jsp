<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자</title>
</head>
<body>
	<h3>관리자</h3>
	<table border="1">
		<tr>
			<td colspan="2">
				제품 추가
				<form method="post" action="${pageContext.request.contextPath}/addProduct">
					제품 : <input type="text" name="productName" style="width: 80px;">
					가격 : <input type="number" name="productPrice" style="width: 60px;">
					<button type="submit">추가</button>
				</form>
			</td>
		</tr>
		<c:forEach var="l" items="${list }" varStatus="status">
			<tr>
				<td colspan="2">
					${l.productName }
					<form method="post" action="${pageContext.request.contextPath}/delProduct">
						<input type="hidden" name="productName" value="${l.productName }">
						<input type="hidden" name="productKey" value="${l.productKey }">
						<button type="submit">그만팔기</button>
					</form>
					<form method="post" action="${pageContext.request.contextPath}/updatePrice">
						가격 : ${l.productPrice }<br>
						<input type="hidden" name="productKey" value="${l.productKey }">
						<input type="number" name="updatePrice" style="width: 60px;">
						<button type="submit">가격변경</button>
					</form>
					<form method="post" action="${pageContext.request.contextPath}/addStock">
						재고 : ${l.productStock }<br>
						<input type="hidden" name="productKey" value="${l.productKey }">
						<input type="number" name="addStock" style="width: 40px;">
						<button type="submit">재고채우기</button>
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				총수입 : ${totalRevenue }원<br>
				제품별 수입 :<br>
				<c:forEach var="pr" items="${productRevenue }">
					${pr. productName}의 수입 : ${pr. productRevenue}원<br>
				</c:forEach>
			</td>
			<td>
				현금재고 : <br>
				<table>
					<c:forEach var="ct" items="${cashStock }">
						<tr>
							<td>
								${ct.cashType } : ${ct.cashStock }개
							</td>
							<td>
								<form method="post" action="${pageContext.request.contextPath}/addCashStock">
									<input type="hidden" name="cashKey" value="${ct.cashKey }">
									<input type="hidden" name="cashType" value="${ct.cashType }">
									<input type="number" name="addCashStock" style="width: 40px;">
									<button>추가</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/main">자판기로 가기</a>
</body>
</html>