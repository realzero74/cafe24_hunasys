<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>휴나닉 주문관리 서비스 - 관리자</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/jqueryui.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/inlineCalendar.css" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jqueryui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery.blockui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/users.js?ver=202002081623"></script>
</head>

<body>

	<div id="wrap">

		<div id="container">
			<div id="header">
				<div id="hdconts03" style="position: relative;">
					<button id="btn_gomain" type="button" style="right: 0px; position: absolute;top: 45px;">
						<img src="${pageContext.request.contextPath}/resources/image/btn/btn_main.gif">
					</button>
				</div><!-- hdconts01 끝 -->
			</div><!-- header 끝 -->

			<div id="contents">

				<div id="conts02">
					<div id="rbtn_area" style="text-align: right; margin-top: 10px;">
						<button id="regbutton"><img src="${pageContext.request.contextPath}/resources/image/btn/btn_reg.gif"></button>
					</div>
					<div class="mpResult">
						<table cellspacing="0" class='tbl_type42'>
							<colgroup>
								<col width="5%" />
								<col width="10%" />
								<col width="20%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="10%" />
								<col width="10%" />
							</colgroup>
							<tbody id="userlist">
							</tbody>
						</table>
					</div><!-- mpResult 끝 -->

                    <div class="paginate" id="paginate">
						<!-- paginate -->
					</div>

				</div><!-- conts02 끝 -->

			</div><!-- contents 끝 -->

		</div><!-- container 끝 -->

	</div>


	<!-- popup 시작 -->
	<div id="userForm" style="width:300px; display: none;">
		<div style="text-align: right; margin: 10px auto; width:180px">
			<input id="editflag" type="hidden">
			<div style="margin: 10px 0;"><label for="userId">ID</label><input id="userId" type="text" class="input01" style="margin-left: 10px"></div>
			<div style="margin: 10px 0;"><label for="userPw">비밀번호</label><input id="userPw" type="password" class="input01" style="margin-left: 10px"></div>
			<div style="margin: 10px 0;"><label for="userComp">사용자(회사)</label><input id="userComp" type="text" class="input01" style="margin-left: 10px"></div>
		</div>
		
		<div class="contBtnSave" style="margin: 10px auto;">
			<button id="userFrmCancel" type="button">
				<img src="${pageContext.request.contextPath}/resources/image/btn/btn_c_cancel.gif" alt="취소" title="취소">
			</button>
			<button id="userFrmSave" type="button">
				<img src="${pageContext.request.contextPath}/resources/image/btn/btn_reg.gif" alt="등록하기" title="등록하기">
			</button>
		</div>
	</div>


</body>
<script>
	'use strict';
	console.log("in users list pages");
	var __contextPath__ = "${pageContext.request.contextPath}"; 
	var _loginUser = "${userId}";
	var _loginCls = "${userCls}";
	var userApp = new UserApp();
	userApp.initApp();
</script>
</html>