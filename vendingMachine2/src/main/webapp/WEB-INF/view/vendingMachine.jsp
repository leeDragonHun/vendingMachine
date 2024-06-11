<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>자판기</title>
</head>
<style>
</style>
<body>
	<h3>음료수 자판기</h3>
	<table border="1">
		<c:forEach var="l" items="${list }" varStatus="status">
			<tr>
				<td colspan="2">
					${l.productName } <span id="productPrice${status.index}"}>${l.productPrice }</span>원 재고:${l.productStock }개
					<form action="${pageContext.request.contextPath}/buy" method="post" id="frm${status.index}">
						<input type="hidden" value="${l.productKey }" name="productKey">
						<input type="hidden" value="${l.productName }" name="productName">
						<input type="hidden" value="${l.productPrice }" name="productPrice">
						<input type="hidden" value="${l.productStock }" name="productStock">
						<c:if test="${l.productStock >= 1 && balance >= l.productPrice}">
							<button type="submit" class="buyBtn" id="buyBtn${status.index}">구매</button>
						</c:if>
						<c:if test="${l.productStock >= 1 && balance < l.productPrice}">
							<button disabled="disabled">잔액부족</button>
						</c:if>
						<c:if test="${l.productStock < 1}">
							<button disabled="disabled">품절</button>
						</c:if>
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr style="height: 200px;">
			<td>
				잔액 : <br>
				<!-- <div id="balance"> 0 </div> -->
				<form method="post" action="${pageContext.request.contextPath}/change">
					${balance }
					<input type="hidden" name="balance" value="${balance }">
					<button type="submit" id="cashBack">잔돈 반환</button>
				</form>
			</td>
			<td>
				금액투입구<br>
				<form method="post" action="${pageContext.request.contextPath}/inputCoin">
					<input type="hidden" value="10" name="coin">
					<button type="submit" id="inputCoin10" value="10" class="inputCoin">10</button>
				</form>
				<form method="post" action="${pageContext.request.contextPath}/inputCoin">
					<input type="hidden" value="50" name="coin">
					<button type="submit" id="inputCoin50" value="50" class="inputCoin">50</button>
				</form>
				<form method="post" action="${pageContext.request.contextPath}/inputCoin">
					<input type="hidden" value="100" name="coin">
					<button type="submit" id="inputCoin100" value="100" class="inputCoin">100</button>
				</form>
				<form method="post" action="${pageContext.request.contextPath}/inputCoin">
					<input type="hidden" value="500" name="coin">
					<button type="submit" id="inputCoin500" value="500" class="inputCoin">500</button>
				</form>
				<form method="post" action="${pageContext.request.contextPath}/inputCoin">
					<input type="hidden" value="1000" name="coin">
					<button type="submit" id="inputCoin1000" value="1000" class="inputCoin">1,000</button>
				</form>
				<form method="post" action="${pageContext.request.contextPath}/inputCoin">
					<input type="hidden" value="5000" name="coin">
					<button type="submit" id="inputCoin5000" value="5000" class="inputCoin">5,000</button>
				</form>
				<form method="post" action="${pageContext.request.contextPath}/inputCoin">
					<input type="hidden" value="10000" name="coin">
					<button type="submit" id="inputCoin10000" value="10000" class="inputCoin">10,000</button>
				</form>
			</td>
		</tr>
		<tr style="height: 200px;">
			<td colspan="2">
				잔돈 나오는 곳 <br>
				10,000원 : <span id="cashBack10000"></span> ${change.cashBack10000 }개 <br>
				5,000원 : <span id="cashBack5000"></span> ${change.cashBack5000 }개 <br>
				1,000원 : <span id="cashBack1000"></span> ${change.cashBack1000 }개 <br>
				500원 : <span id="cashBack500"></span> ${change.cashBack500 }개 <br>
				100원 : <span id="cashBack100"></span> ${change.cashBack100 }개 <br>
				50원 : <span id="cashBack50"></span> ${change.cashBack50 }개 <br>
				10원 : <span id="cashBack10"></span> ${change.cashBack10 }개
			</td>				
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/admin">관리자로 가기</a>
</body>
<script type="text/javascript">
/* 	var coin = 0; */
	
/* 	document.getElementById('inputCoin10').addEventListener('click', () => {
   		coin += 10;
   	 document.getElementById('balance').innerHTML = coin;
   		
	   });
	document.getElementById('inputCoin50').addEventListener('click', () => {
   		coin += 50;
   		document.getElementById('balance').innerHTML = coin;
	   });
	document.getElementById('inputCoin100').addEventListener('click', () => {
   		coin += 100;
   		document.getElementById('balance').innerHTML = coin;
	   });
	document.getElementById('inputCoin500').addEventListener('click', () => {
   		coin += 500;
   		document.getElementById('balance').innerHTML = coin;
	   });
	document.getElementById('inputCoin1000').addEventListener('click', () => {
   		coin += 1000;
   		document.getElementById('balance').innerHTML = coin;
	   });
	document.getElementById('inputCoin5000').addEventListener('click', () => {
   		coin += 5000;
   		document.getElementById('balance').innerHTML = coin;
	   });
	document.getElementById('inputCoin10000').addEventListener('click', () => {
   		coin += 10000;
   		document.getElementById('balance').innerHTML = coin;
	   });
	
	//잔돈 반환 눌렀을 때
	document.getElementById('cashBack').addEventListener('click', () => {
		
		var cashBack = coin;
   		//document.getElementById("cashBackCase").innerHTML = cashBack;
		
		cashBack10000 = parseInt(cashBack / 10000) ;
		document.getElementById("cashBack10000").innerHTML = cashBack10000;
	
		cashBack5000 = parseInt((cashBack % 10000) / 5000) ;
		document.getElementById("cashBack5000").innerHTML = cashBack5000;
	
		cashBack1000 = parseInt((cashBack % 5000) / 1000) ;
		document.getElementById("cashBack1000").innerHTML = cashBack1000;
	
		cashBack500 = parseInt((cashBack % 1000) / 500) ;
		document.getElementById("cashBack500").innerHTML = cashBack500;
	
		cashBack100 = parseInt((cashBack % 500) / 100) ;
		document.getElementById("cashBack100").innerHTML = cashBack100;
	
		cashBack50 = parseInt((cashBack % 100) / 50) ;
		document.getElementById("cashBack50").innerHTML = cashBack50;
	
		cashBack10 = parseInt((cashBack % 50) / 10) ;
		document.getElementById("cashBack10").innerHTML = cashBack10;
   		
   		coin = 0;
   		document.getElementById('balance').innerHTML = coin;
	   });
	 */
	
/* 	var buyBtns = document.getElementsByClassName('buyBtn');
	
	for (var i = 0; i < buyBtns.length; i++) {
		
	    buyBtns[i].addEventListener('click', function(e) {
	    	 var clickedButton = e.target;
	       
	         var buttonId = clickedButton.id; // 버튼의 id 속성 가져오기
	         var index = buttonId.slice(6)
	         
	         var price = parseInt(document.getElementById('productPrice'+index).textContent);
	         
	         if(coin<price){
	        	 alert('돈이 모자람!');
	         }else{
	        	 
	        	 document.getElementById("frm"+index).submit();
	         }
	       
	    });
	} */
	
	
</script>
</html>