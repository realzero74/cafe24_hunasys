<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>휴나닉 주문관리 서비스</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="/resources/css/common.css" type="text/css">

</head>

<body>

	<div id="wrap">

		<div id="container">
			<div id="header">
				<div id="hdconts02">

				</div><!-- hdconts01 끝 -->
			</div><!-- header 끝 -->

			<div id="contents">
				<div id="conts02">
					<div class="mpTitle01">
						<a href="orderReg.html"><img src="/resources/image/btn/btn_reg.gif"></a>

					</div>
					<div class="mpResult">
						<table cellspacing="0" class="tbl_type01">
							<tbody>
								<tr>
									<td>
										<table cellspacing="0" class="tbl_type41">
											<colgroup>
												<col width="5%" />
												<col width="35%" />
												<col width="30%" />
												<col width="10%" />
												<col width="10%" />
												<col width="10%" />
											</colgroup>
											<tbody>
												<tr>
													<th>
														번호
													</th>
													<th>
														기본정보
													</th>
													<th>
														기타메모
													</th>
													<th>
														주문일
													</th>
													<th>
														납기일
													</th>
													<th>
														인쇄
													</th>

												</tr>
												<tr>
													<td>
														1
													</td>
													<td style=" text-align:left">
														회사명: 개그콘서트 대박 완전 잼 있어요 <img src="/resources/image/btn/icon_new.gif"
															alt="새로운글" title="새로운글" />
														<br><br>
														품명:
														<br>
														규격:
														<br>
														용지:

													</td>
													<td style=" text-align:left">
														배달부탁드립니다.
													</td>
													<td>
														2012.02.02 11:12:23
													</td>
													<td>
														<img src="/resources/image/btn/btn_cancel.jpg"><br><br>2012.02.02
														11:12:23
													</td>
													<td>
														<img src="/resources/image/btn/btn_print.jpg">
													</td>
												</tr>

											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</div><!-- mpResult 끝 -->

					<div class="paginate">
						<!-- paginate -->

						<a href="#none" class="none"><img src="/resources/image/btn/btn_front.gif" alt="처음" /></a>
						<a href="#none" class="none"><img src="/resources/image/btn/btn_pre.gif" alt="이전" /></a>
						<a href="#none"><strong>1</strong></a>
						<a href="#none">2</a>
						<a href="#none">3</a>
						<a href="#none">4</a>
						<a href="#none">5</a>
						<a href="#none">6</a>
						<a href="#none">7</a>
						<a href="#none">8</a>
						<a href="#none">9</a>
						<a href="#none">10</a>
						<a href="#none" class="none"><img src="/resources/image/btn/btn_nxt.gif" alt="다음" /></a>
						<a href="#none" class="none"><img src="/resources/image/btn/btn_end.gif" alt="끝" /></a>

					</div>
					<!--//paginate -->

				</div><!-- conts02 끝 -->

			</div><!-- contents 끝 -->

		</div><!-- container 끝 -->

	</div>

</body>

</html>