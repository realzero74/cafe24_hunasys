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
				<div id="hdconts02">

				</div><!-- hdconts01 끝 -->
			</div><!-- header 끝 -->

			<div id="contents">

				<div id="regConts01">
					<!-- 라벨-->
					<div class="basicRegBox">
						<div class="regTopBar">

						</div><!-- regTopBar 끝 -->
						<table cellspacing="0" class="tbl_type03">
							<colgroup>
								<col width="12%" />
								<col width="28%" />
								<col width="12%" />
								<col width="18%" />
								<col width="12%" />
								<col width="18%" />
							</colgroup>
							<tbody>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>구분</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01">선택</OPTION>
											<OPTION value="02" selected>라벨</OPTION>
											<OPTION value="03">장비</OPTION>
											<OPTION value="04">리본</OPTION>
											<OPTION value="05">실사</OPTION>
											<OPTION value="06">기타</OPTION>
										</SELECT>
									</td>
									<th>발주회사</th>
									<td colspan="3">
										<input type="text" class="input03">
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>

								<tr>
									<th>품명</th>
									<td>
										<input type="text" class="input03">
									</td>
									<th>규격</th>
									<td>
										<input type="text" class="input01">
									</td>
									<th>수량</th>
									<td>
										<input type="text" class="input01">
									</td>
								</tr>
								<tr>
									<th>용지</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">아트지</OPTION>
											<OPTION value="03">감열지</OPTION>
											<OPTION value="04">투명PET</OPTION>
											<OPTION value="05">백색PET</OPTION>
											<OPTION value="06">은무데도롱지</OPTION>
											<OPTION value="07">은광데도롱지</OPTION>
											<OPTION value="08">VOID</OPTION>
											<OPTION value="09">유포지(PPT)</OPTION>
											<OPTION value="10">PVC(캘지)</OPTION>
											<OPTION value="11">모조지</OPTION>
											<OPTION value="12">꼬리표</OPTION>
										</SELECT>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">그라</OPTION>
											<OPTION value="03">미색(황박)</OPTION>
											<OPTION value="04">무접</OPTION>
										</SELECT>
									</td>
									<th>지관</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">40지관</OPTION>
											<OPTION value="03">40지관(플라스틱)</OPTION>
											<OPTION value="04">75지관</OPTION>
											<OPTION value="05">75지관(플라스틱)</OPTION>
										</SELECT>
									</td>
									<th>1롤 수량</th>
									<td>
										<input type="text" class="input01">
									</td>
								</tr>
								<tr>
									<th>납기일</th>
									<td>
										<input type="text" class="input01"> <img src="../image/layout/icon_cal.gif"
											alt="달력" title="납기일" />
									</td>
									<th>납품방법</th>
									<td colspan="3">
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">직납</OPTION>
											<OPTION value="03">방문</OPTION>
											<OPTION value="04">택배</OPTION>
										</SELECT>
									</td>
								</tr>
								<tr>
									<th>기타설명</th>
									<td colspan="5">
										<textarea class="textarea02" title="레이블 텍스트"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>첨부파일1</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
								<tr>
									<th>첨부파일2</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
							</tbody>
						</table>

					</div><!-- basicRegBox 끝 -->

					<!-- 장비-->
					<div class="basicRegBox">
						<div class="regTopBar">

						</div><!-- regTopBar 끝 -->
						<table cellspacing="0" class="tbl_type03">
							<colgroup>
								<col width="12%" />
								<col width="28%" />
								<col width="12%" />
								<col width="18%" />
								<col width="12%" />
								<col width="18%" />
							</colgroup>
							<tbody>
								<tr>
									<th>구분</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01">선택</OPTION>
											<OPTION value="02">라벨</OPTION>
											<OPTION value="03" selected>장비</OPTION>
											<OPTION value="04">리본</OPTION>
											<OPTION value="05">실사</OPTION>
											<OPTION value="06">기타</OPTION>
										</SELECT>
									</td>
									<th>발주회사</th>
									<td colspan="3">
										<input type="text" class="input03">
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>

								<tr>
									<th>납기일</th>
									<td>
										<input type="text" class="input01"> <img src="../image/layout/icon_cal.gif"
											alt="달력" title="납기일" />
									</td>
									<th>납품방법</th>
									<td colspan="3">
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">직납</OPTION>
											<OPTION value="03">방문</OPTION>
											<OPTION value="04">택배</OPTION>
										</SELECT>
									</td>
								</tr>

								<tr>
									<th>기타설명</th>
									<td colspan="5">
										<textarea class="textarea02" title="레이블 텍스트"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>첨부파일1</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
								<tr>
									<th>첨부파일2</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
							</tbody>
						</table>

					</div><!-- basicRegBox 끝 -->
					<!-- 리본-->
					<div class="basicRegBox">
						<div class="regTopBar">

						</div><!-- regTopBar 끝 -->
						<table cellspacing="0" class="tbl_type03">
							<colgroup>
								<col width="12%" />
								<col width="28%" />
								<col width="12%" />
								<col width="18%" />
								<col width="12%" />
								<col width="18%" />
							</colgroup>
							<tbody>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>구분</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01">선택</OPTION>
											<OPTION value="02">라벨</OPTION>
											<OPTION value="03">장비</OPTION>
											<OPTION value="04" selected>리본</OPTION>
											<OPTION value="05">실사</OPTION>
											<OPTION value="06">기타</OPTION>
										</SELECT>

									</td>
									<th>발주회사</th>
									<td colspan="3">
										<input type="text" class="input03">
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>

								<tr>
									<th>품명</th>
									<td>
										<input type="text" class="input03">
									</td>
									<th>규격</th>
									<td>
										<input type="text" class="input01">
									</td>
									<th>수량</th>
									<td>
										<input type="text" class="input01">
									</td>
								</tr>

								<tr>
									<th>지관</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">40지관</OPTION>
											<OPTION value="03">40지관(플라스틱)</OPTION>
											<OPTION value="04">75지관</OPTION>
											<OPTION value="05">75지관(플라스틱)</OPTION>
										</SELECT>
									</td>
									<th>납기일</th>
									<td>
										<input type="text" class="input01"> <img src="../image/layout/icon_cal.gif"
											alt="달력" title="납기일" />
									</td>
									<th>납품방법</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">직납</OPTION>
											<OPTION value="03">방문</OPTION>
											<OPTION value="04">택배</OPTION>
										</SELECT>
									</td>
								</tr>
								<tr>
									<th>기타설명</th>
									<td colspan="5">
										<textarea class="textarea02" title="레이블 텍스트"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>첨부파일1</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
								<tr>
									<th>첨부파일2</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
							</tbody>
						</table>

					</div><!-- basicRegBox 끝 -->
					<!-- 실사-->
					<div class="basicRegBox">
						<div class="regTopBar">

						</div><!-- regTopBar 끝 -->
						<table cellspacing="0" class="tbl_type03">
							<colgroup>
								<col width="12%" />
								<col width="28%" />
								<col width="12%" />
								<col width="18%" />
								<col width="12%" />
								<col width="18%" />
							</colgroup>
							<tbody>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>구분</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01">선택</OPTION>
											<OPTION value="02">라벨</OPTION>
											<OPTION value="03">장비</OPTION>
											<OPTION value="04">리본</OPTION>
											<OPTION value="05" selected>실사</OPTION>
											<OPTION value="06">기타</OPTION>
										</SELECT>
									</td>
									<th>발주회사</th>
									<td colspan="3">
										<input type="text" class="input03">
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>

								<tr>
									<th>품명</th>
									<td>
										<input type="text" class="input03">
									</td>
									<th>규격</th>
									<td>
										<input type="text" class="input01">
									</td>
									<th>수량</th>
									<td>
										<input type="text" class="input01">
									</td>
								</tr>
								<tr>
									<th>실사용지</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">유포지</OPTION>
											<OPTION value="03">캘지</OPTION>
										</SELECT>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>코팅선택</OPTION>
											<OPTION value="02">코팅없음</OPTION>
											<OPTION value="03">무광코팅</OPTION>
											<OPTION value="04">유광코팅</OPTION>
									</td>
									<th>납기일</th>
									<td>
										<input type="text" class="input01"> <img src="../image/layout/icon_cal.gif"
											alt="달력" title="납기일" />
									</td>
									<th>납품방법</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">직납</OPTION>
											<OPTION value="03">방문</OPTION>
											<OPTION value="04">택배</OPTION>
										</SELECT>
									</td>
								</tr>
								<tr>
									<th>기타설명</th>
									<td colspan="5">
										<textarea class="textarea02" title="레이블 텍스트"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>첨부파일1</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
								<tr>
									<th>첨부파일2</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
							</tbody>
						</table>

					</div><!-- basicRegBox 끝 -->
					<!-- 기타-->
					<div class="basicRegBox">
						<div class="regTopBar">

						</div><!-- regTopBar 끝 -->
						<table cellspacing="0" class="tbl_type03">
							<colgroup>
								<col width="12%" />
								<col width="28%" />
								<col width="12%" />
								<col width="18%" />
								<col width="12%" />
								<col width="18%" />
							</colgroup>
							<tbody>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>구분</th>
									<td>
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01">선택</OPTION>
											<OPTION value="02">라벨</OPTION>
											<OPTION value="03">장비</OPTION>
											<OPTION value="04">리본</OPTION>
											<OPTION value="05">실사</OPTION>
											<OPTION value="06" selected>기타</OPTION>
										</SELECT>
									</td>
									<th>발주회사</th>
									<td colspan="3">
										<input type="text" class="input03">
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>납기일</th>
									<td>
										<input type="text" class="input01"> <img src="../image/layout/icon_cal.gif"
											alt="달력" title="납기일" />
									</td>
									<th>납품방법</th>
									<td colspan="3">
										<SELECT NAME="searchChk" class="select02">
											<OPTION value="01" selected>선택</OPTION>
											<OPTION value="02">직납</OPTION>
											<OPTION value="03">방문</OPTION>
											<OPTION value="04">택배</OPTION>
										</SELECT>
									</td>
								</tr>
								<tr>
									<th>기타설명</th>
									<td colspan="5">
										<textarea class="textarea02" title="레이블 텍스트"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="6">
									</td>
								</tr>
								<tr>
									<th>첨부파일1</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
								<tr>
									<th>첨부파일2</th>
									<td colspan="5">
										<input type="text" class="input05"> <img src="../image/btn/btn_find.gif"
											alt="파일찾기" title="파일찾기" />
									</td>
								</tr>
							</tbody>
						</table>

					</div><!-- basicRegBox 끝 -->



				</div><!-- regConts01 끝 -->
				<div id="regConts02">


				</div><!-- conts02 끝 -->

				<div class="contBtnSave">
					<a href="#"><img src="../image/btn/btn_c_cancel.gif" alt="취소" title="취소" /></a> <a
						href="main.html"><img src="../image/btn/btn_reg.gif" alt="등록하기" title="등록하기" /></a>
				</div>
			</div><!-- contents 끝 -->

		</div><!-- container 끝 -->

	</div>

</body>

</html>