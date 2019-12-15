<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>휴나닉 주문관리 서비스 - 관리자</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/resources/css/common.css" type="text/css">
<link rel="stylesheet" href="/resources/css/jqueryui.css"
	type="text/css">
<style type="text/css">
td.today {
	color: #ffffff;
	font-weight: bold;
	border: solid thin 0pt;
	font-size: 9pt;
	background-color: #f4a2a3;
	cursor: pointer;
}

td.workday {
	color: #000099;
	font-weight: normal;
	border: solid thin 0pt;
	font-size: 9pt;
}

td.sunday {
	color: #f4a2a3;
	font-weight: normal;
	border: solid thin 0pt;
	font-size: 9pt;
}

td.satday {
	color: #0000ff;
	font-weight: normal;
	border: solid thin 0pt;
	font-size: 9pt;
}

td.week {
	color: #000000;
	font-weight: normal;
	border: solid thin 0pt;
	font-size: 9pt;
	background-color: #e6e6e6;
	width: 50px;
	height: 30px;
	text-align: center;
}

.preNext {
	color: #000099;
	text-decoration: none;
}
</style>
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/jqueryui.js"></script>
<script type="text/javascript" src="/resources/js/jquery.blockui.js"></script>
<script type="text/javascript"
	src="/resources/js/orders.js?ver=201912151623"></script>
</head>

<body>

	<div id="wrap">

		<div id="container">
			<div id="header">
				<div id="hdconts01"></div>
				<!-- hdconts01 끝 -->
			</div>
			<!-- header 끝 -->

			<div id="contents">

				<div id="conts01">
					<div id="left_conts01">
						<div id="calendarView"></div>
					</div>
					<!-- left_conts01 끝 -->
					<div id="right_conts01">
						<table cellspacing="0" class="tbl_type01">
							<colgroup>
								<col width="20%" />
								<col width="30%" />
								<col width="30%" />
								<col width="20%" />
							</colgroup>
							<tbody>
								<tr height="50px">
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr height="40px">
									<td>주문일</td>
									<td colspan="3" style="text-align: left"><input
										type="text" class="input01 usedatepicker"> - <input
										type="text" class="input01 usedatepicker"></td>
								</tr>
								<tr height="40px">
									<td>납기일</td>
									<td colspan="3" style="text-align: left"><input
										type="text" class="input01 usedatepicker"> - <input
										type="text" class="input01 usedatepicker"></td>
								</tr>
								<tr height="40px">
									<td>회사명</td>
									<td colspan="3" style="text-align: left"><input
										type="text" class="input02"></td>
								</tr>
								<tr height="40px">
									<td>품명</td>
									<td colspan="3" style="text-align: left"><input
										type="text" class="input02"></td>
								</tr>
								<tr height="25px">
									<td colspan="4"></td>
								</tr>
								<tr>
									<td colspan="4" style="text-align: center">
										<button>
											<img src="/resources/image/btn/btn_sch.gif">
										</button>
									</td>

								</tr>
							</tbody>
						</table>
					</div>
					<!-- right_conts01 끝 -->

				</div>
				<!-- conts01 끝 -->
				<div id="conts02">
					<div class="mpTitle02">
						<button type="button" id="btn_userReg">
							<img src="/resources/image/btn/btn_userReg.gif">
						</button>
						<button type="button" id="btn_orderReg">
							<img src="/resources/image/btn/btn_reg.gif">
						</button>
						<button type="button" id="btn_excel">
							<img src="/resources/image/btn/btn_excel.jpg">
						</button>

					</div>

					<div class="mpResult">
						<table cellspacing="0" class="tbl_type41">
							<colgroup>
								<col width="5%">
								<col width="50%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="5%">
								<col width="10%">
							</colgroup>
							<tbody>
								<tr>
									<th>번호</th>
									<th>기본정보</th>

									<th>주문일</th>
									<th>납기일</th>
									<th>완료</th>
									<th>파일</th>
									<th>인쇄</th>

								</tr>
								<tr>
									<td rowspan="2">1</td>
									<td style="text-align: left">
										<div>
											회사명: 개그콘서트 대박 완전 잼 있어요 <img src="/resources/image/btn/icon_new.gif" alt="새로운글" title="새로운글">
										</div>
										<div>품명:</div>
										<div>규격:</div>
										<div>용지:</div>

									</td>
									<td>
										<div>2012.02.02</div>
										<div>11:12:23</div>
									</td>
									<td>
										<div>2012.02.02</div>
									</td>
									<td>
										<div>
											<img src="/resources/image/btn/btn_finish.jpg">
										</div>
										<div>
											<img src="/resources/image/btn/icon_modify03.jpg">
										</div>
										<div>
											<img src="/resources/image/btn/btn_cancel.jpg">
										</div>
										<div>2012.02.02</div>
										<div>11:12:23</div>
									</td>
									<td style="text-align: center">
										<div>
											<img src="/resources/image/btn/box-closed-blue.png">
										</div>
										<div>
											<img src="/resources/image/btn/box-closed-blue.png">
										</div>
									</td>
									<td><img src="/resources/image/btn/btn_print.jpg"></td>
								</tr>
							</tbody>
						</table>
					</div>

                    <div class="paginate">
						<!-- paginate -->

						<a href="#none" class="none"><img src="/resources/image/btn/btn_front.gif" alt="처음"></a>
						<a href="#none" class="none"><img src="/resources/image/btn/btn_pre.gif" alt="이전"></a>
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
						<a href="#none" class="none"><img src="/resources/image/btn/btn_nxt.gif" alt="다음"></a> 
						<a href="#none" class="none"><img src="/resources/image/btn/btn_end.gif" alt="끝"></a>

					</div>

				</div>

			</div>

		</div>
	</div>
	
	<div id="orderForm" style="display: none">
		<div class="basicRegBox">
			<div class="regTopBar"></div>
			<!-- regTopBar 끝 -->
			<table cellspacing="0" class="tbl_type03">
				<colgroup>
					<col width="12%">
					<col width="28%">
					<col width="12%">
					<col width="18%">
					<col width="12%">
					<col width="18%">
				</colgroup>
				<tbody>
					<tr>
						<td colspan="6"></td>
					</tr>
					<tr>
						<th>구분</th>
						<td><select name="searchChk" class="select02"
							id="selectOrderCls">
								<option value="01" selected="">라벨</option>
								<option value="02">장비</option>
								<option value="03">리본</option>
								<option value="04">실사</option>
								<option value="05">기타</option>
						</select></td>
						<th>발주회사</th>
						<td colspan="3"><input type="text" class="input03"></td>
					</tr>
					<tr>
						<td colspan="6"></td>
					</tr>


					<!-- 라벨 -->
					<tr class="orderViewPart orderCls01" style="display: table-row;">
						<th>품명</th>
						<td><input type="text" class="input03"></td>
						<th>규격</th>
						<td><input type="text" class="input01"></td>
						<th>수량</th>
						<td><input type="text" class="input01"></td>
					</tr>
					<tr class="orderViewPart orderCls01" style="display: table-row;">
						<th>용지</th>
						<td><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">아트지</option>
								<option value="03">감열지</option>
								<option value="04">투명PET</option>
								<option value="05">백색PET</option>
								<option value="06">은무데도롱지</option>
								<option value="07">은광데도롱지</option>
								<option value="08">VOID</option>
								<option value="09">유포지(PPT)</option>
								<option value="10">PVC(캘지)</option>
								<option value="11">모조지</option>
								<option value="12">꼬리표</option>
						</select> <select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">그라</option>
								<option value="03">미색(황박)</option>
								<option value="04">무접</option>
						</select></td>
						<th>지관</th>
						<td><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">40지관</option>
								<option value="03">40지관(플라스틱)</option>
								<option value="04">75지관</option>
								<option value="05">75지관(플라스틱)</option>
						</select></td>
						<th>1롤 수량</th>
						<td><input type="text" class="input01"></td>
					</tr>
					<tr class="orderViewPart orderCls01" style="display: table-row;">
						<th>납기일</th>
						<td><input type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td colspan="3"><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">직납</option>
								<option value="03">방문</option>
								<option value="04">택배</option>
						</select></td>
					</tr>


					<!-- 장비 -->
					<tr class="orderViewPart orderCls02" style="display: none;">
						<th>납기일</th>
						<td><input type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td colspan="3"><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">직납</option>
								<option value="03">방문</option>
								<option value="04">택배</option>
						</select></td>
					</tr>

					<!-- 리본 -->
					<tr class="orderViewPart orderCls03" style="display: none;">
						<th>품명</th>
						<td><input type="text" class="input03"></td>
						<th>규격</th>
						<td><input type="text" class="input01"></td>
						<th>수량</th>
						<td><input type="text" class="input01"></td>
					</tr>

					<tr class="orderViewPart orderCls03" style="display: none;">
						<th>지관</th>
						<td><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">40지관</option>
								<option value="03">40지관(플라스틱)</option>
								<option value="04">75지관</option>
								<option value="05">75지관(플라스틱)</option>
						</select></td>
						<th>납기일</th>
						<td><input type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">직납</option>
								<option value="03">방문</option>
								<option value="04">택배</option>
						</select></td>
					</tr>

					<!-- 실사 -->
					<tr class="orderViewPart orderCls04" style="display: none;">
						<th>품명</th>
						<td><input type="text" class="input03"></td>
						<th>규격</th>
						<td><input type="text" class="input01"></td>
						<th>수량</th>
						<td><input type="text" class="input01"></td>
					</tr>
					<tr class="orderViewPart orderCls04" style="display: none;">
						<th>실사용지</th>
						<td><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">유포지</option>
								<option value="03">캘지</option>
						</select> <select name="searchChk" class="select02">
								<option value="01" selected="">코팅선택</option>
								<option value="02">코팅없음</option>
								<option value="03">무광코팅</option>
								<option value="04">유광코팅</option>
						</select></td>
						<th>납기일</th>
						<td><input type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">직납</option>
								<option value="03">방문</option>
								<option value="04">택배</option>
						</select></td>
					</tr>


					<!-- 기타 -->
					<tr class="orderViewPart orderCls05" style="display: none;">
						<th>납기일</th>
						<td><input type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td colspan="3"><select name="searchChk" class="select02">
								<option value="01" selected="">선택</option>
								<option value="02">직납</option>
								<option value="03">방문</option>
								<option value="04">택배</option>
						</select></td>
					</tr>


					<tr>
						<th>기타설명</th>
						<td colspan="5"><textarea class="textarea02" title="레이블 텍스트"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="6"></td>
					</tr>
					<tr>
						<th>첨부파일1</th>
						<td colspan="5"><input type="text" class="input05"> <img
							src="/resources/image/btn/btn_find.gif" alt="파일찾기" title="파일찾기"></td>
					</tr>
					<tr>
						<th>첨부파일2</th>
						<td colspan="5"><input type="text" class="input05"> <img
							src="/resources/image/btn/btn_find.gif" alt="파일찾기" title="파일찾기"></td>
					</tr>
				</tbody>
			</table>

		</div>
		<!-- basicRegBox 끝 -->


		<div class="contBtnSave" style="margin: 10px auto;">
			<button id="btn_cancelOrder" type="button">
				<img src="/resources/image/btn/btn_c_cancel.gif" alt="취소" title="취소">
			</button>
			<button id="btn_submitOrder" type="button">
				<img src="/resources/image/btn/btn_reg.gif" alt="등록하기" title="등록하기">
			</button>
		</div>

	</div>

</body>
<script>
	'use strict';
	console.log("in orders list pages");
	var _loginUser = "${userId}";
	var _loginCls = "${userCls}";
	var orderApp = new OrderApp();
	orderApp.initApp();
</script>

</html>