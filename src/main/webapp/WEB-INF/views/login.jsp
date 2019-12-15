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
									<form action="/login_check" method="post">
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
													<td><input name="user_id" type="text" class="input02" placeholder="아이디" tabindex="1"></td>
													<td rowspan="2" style="text-align: center;"><button type="submit" id="login_btn"><img src="/resources/image/btn/btn_login.jpg" /></button></td>
													<td rowspan="3"></td>
												</tr>
												<tr>
													<td><input name="user_pw" type="password" class="input02"  placeholder="비밀번호" tabindex="2"></td>
												</tr>
											</tbody>
										</table>
									</form>

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
</body>

</html>