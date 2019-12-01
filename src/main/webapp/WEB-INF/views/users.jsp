<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>휴나닉 주문관리 서비스입니다</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="../css/common.css" type="text/css">
</head>

<body>

	<div id="wrap">

		<div id="container">
			<div id="header">
				<div id="hdconts03">

				</div><!-- hdconts01 끝 -->
			</div><!-- header 끝 -->

			<div id="contents">

				<div id="conts02">
					<div class="mpTitle02">

						사용자 아이디 <input type="text" class="input01"> &nbsp; &nbsp; &nbsp; &nbsp;비밀번호 <input type="text"
							class="input01"> &nbsp; &nbsp; &nbsp; &nbsp; <a href="memberPopup.html"
							onclick="window.open(this.href, '_blank', 'width=300px,height=300px,toolbars=no,scrollbars=no'); return false;">
							<img src="../image/btn/btn_reg.gif"></a>
					</div>
					<div class="mpResult">
						<table cellspacing="0" class="tbl_type01">
							<tbody>
								<tr>
									<td>
										<table cellspacing="0" class="tbl_type42">
											<colgroup>
												<col width="5%" />
												<col width="20%" />
												<col width="15%" />
												<col width="15%" />
												<col width="15%" />
												<col width="15%" />
												<col width="15%" />
											</colgroup>
											<tbody>
												<tr>
													<th>
														번호
													</th>
													<th>
														사용자ID
													</th>
													<th>
														구분
													</th>
													<th>
														가입일
													</th>
													<th>
														비밀번호 수정일
													</th>
													<th>
														비밀번호 변경
													</th>
													<th>
														사용자 삭제
													</th>

												</tr>
												<tr>
													<td>
														1
													</td>
													<td style=" text-align:left">user01
													</td>
													<td>
														슈퍼유저
													</td>
													<td>
														2012.02.02 11:12:23
													</td>
													<td>
														2012.02.02 11:12:23
													</td>
													<td>
														<a href="mModifyPopup.html"
															onclick="window.open(this.href, '_blank', 'width=300px,height=300px,toolbars=no,scrollbars=no'); return false;"><img
																src="../image/btn/btn_chagne.gif"></a>
													</td>
													<td>
														<a href="mDeletePopup.html"
															onclick="window.open(this.href, '_blank', 'width=300px,height=300px,toolbars=no,scrollbars=no'); return false;"><img
																src="../image/btn/btn_delete.gif"></a>
													</td>
												</tr>
												<tr>
													<td>
														2
													</td>
													<td style=" text-align:left">user02
													</td>
													<td>
														정회원
													</td>
													<td>
														2012.02.02 11:12:23
													</td>
													<td>
														2012.02.02 11:12:23
													</td>
													<td>
														<img src="../image/btn/btn_chagne.gif">
													</td>
													<td>
														<img src="../image/btn/btn_delete.gif">
													</td>
												</tr>
												<tr>
													<td>
														3
													</td>
													<td style=" text-align:left">user03
													</td>
													<td>
														비회원
													</td>
													<td>
														2012.02.02 11:12:23
													</td>
													<td>
														2012.02.02 11:12:23
													</td>
													<td>
														<img src="../image/btn/btn_chagne.gif">
													</td>
													<td>
														<img src="../image/btn/btn_delete.gif">
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

						<a href="#none" class="none"><img src="../image/btn/btn_front.gif" alt="처음" /></a>
						<a href="#none" class="none"><img src="../image/btn/btn_pre.gif" alt="이전" /></a>
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
						<a href="#none" class="none"><img src="../image/btn/btn_nxt.gif" alt="다음" /></a>
						<a href="#none" class="none"><img src="../image/btn/btn_end.gif" alt="끝" /></a>

					</div>
					<!--//paginate -->

				</div><!-- conts02 끝 -->

			</div><!-- contents 끝 -->

		</div><!-- container 끝 -->

	</div>

</body>

</html>