<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
<style>
/*	프린트 페이지 기본 처리  */
body {
	margin: 0;
	padding: 0;
	font: 10pt "Tahoma";
}

* {
	box-sizing: border-box;
	-moz-box-sizing: border-box;
}

.btnbar {
	width: 100%;
	height: 45px;
	background-color: darkgrey;
	box-shadow: 0px 3px 5px rgba(0, 0, 0, 0.5);
	padding: 10px;
	text-align: right;
}

.btnbar button {
	border: none;
	border-radius: 4px;
	width: 75px;
	height: 25px;
}

.page {
	width: 21cm;
	min-height: 29.7cm;
	padding: 2cm;
	margin: 1cm auto;
	border-radius: 5px;
	background: white;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.5);
}

.subpage {
	padding: 0cm;
	height: 256mm;
}

@page {
	size: A4 portrait;
	margin: 0;
}

@media print {
	.page {
		margin: 0;
		border: initial;
		border-radius: initial;
		width: initial;
		min-height: initial;
		box-shadow: initial;
		background: initial;
		page-break-after: always;
	}
	.btnbar {
		display: none;
	}
}
/*	프린트 페이지 기본 처리 - end */

/* 출력컨텐츠 처리 */
#headerTitle {
	display: block;
	text-decoration: none;
	text-align: center;
	font-size: 3em;
	font-weight: bold;
	padding-bottom: 30px;
	color: #000;
}

#headerSignBox {
	height: 90px;
	margin: 10px auto;
}

#headerSignBox table {
	float: right;
	width: 300px;
	height: 90px;
	border-collapse: collapse;
}

#headerSignBox table:after {
	clear: both;
}

#headerSignBox table th {
	text-align: center;
	border: 1px solid #000;
}

#headerSignBox table td {
	text-align: center;
	border: 1px solid #000;
}

#contents {
	height: 750px;
	margin: 10px auto;
}

#contents table {
	width: 100%;
	border-collapse: collapse;
}

#contents table th {
	text-align: center;
	padding: 5px 5px;
	height: 50px;
	border: 1px solid #000;
}

#contents table td {
	text-align: left;
	padding: 5px 10px;
	border: 1px solid #000;
}

#contents table td textarea{
    width: 100%;
    height: 470px;
    margin: 0px;
    resize: none;
    overflow: hidden;
    border: none;
    background-color: white;
    color: black;
}
</style>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/lib/jquery-1.12.4.min.js"></script>
</head>

<body>
	<div class="btnbar">
		<button id="btn_print">프린트</button>
		<button id="btn_cancel">취소</button>
	</div>
	<div class="book">
		<div class="page">
			<div class="subpage">
				<div id="header">
					<div id="headerTitle">
						<span>작업지시서</span>
					</div>

					<div id="headerSignBox">
						<table cellspacing="0" class="tbl_type04">
							<colgroup>
								<col width="25%" />
								<col width="25%" />
								<col width="25%" />
								<col width="25%" />
							</colgroup>
							<tbody>
								<tr style="height: 30%;">
									<td rowspan="2">결재</td>
									<td>작성</td>
									<td>검토</td>
									<td>승인</td>
								</tr>
								<tr style="height: 70%;">
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>

				</div>
				<!-- header 끝 -->

				<div id="contents">
					<table cellspacing="0" class="tbl_type05">
						<colgroup>
							<col width="13%" />
							<col width="21%" />
							<col width="13%" />
							<col width="20%" />
							<col width="13%" />
							<col width="20%" />
						</colgroup>
						<tbody>
							<tr>
								<th>구분</th>
								<td>${order.itemClsNm}</td>
								<th>품명</th>
								<td colspan="3">${order.itemNm}</td>
							</tr>
							<tr>
								<th>발주회사</th>
								<td>${order.company}</td>
								<th>규격</th>
								<td>${order.itemSpec}</td>
								<th>수량</th>
								<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${order.totalQty}" /></td>
							</tr>
							<tr>
								<th>용지</th>
								<td>${order.paper1Nm} ${order.paper2Nm}</td>
								<th>지관</th>
								<td>${order.parerRollNm}</td>
								<th>1롤 수량</th>
								<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${order.rollQty}" /></td>
							</tr>
							<tr>
								<th>실사용지</th>
								<td>${order.paper3Nm} ${order.paper4Nm}</td>
								<th>납기일</th>
								<td>${order.dueDate}</td>
								<th>납품방법</th>
								<td>${order.deliveryNm}</td>
							</tr>
							<tr>
								<th style="height: 490px;">기타설명</th>
								<td colspan="6">
									<textarea disabled>${order.description}</textarea>
								</td>
							</tr>
							<tr>
								<th>작업완료</th>
								<td colspan="2">${order.endDate} ${order.endTime}</td>
								<th>발주자 확인</th>
								<td colspan="2">휴나닉(인)</td>
							</tr>

						</tbody>
					</table>
				</div>
				<!-- contents 끝 -->

			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	'use strict';
	$(function() {
		$("#btn_print").on("click",function (){
			window.print();
			window.close();
		});
		$("#btn_cancel").on("click",function (){
			window.close();
		});
	});
</script>
</html>