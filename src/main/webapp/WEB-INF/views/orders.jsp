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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery.fileupload.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/orders.js?ver=202007201029"></script>
</head>

<body>

	<div id="wrap">

		<div id="container">
			<div id="header">
				<div id="hdconts01" style="position: relative;">
					<button id="btn_logout" type="button" style="right: 0px; position: absolute;top: 45px;">
						<img src="${pageContext.request.contextPath}/resources/image/btn/btn_logout.gif">
					</button>
				</div>
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
									<td colspan="3" style="text-align: left"><input id="searchString1"
										type="text" class="input01 usedatepicker"> - <input  id="searchString2"
										type="text" class="input01 usedatepicker"></td>
								</tr>
								<tr height="40px">
									<td>납기일</td>
									<td colspan="3" style="text-align: left"><input id="searchString3"
										type="text" class="input01 usedatepicker"> - <input id="searchString4"
										type="text" class="input01 usedatepicker"></td>
								</tr>
								<tr height="40px">
									<td>회사명</td>
									<td colspan="3" style="text-align: left"><input id="searchString5"
										type="text" class="input02"></td>
								</tr>
								<tr height="40px">
									<td>품명</td>
									<td colspan="3" style="text-align: left"><input id="searchString6"
										type="text" class="input02"></td>
								</tr>
								<tr height="25px">
									<td colspan="4"></td>
								</tr>
								<tr>
									<td colspan="4" style="text-align: center">
										<button id="btn_searchOrderAll" type="button">
											<img src="${pageContext.request.contextPath}/resources/image/btn/btn_sch_all.gif">
										</button>
										<button id="btn_searchOrder" type="button">
											<img src="${pageContext.request.contextPath}/resources/image/btn/btn_sch.gif">
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
						<c:if test="${userCls eq 'admin'}">
							<button type="button" id="btn_userReg">
								<img src="${pageContext.request.contextPath}/resources/image/btn/btn_userReg.gif">
							</button>
						</c:if>
						<button type="button" id="btn_orderReg">
							<img src="${pageContext.request.contextPath}/resources/image/btn/btn_reg.gif">
						</button>
						<button type="button" id="btn_excel">
							<img src="${pageContext.request.contextPath}/resources/image/btn/btn_excel.jpg">
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
							<tbody id="orderlist">
								<tr>
									<td colspan="7">목록이 없습니다.</td>
								</tr>
							</tbody>
						</table>
					</div>

                    <div class="paginate" id="paginate">
						<!-- paginate -->
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
						<td colspan="6"><input id="orderId" type="hidden" readonly="readonly"></td>
					</tr>
					<tr>
						<th>구분</th>
						<td><select name="searchChk" class="select02"
							id="itemCls">
								<option value="01" selected="selected">라벨</option>
								<option value="02">장비</option>
								<option value="03">리본</option>
								<option value="04">실사</option>
								<option value="05">기타</option>
						</select></td>
						<th>품명</th>
						<td colspan="3"><input id="itemNm" type="text" class="input03" style="width : 300px;"></td>
					</tr>
					<tr>
						<td colspan="6"></td>
					</tr>


					<!-- 라벨 -->
					<tr class="orderViewPart orderCls01" style="display: table-row;">
						<th>발주회사</th>
						<td><input id="company01" type="text" class="input03"></td>
						<th>규격</th>
						<td><input id="itemSpecX01" type="text" class="input01" style="width: 40px" numberOnly> x <input id="itemSpecY01" type="text" class="input01" style="width: 40px" numberOnly></td>
						<th>수량</th>
						<td><input id="totalQty01" type="text" class="input01" numberOnly></td>
					</tr>
					<tr class="orderViewPart orderCls01" style="display: table-row;">
						<th>용지</th>
						<td><select id="paper101" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">아트지</option>
								<option value="02">감열지</option>
								<option value="03">투명PET</option>
								<option value="04">백색PET</option>
								<option value="05">은무데도롱지</option>
								<option value="06">은광데도롱지</option>
								<option value="07">VOID</option>
								<option value="08">유포지</option>
								<option value="09">PVC(캘지)</option>
								<option value="10">모조지</option>
								<option value="11">꼬리표</option>
								<option value="12">기타</option>
						</select> 
						<select id="paper201" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">그라</option>
								<option value="02">미색(황박)</option>
								<option value="03">무접</option>
						</select></td>
						<th>지관</th>
						<td><select id="parerRoll01" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">40지관</option>
								<option value="02">40지관(플라스틱)</option>
								<option value="03">75지관</option>
								<option value="04">75지관(플라스틱)</option>
								<option value="05">25지관</option>
								<option value="06">낱장</option>
						</select></td>
						<th>1롤 수량</th>
						<td><input id="rollQty01" type="text" class="input01" numberOnly></td>
					</tr>
					<tr class="orderViewPart orderCls01" style="display: table-row;">
						<th>납기일</th>
						<td><input id="dueDate01" type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td colspan="3"><select id="delivery01" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">직납</option>
								<option value="02">방문</option>
								<option value="03">택배</option>
						</select></td>
					</tr>


					<!-- 장비 -->
					<tr class="orderViewPart orderCls02" style="display: none;">
						<th>발주회사</th>
						<td><input id="company02" type="text" class="input03"></td>
						<th>납기일</th>
						<td><input id="dueDate02" type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td colspan="3"><select id="delivery02" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">직납</option>
								<option value="02">방문</option>
								<option value="03">택배</option>
						</select></td>
					</tr>

					<!-- 리본 -->
					<tr class="orderViewPart orderCls03" style="display: none;">
						<th>발주회사</th>
						<td><input id="company03" type="text" class="input03"></td>
						<th>규격</th>
						<td><input id="itemSpecX03" type="text" class="input01" style="width: 40px" numberOnly> x <input id="itemSpecY03" type="text" class="input01" style="width: 40px" numberOnly></td>
						<th>수량</th>
						<td><input id="totalQty03" type="text" class="input01" numberOnly></td>
					</tr>

					<tr class="orderViewPart orderCls03" style="display: none;">
						<th>재질</th>
						<td><select id="material03" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">WAX</option>
								<option value="02">WAX-REXIN</option>
								<option value="03">REXIN</option>
								<option value="04">특수리본</option>
								<option value="05">기타</option>
						</select></td>
						<th>납기일</th>
						<td><input id="dueDate03" type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td><select id="delivery03" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">직납</option>
								<option value="02">방문</option>
								<option value="03">택배</option>
						</select></td>
					</tr>

					<!-- 실사 -->
					<tr class="orderViewPart orderCls04" style="display: none;">
						<th>발주회사</th>
						<td><input id="company04" type="text" class="input03"></td>
						<th>규격</th>
						<td><input id="itemSpecX04" type="text" class="input01" style="width: 40px" numberOnly> x <input id="itemSpecY04" type="text" class="input01" style="width: 40px" numberOnly></td>
						<th>수량</th>
						<td><input id="totalQty04" type="text" class="input01" numberOnly></td>
					</tr>
					<tr class="orderViewPart orderCls04" style="display: none;">
						<th>실사용지</th>
						<td>
							<select id="paper304" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">유포지</option>
								<option value="02">캘지</option>
							</select>
							<select id="paper404"name="searchChk" class="select02">
								<option value="" selected="">코팅선택</option>
								<option value="01">코팅없음</option>
								<option value="02">무광코팅</option>
								<option value="03">유광코팅</option>
							</select></td>
						<th>납기일</th>
						<td><input id="dueDate04" type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td><select id="delivery04" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">직납</option>
								<option value="02">방문</option>
								<option value="03">택배</option>
						</select></td>
					</tr>


					<!-- 기타 -->
					<tr class="orderViewPart orderCls05" style="display: none;">
						<th>발주회사</th>
						<td><input id="company05" type="text" class="input03"></td>
						<th>납기일</th>
						<td><input id="dueDate05" type="text" class="input01 usedatepicker"></td>
						<th>납품방법</th>
						<td colspan="3"><select id="delivery05" name="searchChk" class="select02">
								<option value="" selected="">선택</option>
								<option value="01">직납</option>
								<option value="02">방문</option>
								<option value="03">택배</option>
						</select></td>
					</tr>


					<tr>
						<th>기타설명</th>
						<td colspan="5"><textarea id="description" class="textarea02" title="레이블 텍스트"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="6"></td>
					</tr>
					<tr>
						<th>첨부파일1</th>
						<td colspan="5" style="position: relative; height: 30px; overflow: hidden;">
							<!-- 파일 업로드 세팅  -->
							<div id="file1_progress">
								<div class="bar" style="width: 0%; height: inherit;"></div>
							</div>
							<div id="fileName1">&nbsp;</div>
							<button id="btn_cancelUpload" class="btn_cancelUpload">취소</button>
							<label for="fileupload1" class="btn_uploadfile">파일 업로드</label>
							<input id="fileupload1" type="file" name="files1" data-url="${pageContext.request.contextPath}/fileUpload">
							
							<input type="hidden" id="file1">          
						</td>
					</tr>
					<tr>
						<th>첨부파일2</th>
						<td colspan="5" style="position: relative; height: 30px; overflow: hidden;">
							<!-- 파일 업로드 세팅  -->
							<div id="file2_progress">
								<div class="bar" style="width: 0%; height: inherit;"></div>
							</div>
							<div id="fileName2">&nbsp;</div>
							<button id="btn_cancelUpload" class="btn_cancelUpload">취소</button>
							<label for="fileupload2" class="btn_uploadfile">파일 업로드</label>
							<input id="fileupload2" type="file" name="files2" data-url="${pageContext.request.contextPath}/fileUpload">
							
							<input type="hidden" id="file2">          
						</td>
					</tr>
				</tbody>
			</table>

		</div>
		<!-- basicRegBox 끝 -->


		<div class="contBtnSave" style="margin: 10px auto;">
			<button id="btn_cancelOrder" type="button">
				<img src="${pageContext.request.contextPath}/resources/image/btn/btn_c_cancel.gif" alt="취소" title="취소">
			</button>
			<button id="btn_submitOrder" type="button">
				<img src="${pageContext.request.contextPath}/resources/image/btn/btn_reg.gif" alt="등록하기" title="등록하기">
			</button>
		</div>

	</div>

	<div id="confirmExcel" style="display: none">
		<div>현재 목록을 엑셀로 저장하시겠습니까?</div>
		<div>
			<Button id="btn_confirmExcel_ok">엑셀다운</Button>
			<Button id="btn_confirmExcel_no">취소</Button>
		</div>
	</div>
	
	<div id="confirmDelete" style="display: none">
		<input id="delete_id" type="hidden">
		<div>선택한 주문을 삭제 처리 하시겠습니까?</div>
		<div>
			<Button id="btn_confirmDelete_ok">주문삭제</Button>
			<Button id="btn_confirmDelete_no">취소</Button>
		</div>
	</div>
	
	<div id="confirmComplete" style="display: none">
		<input id="complete_id" type="hidden">
		<div>선택한 주문을 완료 처리 하시겠습니까? <br>완료처리된 주문은 수정 및 삭제가 불가능합니다.</div>
		<div>
			<Button id="btn_confirmComplete_ok">주문 완료</Button>
			<Button id="btn_confirmComplete_no">취소</Button>
		</div>
	</div>
	
	<div id="confirmFileDown" style="display: none">
		<input id="filedown_id" type="hidden">
		<div>파일을 다운로드 하시겠습니까?</div>
		<div>
			<Button id="btn_confirmFileDown_ok">파일 다운로드</Button>
			<Button id="btn_confirmFileDown_no">취소</Button>
		</div>
	</div>
	
	<div id="confirmLogout" style="display: none">
		<div>로그아웃 하시겠습니까?</div>
		<div>
			<Button id="btn_confirmLogout_ok">로그아웃</Button>
			<Button id="btn_confirmLogout_no">취소</Button>
		</div>
	</div>
	
	
</body>
<script>
	'use strict';
	console.log("in orders list pages");
	var __contextPath__ = "${pageContext.request.contextPath}"; 
	var _loginUser = "${userId}";
	var _loginCls = "${userCls}";
	var orderApp = new OrderApp();
	orderApp.initApp();
</script>

</html>