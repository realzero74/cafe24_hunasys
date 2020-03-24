/*******************************************************************************
 * controller
 ******************************************************************************/

//3자리 단위마다 콤마 생성
function addCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
 
//모든 콤마 제거
function removeCommas(x) {
    if(!x || x.length == 0) return "";
    else return x.split(",").join("");
}


var OrderApp = function() {
	var transaction = new OrderTransaction();
	var view = new OrderViewHandler(transaction);
	var model = new OrderModel();

	var initApp = function() {
		regEventHandler();
		view.initDatepicker();
		view.initCalendar();
		view.initFile();

		var param = {
			"searchString1" : "",
			"searchString2" : "",
			"searchString3" : "",
			"searchString4" : "",
			"searchString5" : "",
			"searchString6" : "",
			"curentPage" : "1",
		}
		transaction.getList(param).done(function(resultdata) {
			view.tableHandler(resultdata);
			view.pagingHandler(resultdata.totalCnt, resultdata.currentPage);
		});
	};

	var regEventHandler = function() {
		
		// 로그아웃
		$('#btn_logout').on('click',	function() {
			$.blockUI({ message: $('#confirmLogout'), css: { width: '500px' } }); 
		});
		$('#btn_confirmLogout_ok').on('click', function() {
			location.href = __contextPath__	+ "/logout"
			$.unblockUI();			
		});
        $('#btn_confirmLogout_no').on('click', function() { 
            $.unblockUI(); 
            return false; 
        });
		
		$("input:text[numberOnly]").on("focus", function() {
		    var x = $(this).val();
		    x = removeCommas(x);
		    $(this).val(x);
		}).on("focusout", function() {
		    var x = $(this).val();
		    if(x && x.length > 0) {
		        if(!$.isNumeric(x)) {
		            x = x.replace(/[^0-9]/g,"");
		        }
		        x = addCommas(x);
		        $(this).val(x);
		    }
		}).on("keyup", function() {
		    $(this).val($(this).val().replace(/[^0-9]/g,""));
		});
		
		// 검색
		$('#btn_searchOrder').click( function() {
			var param = {
				"searchString1" : $("#searchString1").val(),
				"searchString2" : $("#searchString2").val(),
				"searchString3" : $("#searchString3").val(),
				"searchString4" : $("#searchString4").val(),
				"searchString5" : $("#searchString5").val(),
				"searchString6" : $("#searchString6").val(),
			};
			$("#calendarView > div > table > tbody > tr > td > a").removeClass('ui-state-active');
			transaction.getList(param).done(function(resultdata) {
				view.tableHandler(resultdata);
				view.pagingHandler(resultdata.totalCnt, resultdata.currentPage);
			});
		});

		$(document).on(
				"click",
				".paginate>ul>li>a",
				function() {
					if ($(this).hasClass("curpage") !== true) {
						var currentPage = $(this).attr("data-page");
						// alert(currentPage + "페이지로 이동");

						var param = {
							"searchString1" : $("#searchString1").val(),
							"searchString2" : $("#searchString2").val(),
							"searchString3" : $("#searchString3").val(),
							"searchString4" : $("#searchString4").val(),
							"searchString5" : $("#searchString5").val(),
							"searchString6" : $("#searchString6").val(),
							"currentPage" : currentPage,
						};
						$("#calendarView > div > table > tbody > tr > td > a")
								.removeClass('ui-state-active');
						transaction.getList(param).done(
								function(resultdata) {
									view.tableHandler(resultdata);
									view.pagingHandler(resultdata.totalCnt,
											resultdata.currentPage);
								});
					}
				});

		// 사용자 등록 페이지로 이동
		$('#btn_userReg').click(function() {
			location.href = __contextPath__ + "/users"
		});

		// 등록 폼 오픈
		$('#btn_orderReg').click(function() {
			model.setOrderInit();
			view.orderFormPopup();
		});

		// 수정
		$(document).on("click", ".modbutton", function() {
			console.log(this);
			console.log($(this).attr("data-orderid"));
			var orderid = $(this).attr("data-orderid");

			transaction.getItem(orderid).done(function(resultdata) {
				console.log(resultdata);
				if (resultdata.itemCls == "01") {
					model.setOrderType01(resultdata);
					view.orderFormPopup("01");
				} else if (resultdata.itemCls == "02") {
					model.setOrderType02(resultdata);
					view.orderFormPopup("02");
				} else if (resultdata.itemCls == "03") {
					model.setOrderType03(resultdata);
					view.orderFormPopup("03");
				} else if (resultdata.itemCls == "04") {
					model.setOrderType04(resultdata);
					view.orderFormPopup("04");
				} else if (resultdata.itemCls == "05") {
					model.setOrderType05(resultdata);
					view.orderFormPopup("05");
				}
			});
		});

		// 취소 처리 - 삭제
		$(document).on("click",".delbutton", function() {
			$("#delete_id").val($(this).attr("data-orderid"));
			$.blockUI({ message: $('#confirmDelete'), css: { width: '500px' } }); 
		});
		
		$('#btn_confirmDelete_ok').on('click', function() {
			var param = {
				"orderId" : $("#delete_id").val()
			};
			transaction.delOrder(param).done(function(resultdata) {		
				$.unblockUI();
				var param = {
						"searchString1" : $("#searchString1").val(),
						"searchString2" : $("#searchString2").val(),
						"searchString3" : $("#searchString3").val(),
						"searchString4" : $("#searchString4").val(),
						"searchString5" : $("#searchString5").val(),
						"searchString6" : $("#searchString6").val(), 
				} 
				transaction.getList(param).done( function( resultdata) { 
					view.tableHandler(resultdata); 
					view.pagingHandler( resultdata.totalCnt, resultdata.currentPage); 
				}); 
			});
			$.unblockUI();			
		});
        $('#btn_confirmDelete_no').on('click', function() { 
            $.unblockUI(); 
            return false; 
        });
				
		
		// 완료 처리
		$(document).on("click",".endbutton", function() {
			$("#complete_id").val($(this).attr("data-orderid"));
			$.blockUI({ message: $('#confirmComplete'), css: { width: '500px' } }); 
		});
		
		$('#btn_confirmComplete_ok').on('click', function() {
			var param = {
					"orderId" : $("#complete_id").val(),
					"setEnd" : "Y",
					"userId" : _loginUser,
			};
			transaction.modOrder(param).done(function(resultdata) {
				$.unblockUI();
				var param = {
					"searchString1" : $("#searchString1").val(),
					"searchString2" : $("#searchString2").val(),
					"searchString3" : $("#searchString3").val(),
					"searchString4" : $("#searchString4").val(),
					"searchString5" : $("#searchString5").val(),
					"searchString6" : $("#searchString6").val(),
				}
				transaction.getList(param).done(function(resultdata) {
					view.tableHandler(resultdata);
					view.pagingHandler(resultdata.totalCnt,	resultdata.currentPage);
				});
			});
			$.unblockUI();			
		});
        $('#btn_confirmComplete_no').on('click', function() { 
            $.unblockUI(); 
            return false; 
        });
		
		// 파일 다운로드
		$(document).on("click",".filedownbutton", function() {
			if($(this).attr("data-fileid") != '' && $(this).attr("data-fileid") != '0'){
				$("#filedown_id").val($(this).attr("data-fileid")); 
				$.blockUI({ message: $('#confirmFileDown'), css: { width: '500px' } }); 
			}
		});
		
		$('#btn_confirmFileDown_ok').on('click', function() {
			location.href = __contextPath__ + "/fileDownload/"+ $("#filedown_id").val();
			$.unblockUI();			
		});
        $('#btn_confirmFileDown_no').on('click', function() { 
            $.unblockUI(); 
            return false; 
        });
        
		// 인쇄 처리
		$(document).on("click",".printbutton", function() {
			console.log(this);
			console.log($(this).attr("data-orderid"));
			var href = __contextPath__ + "/order/print/"+ $(this).attr("data-orderid");
			window.open(href, 'print','top=50px, left=500px, width=826px, height=869px');
		});

		// 등록 폼 취소
		$('#btn_cancelOrder').click(function() {
			model.setOrderInit();
			$.unblockUI();
		});

		// 등록 폼 저장
		$('#btn_submitOrder').click(function() {
			console.log(model.getOrderType01());
			var param = {};
			var itemcls = $("#itemCls").val();
			if (itemcls == "01") {
				param = model.getOrderType01();
			} else if (itemcls == "02") {
				param = model.getOrderType02();
			} else if (itemcls == "03") {
				param = model.getOrderType03();
			} else if (itemcls == "04") {
				param = model.getOrderType04();
			} else if (itemcls == "05") {
				param = model.getOrderType05();
			}
			var orderId = $("#orderId").val();

			if (orderId) {
				console.log("수정");
				transaction.modOrder(param).done(function(resultdata) {
					$.unblockUI();
					var param = {
						"searchString1" : $("#searchString1").val(),
						"searchString2" : $("#searchString2").val(),
						"searchString3" : $("#searchString3").val(),
						"searchString4" : $("#searchString4").val(),
						"searchString5" : $("#searchString5").val(),
						"searchString6" : $("#searchString6").val(),
					}
					transaction.getList(param).done(function(resultdata) {
						view.tableHandler(resultdata);
						view.pagingHandler(resultdata.totalCnt,resultdata.currentPage);
					});
				});

			} else {
				console.log("신규등록");
				transaction.regOrder(param).done(function(resultdata) {
					$.unblockUI();
					var param = {
						"searchString1" : $("#searchString1").val(),
						"searchString2" : $("#searchString2").val(),
						"searchString3" : $("#searchString3").val(),
						"searchString4" : $("#searchString4").val(),
						"searchString5" : $("#searchString5").val(),
						"searchString6" : $("#searchString6").val(),
					}
					transaction.getList(param).done(function(resultdata) {
						view.tableHandler(resultdata);
						view.pagingHandler(resultdata.totalCnt,resultdata.currentPage);
					});
				});
			}
		});

		// excel 다운로드
		$('#btn_excel').on('click',	function() {
			$.blockUI({ message: $('#confirmExcel'), css: { width: '500px' } }); 
		});
		$('#btn_confirmExcel_ok').on('click', function() {
			location.href = __contextPath__
						+ "/orders/exportExcel"
						+ "?searchString1="
						+ $("#searchString1").val()
						+ "&searchString2="
						+ $("#searchString2").val()
						+ "&searchString3="
						+ $("#searchString3").val()
						+ "&searchString4="
						+ $("#searchString4").val()
						+ "&searchString5="
						+ $("#searchString5").val()
						+ "&searchString6="
						+ $("#searchString6").val();
			$.unblockUI();			
		});
        $('#btn_confirmExcel_no').on('click', function() { 
            $.unblockUI(); 
            return false; 
        });
		
        
        // 주문 구분 변경
        $('#itemCls').on('change', function() {
			console.log(this.value);
			var targetView = ".orderCls" + this.value;
			$(".orderViewPart").hide();
			$(targetView).show();
		});
	};

	return {
		initApp : initApp
	}
};
/*******************************************************************************
 * view handler
 ******************************************************************************/
var OrderViewHandler = function(transaction) {
	// datepicker 초기화
	// 모든 datepicker에 대한 공통 옵션 설정
	var initDatepicker = function() {

		$.datepicker.setDefaults({
			dateFormat : 'yy-mm-dd' // Input Display Format 변경
			,
			showOtherMonths : true // 빈 공간에 현재월의 앞뒤월의 날짜를 표시
			,
			showMonthAfterYear : true // 년도 먼저 나오고, 뒤에 월 표시
			,
			changeYear : true // 콤보박스에서 년 선택 가능
			,
			changeMonth : true // 콤보박스에서 월 선택 가능
			,
			showOn : "both" // button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을
			// 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
			,
			buttonImage : "/hunaorder/resources/image/layout/icon_cal.gif" // 버튼
			// 이미지
			// 경로
			,
			buttonImageOnly : true // 기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
			,
			buttonText : "선택" // 버튼에 마우스 갖다 댔을 때 표시되는 텍스트
			,
			yearSuffix : "년" // 달력의 년도 부분 뒤에 붙는 텍스트
			,
			monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'10', '11', '12' ] // 달력의 월 부분 텍스트
			,
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ] // 달력의 월 부분 Tooltip 텍스트
			,
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] // 달력의 요일 부분 텍스트
			,
			dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일' ]
		// 달력의 요일 부분 Tooltip 텍스트
		});

		$(".usedatepicker").datepicker();
		$(".ui-datepicker-trigger").css("height", "25px");
	};

	// 테이블 핸들러
	var tableHandler = function(data) {

		var datalist = data.datalist;

		var tr_tag = "";
		tr_tag = tr_tag + "<tr style='display:table-row'>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		번호";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		기본정보";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		주문일";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		납기일";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		완료";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		파일";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		인쇄";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "";
		tr_tag = tr_tag + "</tr>";

		if (datalist.length == 0) {
			tr_tag = tr_tag + "<tr style='display:table-row'>";
			tr_tag = tr_tag + "	<td colspan = '7'>";
			tr_tag = tr_tag + "		조회결과가 없습니다.	";
			tr_tag = tr_tag + "	</td>";
			tr_tag = tr_tag + "</tr>";
		} else {
			datalist
					.forEach(function(vo, idx, arr2) {
						// 첫번쨰 인수는 배열의 각각의 item
						// 두번쨰 인수는 배열의 index
						// 세번째 인수는 배열 그자체

						tr_tag = tr_tag + "<tr style='display:table-row'>";
						tr_tag = tr_tag + "	<td rowspan = '2'>";
						tr_tag = tr_tag + "" + ((data.currentPage - 1) * 10 + (idx + 1));
						tr_tag = tr_tag + "	</td>";
						
						if(vo.itemCls == "01"){
							tr_tag = tr_tag + "	<td style='text-align:left'>";
							tr_tag = tr_tag + "		<p>회사명: " + vo.company +"</p>";
							tr_tag = tr_tag + "		<p>품명: <b>" + vo.itemNm +"</b></p>";
							tr_tag = tr_tag + "		<p><span style='width: 50%; display: inline-block;'>";
							tr_tag = tr_tag + "		규격: " + vo.itemSpecX + " x " + vo.itemSpecY;
							tr_tag = tr_tag + "		</span><span style='width: 50%; display: inline-block;'>";;
							tr_tag = tr_tag + "		용지: " + vo.paper1Nm +"/" + vo.paper2Nm;
							tr_tag = tr_tag + "		</span></p>";
							tr_tag = tr_tag + "		<p><span style='width: 50%; display: inline-block;'>";
							tr_tag = tr_tag + "		수량: " + addCommas(vo.totalQty);
							tr_tag = tr_tag + "		</span><span style='width: 50%; display: inline-block;'>";;
							tr_tag = tr_tag + "		지관: " + vo.parerRollNm;
							tr_tag = tr_tag + "		</span></p>";	
							tr_tag = tr_tag + "		<p><span style='width: 50%; display: inline-block;'>";
							tr_tag = tr_tag + "		1롤 수량: " + addCommas(vo.rollQty);
							tr_tag = tr_tag + "		</span><span style='width: 50%; display: inline-block;'>";;
							tr_tag = tr_tag + "		납품방법: " + vo.deliveryNm;
							tr_tag = tr_tag + "		</span></p>";								
							tr_tag = tr_tag + "	</td>";
						}
						else if(vo.itemCls == "02"){
							tr_tag = tr_tag + "	<td style='text-align:left'>";
							tr_tag = tr_tag + "		회사명: " + vo.company;
							tr_tag = tr_tag + "		<br>";
							tr_tag = tr_tag + "		품명: " + vo.itemNm;
							tr_tag = tr_tag + "		<br>";
							tr_tag = tr_tag + "		납품방법: " + vo.deliveryNm;
							tr_tag = tr_tag + "	</td>";
						}
						else if(vo.itemCls == "03"){
							tr_tag = tr_tag + "	<td style='text-align:left'>";
							tr_tag = tr_tag + "		<p>회사명: " + vo.company +"</p>";
							tr_tag = tr_tag + "		<p>품명: <b>" + vo.itemNm +"</b></p>";
							tr_tag = tr_tag + "		<p><span style='width: 50%; display: inline-block;'>";
							tr_tag = tr_tag + "		규격: " + vo.itemSpecX + " x " + vo.itemSpecY;
							tr_tag = tr_tag + "		</span><span style='width: 50%; display: inline-block;'>";;
							tr_tag = tr_tag + "		수량: " + addCommas(vo.totalQty);
							tr_tag = tr_tag + "		</span></p>";
							tr_tag = tr_tag + "		<p><span style='width: 50%; display: inline-block;'>";
							tr_tag = tr_tag + "		지관: " + vo.parerRollNm;
							tr_tag = tr_tag + "		</span><span style='width: 50%; display: inline-block;'>";;
							tr_tag = tr_tag + "		납품방법: " + vo.deliveryNm;
							tr_tag = tr_tag + "		</span></p>";	
							tr_tag = tr_tag + "	</td>";
						}
						else if(vo.itemCls == "04"){
							tr_tag = tr_tag + "	<td style='text-align:left'>";
							tr_tag = tr_tag + "		<p>회사명: " + vo.company +"</p>";
							tr_tag = tr_tag + "		<p>품명: <b>" + vo.itemNm +"</b></p>";
							tr_tag = tr_tag + "		<p><span style='width: 50%; display: inline-block;'>";
							tr_tag = tr_tag + "		규격: " + vo.itemSpecX + " x " + vo.itemSpecY;
							tr_tag = tr_tag + "		</span><span style='width: 50%; display: inline-block;'>";;
							tr_tag = tr_tag + "		실사용지: " + vo.paper3Nm +"/" + vo.paper4Nm;
							tr_tag = tr_tag + "		</span></p>";
							tr_tag = tr_tag + "		<p><span style='width: 50%; display: inline-block;'>";
							tr_tag = tr_tag + "		수량: " + addCommas(vo.totalQty);
							tr_tag = tr_tag + "		</span><span style='width: 50%; display: inline-block;'>";;
							tr_tag = tr_tag + "		납품방법: " + vo.deliveryNm;
							tr_tag = tr_tag + "		</span></p>";	
							tr_tag = tr_tag + "	</td>";
						}
						else if(vo.itemCls == "05"){
							tr_tag = tr_tag + "	<td style='text-align:left'>";
							tr_tag = tr_tag + "		회사명: " + vo.company;
							tr_tag = tr_tag + "		<br>";
							tr_tag = tr_tag + "		품명: " + vo.itemNm;
							tr_tag = tr_tag + "		<br>";
							tr_tag = tr_tag + "		납품방법: " + vo.deliveryNm;
							tr_tag = tr_tag + "	</td>";
						}
						
						tr_tag = tr_tag + "	<td>";
						tr_tag = tr_tag + vo.newDate + "<br>" + vo.newTime;
						tr_tag = tr_tag + "	</td>";
						tr_tag = tr_tag + "	<td>";
						tr_tag = tr_tag + vo.dueDate;
						tr_tag = tr_tag + "	</td>";
						tr_tag = tr_tag + "	<td>";

						if (vo.endDate != null && vo.endTime != null) {
							tr_tag = tr_tag + vo.endDate + "<br>" + vo.endTime;
						} else {
							tr_tag = tr_tag
									+ "		<button class='modbutton' data-orderid='"
									+ vo.orderId
									+ "'><img src= '"
									+ __contextPath__
									+ "/resources/image/btn/icon_modify03.jpg'></button><br>"
							tr_tag = tr_tag
									+ "     <button class='delbutton' data-orderid='"
									+ vo.orderId
									+ "'><img src= '"
									+ __contextPath__
									+ "/resources/image/btn/btn_cancel.jpg'></button><br>"
							if(_loginCls == 'admin'){
								tr_tag = tr_tag
								+ "     <button class='endbutton' data-orderid='"
								+ vo.orderId
								+ "'><img src= '"
								+ __contextPath__
								+ "/resources/image/btn/btn_finish.jpg'></button><br>"
								
							}
						}
						tr_tag = tr_tag + "</td>";
						
						tr_tag = tr_tag + "<td style=' text-align:center'>";
						tr_tag = tr_tag	+ "     <button class='filedownbutton' data-fileid='"+ vo.file1 + "' data-tooltip-text='"	+ (vo.file1Name == ""?"파일 없음": vo.file1Name) + "'>";
						tr_tag = tr_tag + "			<img src= '"+__contextPath__+ "/resources/image/btn/box-closed-blue.png'>";
						tr_tag = tr_tag + "     </button>"; 
						tr_tag = tr_tag + "		<br>"; 
						tr_tag = tr_tag + "		<br>"; 
						tr_tag = tr_tag + "     <button class='filedownbutton' data-fileid='"+ vo.file2 + "' data-tooltip-text='" + (vo.file2Name == ""?"파일 없음": vo.file2Name) +"'>";
						tr_tag = tr_tag + "     	<img src= '" +__contextPath__+ "/resources/image/btn/box-closed-blue.png'>";
						tr_tag = tr_tag +		"</button>";
						tr_tag = tr_tag + "</td>";
						
						tr_tag = tr_tag + "<td>";
						tr_tag = tr_tag	+ "		<button class='printbutton' data-orderid='"+ vo.orderId + "'>";
						tr_tag = tr_tag	+ "   		<img src= '"+__contextPath__+ "/resources/image/btn/btn_print.jpg'>";
						tr_tag = tr_tag	+ "		</button>";
						tr_tag = tr_tag + "</td>";
						tr_tag = tr_tag + "</tr>";
						tr_tag = tr_tag + "<tr>";
						tr_tag = tr_tag
								+ "	<td colspan='6'  style=' text-align:left'>";
						tr_tag = tr_tag
								+ "		<textarea style='width:90%;height:90%;resize: none;' readonly='readonly'>";
						tr_tag = tr_tag + vo.description;
						tr_tag = tr_tag + "		</textarea>";
						tr_tag = tr_tag + "	</td>";
						tr_tag = tr_tag + "</tr>";
					});
		}

		$("#orderlist").html(tr_tag);
	};
	// 페이징 핸들러
	var pagingHandler = function(totalCnt, curPage) {

		totalCnt = totalCnt == 0 ? 1 : totalCnt;

		// 보여줄 전체 페이지수
		var totalPageCnt = Math.ceil(totalCnt / 10);
		// 보여줄 전체 블럭수
		var totalBlockCnt = Math.ceil(totalPageCnt / 10);
		// 현재 블럭
		var curBlock = Math.ceil(curPage / 10);
		// 블럭 시작
		var startBlock = ((curBlock - 1) * 10) + 1;
		// 블럭 마지막
		var endBlock = curBlock * 10 > totalPageCnt ? totalPageCnt
				: curBlock * 10;

		var first = 1

		// var prev = startBlock - 10 < 0 ? startBlock : startBlock - 10;
		var prev = startBlock - 1 == 0 ? startBlock : startBlock - 1;

		// var next = endBlock + 10 > totalPageCnt ? totalPageCnt : endBlock +
		// 10
		var next = endBlock + 1 > totalPageCnt ? totalPageCnt : endBlock + 1;

		var last = totalPageCnt

		console.log("totalCnt : ", totalCnt);
		console.log("curPage  : ", curPage);
		console.log("totalPageCnt : ", totalPageCnt);
		console.log("totalBlockCnt : ", totalBlockCnt);
		console.log("curBlock : ", curBlock);
		console.log("startBlock : ", startBlock);
		console.log("endBlock : ", endBlock);

		var strLog = "";

		strLog = strLog + first;
		strLog = strLog + " | " + prev;
		for (var i = startBlock; i <= endBlock; i++) {
			strLog = strLog + " | " + i;
		}
		strLog = strLog + " | " + next;
		strLog = strLog + " | " + last;

		console.log("strPageLog : ", strLog);

		var strPageTag = "<ul class='numbering'><li><a data-page='1'><img src='"
				+ __contextPath__
				+ "/resources/image/btn/btn_front.gif' alt='처음'></a></li>";
		strPageTag += "<li><a data-page='" + prev + "'><img src='"
				+ __contextPath__
				+ "/resources/image/btn/btn_pre.gif' alt='이전'></a></li>";
		for (var i = startBlock; i <= endBlock; i++) {
			if (i == curPage) {
				strPageTag += "<li style='margin-top:5px;'><a data-page='" + i
						+ "' class='curpage'>" + i + "</a></li>";
			} else {
				strPageTag += "<li style='margin-top:5px;'><a data-page='" + i
						+ "'>" + i + "</a></li>";
			}
		}
		strPageTag += "<li><a data-page='" + next + "'><img src='"
				+ __contextPath__
				+ "/resources/image/btn/btn_nxt.gif' alt='다음'></a></li>";
		strPageTag += "<li><a data-page='" + last + "'><img src='"
				+ __contextPath__
				+ "/resources/image/btn/btn_end.gif' alt='끝'></a></li></ul>";

		$("#paginate").html(strPageTag);
	};

	// layer popup : 등록/수정 폼
	var orderFormPopup = function(itemCls) {
		if (!itemCls) {
			itemCls = "01";
		}
		$.blockUI({
			message : $('#orderForm'),
			css : {
				top : ($(window).height() - 500) / 2 + 'px',
				left : ($(window).width() - 900) / 2 + 'px',
				width : '900px',
				cursor : 'auto'
			}
		});
		$(".orderViewPart").hide();
		$(".orderCls" + itemCls).show();
		$("#file1_progress .bar").css("width","0%");
		$("#file2_progress .bar").css("width","0%");
	};

	// calendar 핸들러
	var initCalendar = function() {
		$("#calendarView").datepicker({
			onSelect : function(dateText, inst) {
				// 일자 선택된 후 이벤트 발생
				console.log(dateText);

				var param = {
					"searchString1" : "",
					"searchString2" : "",
					"searchString3" : dateText,
					"searchString4" : dateText,
					"searchString5" : "",
					"searchString6" : "",
				}
				$("#searchString3").val(dateText);
				$("#searchString4").val(dateText);
				transaction.getList(param).done(function(resultdata) {
					tableHandler(resultdata);
					pagingHandler(resultdata.totalCnt, resultdata.currentPage);

				});
			}
		});
	};

	var initFile = function() {
		$("#fileupload1").fileupload({
			dataType : "json",
			add : function(e, data) {
				data.submit();
			},
			progress : function(e, data) {
				var progress = parseInt((data.loaded / data.total) * 100, 10);				
		        $('#file1_progress .bar').css('width', progress + '%');
			},
			done : function(e, data) {
				console.log(data);
				if(data.fileId == 0){
					alert("파일 업로드에 실패 하였습니다.");
				}
				else {
					$("#file1").val(data.result.fileId);
					$("#fileName1").text(data.result.originalFileName);
				}
			}
		});
		
		$("#fileupload2").fileupload({
			dataType : "json",
			add : function(e, data) {
				data.submit();
			},
			progress : function(e, data) {
				var progress = parseInt((data.loaded / data.total) * 100, 10);				
		        $('#file2_progress .bar').css('width', progress + '%');
			},
			done : function(e, data) {
				console.log(data);
				if(data.fileId == 0){
					alert("파일 업로드에 실패 하였습니다.");
				}
				else {
					$("#file2").val(data.result.fileId);
					$("#fileName2").text(data.result.originalFileName);
				}
			}
		});
		 
	};
	return {
		initDatepicker : initDatepicker,
		initCalendar : initCalendar,
		orderFormPopup : orderFormPopup,
		tableHandler : tableHandler,
		pagingHandler : pagingHandler,
		initFile : initFile,
	};
};

/*******************************************************************************
 * model
 ******************************************************************************/
var OrderModel = function() {
	var getOrderType01 = function() {
		return {
			orderId : $("#orderId").val(),
			itemCls : $("#itemCls").val(),
			itemNm : $("#itemNm").val(),

			company : $("#company01").val(),
			
			itemSpecX : $("#itemSpecX01").val(),
			itemSpecY : $("#itemSpecY01").val(),
			totalQty : removeCommas($("#totalQty01").val()),
			paper1 : $("#paper101").val(),
			paper2 : $("#paper201").val(),
			parerRoll : $("#parerRoll01").val(),
			rollQty : removeCommas($("#rollQty01").val()),
			dueDate : $("#dueDate01").val(),
			delivery : $("#delivery01").val(),

			description : $("#description").val(),
			file1 : $("#file1").val(),
			file2 : $("#file2").val(),

			setEnd : $("#setEnd").val(),
			endDate : $("#endDate").val(),
			endTime : $("#endTime").val(),

			userId : _loginUser,
			newDate : $("#newDate").val(),
			newTime : $("#newTime").val(),
			modDate : $("#modDate").val(),
			modTime : $("#modTime").val(),
		};
	};
	var setOrderType01 = function(vo) {
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#itemNm").val(vo.itemNm);

		$("#company01").val(vo.company);
		$("#itemSpecX01").val(vo.itemSpecX);
		$("#itemSpecY01").val(vo.itemSpecY);
		$("#totalQty01").val(addCommas(vo.totalQty));
		$("#paper101").val(vo.paper1);
		$("#paper201").val(vo.paper2);
		$("#parerRoll01").val(vo.parerRoll);
		$("#rollQty01").val(addCommas(vo.rollQty));
		$("#dueDate01").val(vo.dueDate);
		$("#delivery01").val(vo.delivery);

		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#fileName1").text(vo.file1Name);
		$("#file2").val(vo.file2);
		$("#fileName2").text(vo.file2Name);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};

	var getOrderType02 = function() {
		return {
			orderId : $("#orderId").val(),
			itemCls : $("#itemCls").val(),
			itemNm : $("#itemNm").val(),

			company : $("#company02").val(),

			dueDate : $("#dueDate02").val(),
			delivery : $("#delivery02").val(),

			description : $("#description").val(),
			file1 : $("#file1").val(),
			file2 : $("#file2").val(),

			setEnd : $("#setEnd").val(),
			endDate : $("#endDate").val(),
			endTime : $("#endTime").val(),

			userId : _loginUser,
			newDate : $("#newDate").val(),
			newTime : $("#newTime").val(),
			modDate : $("#modDate").val(),
			modTime : $("#modTime").val(),
		};
	};
	var setOrderType02 = function(vo) {
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#itemNm").val(vo.itemNm);

		$("#company02").val(vo.company);

		$("#dueDate02").val(vo.dueDate);
		$("#delivery02").val(vo.delivery);

		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#fileName1").text(vo.file1Name);
		$("#file2").val(vo.file2);
		$("#fileName2").text(vo.file2Name);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};

	// 리본
	var getOrderType03 = function() {
		return {
			orderId : $("#orderId").val(),
			itemCls : $("#itemCls").val(),
			itemNm : $("#itemNm").val(),

			company : $("#company03").val(),
			
			itemSpecX : $("#itemSpecX03").val(),
			itemSpecY : $("#itemSpecY03").val(),
			totalQty : removeCommas($("#totalQty03").val()),
			parerRoll : $("#parerRoll03").val(),
			dueDate : $("#dueDate03").val(),
			delivery : $("#delivery03").val(),

			description : $("#description").val(),
			file1 : $("#file1").val(),
			file2 : $("#file2").val(),

			setEnd : $("#setEnd").val(),
			endDate : $("#endDate").val(),
			endTime : $("#endTime").val(),

			userId : _loginUser,
			newDate : $("#newDate").val(),
			newTime : $("#newTime").val(),
			modDate : $("#modDate").val(),
			modTime : $("#modTime").val(),
		};
	};
	var setOrderType03 = function(vo) {
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#itemNm").val(vo.itemNm);

		$("#company03").val(vo.company);
		
		$("#itemSpecX03").val(vo.itemSpecX);
		$("#itemSpecY03").val(vo.itemSpecY);
		$("#totalQty03").val(addCommas(vo.totalQty));
		$("#parerRoll03").val(vo.parerRoll);
		$("#dueDate03").val(vo.dueDate);
		$("#delivery03").val(vo.delivery);

		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#fileName1").text(vo.file1Name);
		$("#file2").val(vo.file2);
		$("#fileName2").text(vo.file2Name);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};

	// 실사
	var getOrderType04 = function() {
		return {
			orderId : $("#orderId").val(),
			itemCls : $("#itemCls").val(),
			itemNm : $("#itemNm").val(),

			company : $("#company04").val(),
			
			itemSpecX : $("#itemSpecX04").val(),
			itemSpecY : $("#itemSpecY04").val(),
			totalQty : removeCommas($("#totalQty04").val()),
			paper3 : $("#paper304").val(),
			paper4 : $("#paper404").val(),
			parerRoll : $("#parerRoll04").val(),
			dueDate : $("#dueDate04").val(),
			delivery : $("#delivery04").val(),

			description : $("#description").val(),
			file1 : $("#file1").val(),
			file2 : $("#file2").val(),

			setEnd : $("#setEnd").val(),
			endDate : $("#endDate").val(),
			endTime : $("#endTime").val(),

			userId : _loginUser,
			newDate : $("#newDate").val(),
			newTime : $("#newTime").val(),
			modDate : $("#modDate").val(),
			modTime : $("#modTime").val(),
		};
	};
	var setOrderType04 = function(vo) {
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#itemNm").val(vo.itemNm);

		$("#company04").val(vo.company);
		
		$("#itemSpecX04").val(vo.itemSpecX);
		$("#itemSpecY04").val(vo.itemSpecY);
		$("#totalQty04").val(addCommas(vo.totalQty));
		$("#paper304").val(vo.paper3);
		$("#paper404").val(vo.paper4);
		$("#dueDate04").val(vo.dueDate);
		$("#delivery04").val(vo.delivery);

		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#fileName1").text(vo.file1Name);
		$("#file2").val(vo.file2);
		$("#fileName2").text(vo.file2Name);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};

	// 기타
	var getOrderType05 = function() {
		return {
			orderId : $("#orderId").val(),
			itemCls : $("#itemCls").val(),
			itemNm : $("#itemNm").val(),

			company : $("#company05").val(),

			dueDate : $("#dueDate05").val(),
			delivery : $("#delivery05").val(),

			description : $("#description").val(),
			file1 : $("#file1").val(),
			file2 : $("#file2").val(),

			setEnd : $("#setEnd").val(),
			endDate : $("#endDate").val(),
			endTime : $("#endTime").val(),

			userId : _loginUser,
			newDate : $("#newDate").val(),
			newTime : $("#newTime").val(),
			modDate : $("#modDate").val(),
			modTime : $("#modTime").val(),
		};
	};
	var setOrderType05 = function(vo) {
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#itemNm").val(vo.itemNm);

		$("#company05").val(vo.company);
		
		$("#dueDate05").val(vo.dueDate);
		$("#delivery05").val(vo.delivery);

		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#fileName1").text(vo.file1Name);
		$("#file2").val(vo.file2);
		$("#fileName2").text(vo.file2Name);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};

	var setOrderInit = function() {
		$("#orderId").val("");
		$("#itemCls").val("01");
		$("#company").val("");

		$("#company01").val("");
		$("#itemSpecX01").val("");
		$("#itemSpecY01").val("");
		$("#totalQty01").val("");
		$("#paper101").val("");
		$("#paper201").val("");
		$("#parerRoll01").val("");
		$("#rollQty01").val("");
		$("#dueDate01").val("");
		$("#delivery01").val("");
		
		$("#company02").val("");
		$("#dueDate02").val("");
		$("#delivery02").val("");
		
		$("#company03").val("");
		$("#itemSpecX03").val("");
		$("#itemSpecY03").val("");
		$("#totalQty03").val("");
		$("#parerRoll03").val("");
		$("#dueDate03").val("");
		$("#delivery03").val("");
		
		$("#company04").val("");
		$("#itemSpecX04").val("");
		$("#itemSpecY04").val("");
		$("#totalQty04").val("");
		$("#paper304").val("");
		$("#paper404").val("");
		$("#dueDate04").val("");
		$("#delivery04").val("");
		
		$("#company05").val("");
		$("#dueDate05").val("");
		$("#delivery05").val("");

		$("#description").val("");
		$("#file1").val("");
		$("#file2").val("");
	};

	return {
		setOrderType01 : setOrderType01,
		getOrderType01 : getOrderType01,

		setOrderType02 : setOrderType02,
		getOrderType02 : getOrderType02,

		setOrderType03 : setOrderType03,
		getOrderType03 : getOrderType03,

		setOrderType04 : setOrderType04,
		getOrderType04 : getOrderType04,

		setOrderType05 : setOrderType05,
		getOrderType05 : getOrderType05,

		setOrderInit : setOrderInit,
	}
};

/*******************************************************************************
 * transaction
 ******************************************************************************/
var OrderTransaction = function() {

	var regOrder = function(param) {
		console.log("saveOrder");
		var deferred = $.Deferred();
		try {
			$.ajax({
				url : __contextPath__ + '/order/regItem',
				method : 'POST',
				contentType : 'application/json',
				dataType : 'text',
				crossDomain : true,
				data : JSON.stringify(param),
				success : function(message) {
					console.log(message);
					deferred.resolve(message);
				}
			});
		} catch (err) {
			deferred.reject(err);
		}
		return deferred.promise();
	};

	var modOrder = function(param) {
		console.log("saveOrder");
		var deferred = $.Deferred();
		try {
			$.ajax({
				url : __contextPath__ + '/order/modItem',
				method : 'POST',
				contentType : 'application/json',
				dataType : 'text',
				crossDomain : true,
				data : JSON.stringify(param),
				success : function(message) {
					console.log(message);
					deferred.resolve(message);
				}
			});
		} catch (err) {
			deferred.reject(err);
		}
		return deferred.promise();
	};

	var delOrder = function(param) {
		console.log("deleteOrder");

		var deferred = $.Deferred();
		try {
			$.ajax({
				type : "POST",
				url : __contextPath__ + "/order/delItem",
				data : param,
				dataType : "text",
				success : function(data) {
					console.log(data);
					deferred.resolve(data);
				}
			});
		} catch (err) {
			deferred.reject(err);
		}
		return deferred.promise();
	};

	var getList = function(param) {
		console.log("getOrderList");

		var deferred = $.Deferred();
		try {
			$.ajax({
				type : "GET",
				url : __contextPath__ + "/order/getList",
				data : param,
				dataType : "json",
				success : function(data) {
					console.log(data);
					deferred.resolve(data);
				}
			});
		} catch (err) {
			deferred.reject(err);
		}
		return deferred.promise();
	};

	var getItem = function(param) {
		console.log("getOrderItem");

		var deferred = $.Deferred();
		try {
			$.ajax({
				type : "GET",
				url : __contextPath__ + "/order/getItem",
				data : {
					"orderId" : param,
				},
				dataType : "json",
				success : function(data) {
					console.log(data);
					deferred.resolve(data);
				}
			});
		} catch (err) {
			deferred.reject(err);
		}
		return deferred.promise();
	};

	return {
		regOrder : regOrder,
		modOrder : modOrder,
		delOrder : delOrder,
		getList : getList,
		getItem : getItem,
	}
};