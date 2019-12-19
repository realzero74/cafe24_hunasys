<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>휴나몰입니다.</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="/resources/css/common.css" type="text/css">
	<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.blockui.js"></script>
</head>

<body>
	<div id="wrap">
		<div id="container">
			<div id="logincont">
				<div class="contStep01">
					<img src="/resources/image/layout/login_topImg.jpg" alt="logo" title="logo" />
				</div>
				<!-- contStep01 끝 -->

				<div class="contStep02">
					<div class="contView">
						<table border="0" cellspacing="0" class="tbl_type01">
							<colgroup>
								<col width="442px" />
								<col width="450px" />
							</colgroup>
							<tbody>
								<tr>
									<td>
										<table cellspacing="0" class="tbl_type02">
											<colgroup>
												<col width="70px" />
												<col width="200px" />
												<col width="140px" />
												<col width="30px" />
											</colgroup>
											<tbody>
												<tr>
													<td rowspan="3"></td>
													<td><input id="user_id" type="text" class="input02" placeholder="아이디" tabindex="1"></td>
													<td rowspan="2" style="text-align: center;"><button type="button" id="login_btn"><img src="/resources/image/btn/btn_login.jpg" /></button></td>
													<td rowspan="3"></td>
												</tr>
												<tr>
													<td><input id="user_pw" type="password" class="input02"  placeholder="비밀번호" tabindex="2"></td>
												</tr>
											</tbody>
										</table>

									</td>
									<td><img src="/resources/image/layout/namecard.jpg"	alt="바코드솔루션 전문기업 휴나몰" title="바코드솔루션 전문기업 휴나몰" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<div class="contStep03">
					<img src="/resources/image/layout/login_bomImg.jpg" alt="bar" title="bar" />
				</div>
				<!-- contStep01 끝 -->
				
			</div>
			<!-- logincont 끝 -->

		</div>
		<!-- container 끝 -->
	</div>
	<script>
		'use strict';

		$("#login_btn").on("click",function (){
			$.ajax({ 
				url: "/login_check", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소 
				data: { // HTTP 요청과 함께 서버로 보낼 데이터 
					"user_id" : $("#user_id").val(),
					"user_pw" : $("#user_pw").val()
				}, 
				method: "POST", // HTTP 요청 메소드(GET, POST 등) 
				dataType: "text" // 서버에서 보내줄 데이터의 타입 (json, text 등)
			}) 
			// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨. 
			.done(function(resultdata) {
				if(resultdata == "success"){
			        $.blockUI({ 
			            message: '<h1>로그인되었습니다.</h1>', 
			            timeout: 2000,
			            onUnblock : function (){ location.href="/orders"; }  
			        });
				}
				else {
					$.blockUI({ 
			            message: '<h1>로그인에 실패 하였습니다.</h1>', 
			            timeout: 2000 
			        });
				}
			}) 
			// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨. 
			.fail(function(xhr, status, errorThrown) {
				$.blockUI({ 
		            message: '<h1>오류가 발생 하였습니다.</h1>', 
		            timeout: 2000 
		        });
				console.log("오류명: " + errorThrown ); 
				console.log("상태: " + status); 
			}) 
			// .always(function(xhr, status) { $("#text").html("요청이 완료되었습니다!"); });
		});
	</script>
</body>

</html>