<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>휴나닉 주문관리 서비스입니다</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="../css/common.css" type="text/css">
	<STYLE type="text/css">
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
	</STYLE>
	<SCRIPT language="JavaScript">
		//-----------------------------------------------CSS 적용을 위한 함수  
		function onMouse(td) {
			td.style.backgroundColor = "#dfdfdf";
			td.style.color = "#000099"
			td.style.fontWeight = "bold";
			td.style.cursor = "hand";

		}
		function outMouse(td, today) {
			if (today == "today") {
				td.style.backgroundColor = "#f4a2a3";
				td.style.color = "#ffffff"
				td.style.fontWeight = "bold";

			} else {
				td.style.backgroundColor = "#ffffff";
				td.style.fontWeight = "normal";
			}
		}
		//-----------------------------------------------CSS 적용을 위한 함수  

		function datePicker(tYear, tMonth, tDay, tYoil) { // 텍스트박스에 날짜 넣기 위해 만든 함수  
			picDate = new Date(tYear, tMonth, tDay);       // 변경된 날짜 객체 선언후 날짜셋팅  
			selDate.value = picDate.getFullYear() + "년 " + (picDate.getMonth() + 1) + "월 " + picDate.getDate() + "일" + "(" + tYoil + ")"
		}


		function calendar(tYear, tMonth) { //달력 함수  

			var nowDate = new Date();               //오늘 날짜 객체 선언  
			var nYear = nowDate.getFullYear();      //오늘의 년도  
			var nMonth = nowDate.getMonth();       //오늘의 월 ※ 0월부터 시작  
			var nDate = nowDate.getDate();           //오늘의 날  
			var nNumday = nowDate.getDay();         //오늘의 요일 0=일요일...6=토요일  
			var endDay = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);      //각달의 마지막 날짜  
			var dayName = new Array("일", "월", "화", "수", "목", "금", "토"); // 숫자 요일을 문자 요일 바꿀 함수  
			var col = 0;  //나중에 앞뒤 빈 날짜칸 계산   

			if (tYear == null)   //null 일경우, 처음 페이지가 로드 될때의 년도는   
			{ tYear = nYear; } // 현재 년도를 가져오고  

			if (tMonth == null)   //null 일경우, 처음 페이지가 로드 될때의 월은  
			{ tMonth = nMonth; }//현재 월을 가져오고  

			eDate = new Date();       // 변경된 날짜 객체 선언  
			eDate.setFullYear(tYear);// 변경된 년도 세팅  
			eDate.setMonth(tMonth);  // 변경된 월 세팅  
			eDate.setDate(1);        // 날짜는 1일로 설정해서  
			var fNumday = eDate.getDay();    // 첫번째 날짜 1일의 숫자 요일  
			var lastDay = endDay[eDate.getMonth()]; //변경된 월의 마지막 날짜  

			if ((eDate.getMonth() == 1) && (((eDate.getYear() % 4 == 0) && (eDate.getYear() % 100 != 0)) || eDate.getYear() % 400 == 0)) { lastDay = 29; } // 0월 부터 시작하므로 1는 2월임. 윤달 계산 4년마다 29일 , 100년는 28일, 400년 째는 29일  

			calendarStr = "<TABLE width=544px height=300px cellspacing=8>"
			calendarStr += "<TR align=center height=30px><TD valign=middle>"
			calendarStr += "<font size=5color=black><a href=javascript:calendar(" + tYear + "," + (tMonth - 1) + ") class=preNext>◀</a></font>" //월을 넘길때 빼기 -1을 해서 넘긴다(년도는 자동 계산됨)  
			calendarStr += "</TD><TD colspan=5 >"
			calendarStr += "<font size=5 color=black>  <b>" + eDate.getFullYear() + "년 " + (eDate.getMonth() + 1) + "월</b></font> "// 해당하는 년도와 월 표시  
			calendarStr += "</TD><TD valign=middle>"
			calendarStr += "<font size=5 color=black><a href=javascript:calendar(" + tYear + "," + (tMonth + 1) + ") class=preNext>▶</a></font>" //월을 넘길때 더하기 +1을 해서 넘긴다(년도는 자동 계산됨)  
			calendarStr += "</TD></TR><TR>"
			for (i = 0; i < dayName.length; i++) {
				calendarStr += "<TD class=week><font size=5 color=black>" + dayName[i] + "</font></TD>" // 숫자 요일을 날짜 요일로 입력  
			}

			calendarStr += "</TR><TR align=center>"

			for (i = 0; i < fNumday; i++) {          // 첫번째 날짜의 숫자 요일을 구해서 그전까지는 빈칸 처리  
				calendarStr += "<TD>&nbsp;</TD>"
				col++;
			}

			for (i = 1; i <= lastDay; i++) {       // 해당 월의 달력   
				if (eDate.getFullYear() == nYear && eDate.getMonth() == nMonth && i == nDate) {//오늘이면 today 스타일로 표시  
					calendarStr += "<TD class=today onmouseover=onMouse(this) onmouseout=outMouse(this,'today') onClick=datePicker(" + tYear + "," + tMonth + "," + i + ",'" + dayName[col] + "')><font size=5 color=black>" + i + "</font></TD>"
				} else {

					if (col == 0) {              //일요일이면  
						calendarStr += "<TD class=sunday onmouseover=onMouse(this) onmouseout=outMouse(this,'notToday') onClick=datePicker(" + tYear + "," + tMonth + "," + i + ",'" + dayName[col] + "')><font size=5 color=black>" + i + "</font></TD>"
					} else if (1 <= col && col <= 5) {//그외 평범한 날이면  
						calendarStr += "<TD class=workday onmouseover=onMouse(this) onmouseout=outMouse(this,'notToday') onClick=datePicker(" + tYear + "," + tMonth + "," + i + ",'" + dayName[col] + "')><font size=5 color=black>" + i + "</font></TD>"
					} else if (col == 6) {        //토요일이면  
						calendarStr += "<TD class=satday onmouseover=onMouse(this) onmouseout=outMouse(this,'notToday') onClick=datePicker(" + tYear + "," + tMonth + "," + i + ",'" + dayName[col] + "')><font size=5 color=black>" + i + "</font></TD>"
					}

				}
				col++;

				if (col == 7) {     //7칸을 만들면 줄 바꾸어 새 줄을 만들고 다시 첫 칸부터 시작  
					calendarStr += "</TR><TR align=center>"
					col = 0;
				}
			}

			for (i = col; i < dayName.length; i++) {        //마지막 날에서 남은 요일의 빈 칸 만들기  
				calendarStr += "<TD>&nbsp;</TD>"
			}


			//calendarStr +="</TR><TR align=center><TD colspan=7 ><input name=selDate class=selDate type=text readonly></TD></TR></TABLE>"  
			document.getElementById('calendarView').innerHTML = calendarStr
		}
	</SCRIPT>

</head>

<body onLoad="calendar()">

	<div id="wrap">

		<div id="container">
			<div id="header">
				<div id="hdconts01">

				</div><!-- hdconts01 끝 -->
			</div><!-- header 끝 -->

			<div id="contents">

				<div id="conts01">
					<div id="left_conts01">
						<div id="calendarView"></div>
					</div><!-- left_conts01 끝 -->
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
									<td colspan="4">&nbsp;

									</td>
								</tr>
								<tr height="40px">
									<td>
										주문일
									</td>
									<td colspan="3" style=" text-align:left">
										<input type="text" class="input01"> <img src="../image/layout/icon_cal.gif"
											alt="달력" title="납기일" /> - <input type="text" class="input01"> <img
											src="../image/layout/icon_cal.gif" alt="달력" title="납기일" />
									</td>
								</tr>
								<tr height="40px">
									<td>
										납기일
									</td>
									<td colspan="3" style=" text-align:left">
										<input type="text" class="input01"> <img src="../image/layout/icon_cal.gif"
											alt="달력" title="납기일" /> - <input type="text" class="input01"> <img
											src="../image/layout/icon_cal.gif" alt="달력" title="납기일" />
									</td>
								</tr>
								<tr height="40px">
									<td>
										회사명
									</td>
									<td colspan="3" style=" text-align:left">
										<input type="text" class="input02">
									</td>
								</tr>
								<tr height="40px">
									<td>
										품명
									</td>
									<td colspan="3" style=" text-align:left">
										<input type="text" class="input02">
									</td>
								</tr>
								<tr>
									<td>

									</td>
									<td style=" text-align:left">
										<SELECT NAME="ySearch" class="select02">
											<OPTION value="01" selected>2019년</OPTION>
											<OPTION value="02">2020년</OPTION>
											<OPTION value="03">2021년</OPTION>
											<OPTION value="04">2022년</OPTION>
										</SELECT>
									</td>
									<td style=" text-align:left">
										<SELECT NAME="mSearch" class="select02">
											<OPTION value="01" selected>전체</OPTION>
											<OPTION value="02">1월</OPTION>
											<OPTION value="03">2월</OPTION>
											<OPTION value="04">3월</OPTION>
											<OPTION value="04">4월</OPTION>
											<OPTION value="04">5월</OPTION>
											<OPTION value="04">6월</OPTION>
											<OPTION value="04">7월</OPTION>
											<OPTION value="04">8월</OPTION>
											<OPTION value="04">9월</OPTION>
											<OPTION value="04">10월</OPTION>
											<OPTION value="04">11월</OPTION>
											<OPTION value="04">12월</OPTION>
										</SELECT>
									</td>
									<td>
										<img src="../image/btn/btn_sch.gif">
									</td>

								</tr>
							</tbody>
						</table>
					</div><!-- right_conts01 끝 -->

				</div><!-- conts01 끝 -->
				<div id="conts02">
					<div class="mpTitle02">
						<a href="orderReg.html"><img src="../image/btn/btn_reg.gif"></a> <img
							src="../image/btn/btn_excel.jpg">

					</div>
					<div class="mpResult">
						<table cellspacing="0" class="tbl_type01">
							<tbody>
								<tr>
									<td>
										<table cellspacing="0" class="tbl_type41">
											<colgroup>
												<col width="5%" />
												<col width="30%" />
												<col width="25%" />
												<col width="10%" />
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
														완료
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
														회사명: 개그콘서트 대박 완전 잼 있어요 <img src="../image/btn/icon_new.gif"
															alt="새로운글" title="새로운글" />
														<br>
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
														2012.02.02 11:12:23
													</td>
													<td>
														<img src="../image/btn/btn_finish.jpg"><br><br><img
															src="../image/btn/btn_cancel.jpg">
													</td>
													<td>
														<img src="../image/btn/btn_print.jpg">
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