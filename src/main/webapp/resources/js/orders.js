/********************************************************************************
 * controller
 ********************************************************************************/
var OrderApp = function () {
    var transaction  = new OrderTransaction();
    var view         = new OrderViewHandler(transaction);
    
    var initApp = function (){
    	regEventHandler();
    	view.initDatepicker();
    	view.initCalendar();
    };

    var regEventHandler = function() {
    	// 사용자 등록 페이지로 이동
        $('#btn_userReg').click(function() {
        	location.href="/users"
        });
        
        // 등록 폼 오픈
        $('#btn_orderReg').click(function() { 
        	view.orderFormPopup();
        });
        
        // 등록 폼 취소
        $('#btn_cancelOrder').click(function() { 
            $.unblockUI();
        });
        
        // excel 다운로드
        $('#btn_excel').click(function() {
        	alert("excel 다운로드");
        });
        
        $('#selectOrderCls').on('change',function() {
        	// alert(this.value);
        	var targetView = ".orderCls" + this.value;
        	$(".orderViewPart").hide();
        	$(targetView).show();
        });
    };
    
    return {
        initApp : initApp
    }
};
/********************************************************************************
 * view handler
 ********************************************************************************/
var OrderViewHandler = function(transaction){
	// datepicker 초기화
    //모든 datepicker에 대한 공통 옵션 설정
	var initDatepicker = function (){
		
	    $.datepicker.setDefaults({
	        dateFormat: 'yy-mm-dd' //Input Display Format 변경
	        ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	        ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
	        ,changeYear: true //콤보박스에서 년 선택 가능
	        ,changeMonth: true //콤보박스에서 월 선택 가능                
	        ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
	        ,buttonImage: "/resources/image/layout/icon_cal.gif" //버튼 이미지 경로
	        ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
	        ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
	        ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
	        ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
	        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
	        ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
	        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
	    });
	    
	    
	    $(".usedatepicker").datepicker();
	    $(".ui-datepicker-trigger").css("height","25px");
	};
	
	//테이블 핸들러
	var tableHandler = function(vo){
		
	};
	//페이징 핸들러
	var pagingHandler = function(page){
		
	};
	
	//layer popup : 등록/수정 폼
	var orderFormPopup = function (){
        $.blockUI({ 
            message: $('#orderForm'), 
            css: { 
                top:  ($(window).height() - 500) /2 + 'px', 
                left: ($(window).width() - 900) /2 + 'px', 
                width: '900px',
                cursor: 'auto' 
            } 
        }); 
        console.log("check")
    	$(".orderViewPart").hide();
    	$(".orderCls01").show();
	};
	
	// calendar 핸들러
	var initCalendar = function (){
		$("#calendarView").datepicker();
	};
	
	
	return {
		initDatepicker : initDatepicker,
		initCalendar : initCalendar,
		orderFormPopup : orderFormPopup
	};
};

/********************************************************************************
 * model
 ********************************************************************************/
var OrderModel = function (){
	
	var getOrderType01 = function (){
		return {
			orderId     : $("#orderId").val(),
			itemCls     : $("#itemCls").val(),
			company     : $("#company").val(),
			
			itemNm      : $("#itemNm01").val(),
			itemSpec    : $("#itemSpec01").val(),
			totalQty    : $("#totalQty01").val(),
			paper1      : $("#paper101").val(),
			paper2      : $("#paper201").val(),
			paper3      : $("#paper301").val(),
			paper4      : $("#paper401").val(),
			parerRoll   : $("#parerRoll01").val(),
			rollQty     : $("#rollQty01").val(),
			dueDate     : $("#dueDate01").val(),
			delivery    : $("#delivery01").val(),
			
			description : $("#description").val(),
			file1       : $("#file1").val(),
			file2       : $("#file2").val(),

			setEnd      : $("#setEnd").val(),
			endDate     : $("#endDate").val(),
			endTime     : $("#endTime").val(),

			userId      : $("#userId").val(),
			newDate     : $("#newDate").val(),
			newTime     : $("#newTime").val(),
			modDate     : $("#modDate").val(),
			modTime	    : $("#modTime").val(),
		};
	};
	var setOrderType01 = function (vo){
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#company").val(vo.company);
		
		$("#itemNm01").val(vo.itemNm);
		$("#itemSpec01").val(vo.itemSpec);
		$("#totalQty01").val(vo.totalQty);
		$("#paper101").val(vo.paper1);
		$("#paper201").val(vo.paper2);
		$("#paper301").val(vo.paper3);
		$("#paper401").val(vo.paper4);
		$("#parerRoll01").val(vo.parerRoll);
		$("#rollQty01").val(vo.rollQty);
		$("#dueDate01").val(vo.dueDate);
		$("#delivery01").val(vo.delivery);
		
		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#file2").val(vo.file2);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};
	
	var getOrderType02 = function (){
		return {
			orderId     : $("#orderId").val(),
			itemCls     : $("#itemCls").val(),
			company     : $("#company").val(),
			
			itemNm      : $("#itemNm02").val(),
			itemSpec    : $("#itemSpec02").val(),
			totalQty    : $("#totalQty02").val(),
			paper1      : $("#paper102").val(),
			paper2      : $("#paper202").val(),
			paper3      : $("#paper302").val(),
			paper4      : $("#paper402").val(),
			parerRoll   : $("#parerRoll02").val(),
			rollQty     : $("#rollQty02").val(),
			dueDate     : $("#dueDate02").val(),
			delivery    : $("#delivery02").val(),
			
			description : $("#description").val(),
			file1       : $("#file1").val(),
			file2       : $("#file2").val(),

			setEnd      : $("#setEnd").val(),
			endDate     : $("#endDate").val(),
			endTime     : $("#endTime").val(),

			userId      : $("#userId").val(),
			newDate     : $("#newDate").val(),
			newTime     : $("#newTime").val(),
			modDate     : $("#modDate").val(),
			modTime	    : $("#modTime").val(),
		};
	};
	var setOrderType02 = function (){
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#company").val(vo.company);
		
		$("#itemNm02").val(vo.itemNm);
		$("#itemSpec02").val(vo.itemSpec);
		$("#totalQty02").val(vo.totalQty);
		$("#paper102").val(vo.paper1);
		$("#paper202").val(vo.paper2);
		$("#paper302").val(vo.paper3);
		$("#paper402").val(vo.paper4);
		$("#parerRoll02").val(vo.parerRoll);
		$("#rollQty02").val(vo.rollQty);
		$("#dueDate02").val(vo.dueDate);
		$("#delivery02").val(vo.delivery);
		
		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#file2").val(vo.file2);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};
	
	var getOrderType03 = function (){
		return {
			orderId     : $("#orderId").val(),
			itemCls     : $("#itemCls").val(),
			company     : $("#company").val(),
			
			itemNm      : $("#itemNm03").val(),
			itemSpec    : $("#itemSpec03").val(),
			totalQty    : $("#totalQty03").val(),
			paper1      : $("#paper103").val(),
			paper2      : $("#paper203").val(),
			paper3      : $("#paper303").val(),
			paper4      : $("#paper403").val(),
			parerRoll   : $("#parerRoll03").val(),
			rollQty     : $("#rollQty03").val(),
			dueDate     : $("#dueDate03").val(),
			delivery    : $("#delivery03").val(),
			
			description : $("#description").val(),
			file1       : $("#file1").val(),
			file2       : $("#file2").val(),

			setEnd      : $("#setEnd").val(),
			endDate     : $("#endDate").val(),
			endTime     : $("#endTime").val(),

			userId      : $("#userId").val(),
			newDate     : $("#newDate").val(),
			newTime     : $("#newTime").val(),
			modDate     : $("#modDate").val(),
			modTime	    : $("#modTime").val(),
		};
	};
	var setOrderType03 = function (){
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#company").val(vo.company);
		
		$("#itemNm03").val(vo.itemNm);
		$("#itemSpec03").val(vo.itemSpec);
		$("#totalQty03").val(vo.totalQty);
		$("#paper103").val(vo.paper1);
		$("#paper203").val(vo.paper2);
		$("#paper303").val(vo.paper3);
		$("#paper403").val(vo.paper4);
		$("#parerRoll03").val(vo.parerRoll);
		$("#rollQty03").val(vo.rollQty);
		$("#dueDate03").val(vo.dueDate);
		$("#delivery03").val(vo.delivery);
		
		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#file2").val(vo.file2);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};
	
	var getOrderType04 = function (){
		return {
			orderId     : $("#orderId").val(),
			itemCls     : $("#itemCls").val(),
			company     : $("#company").val(),
			
			itemNm      : $("#itemNm04").val(),
			itemSpec    : $("#itemSpec04").val(),
			totalQty    : $("#totalQty04").val(),
			paper1      : $("#paper104").val(),
			paper2      : $("#paper204").val(),
			paper3      : $("#paper304").val(),
			paper4      : $("#paper404").val(),
			parerRoll   : $("#parerRoll04").val(),
			rollQty     : $("#rollQty04").val(),
			dueDate     : $("#dueDate04").val(),
			delivery    : $("#delivery04").val(),
			
			description : $("#description").val(),
			file1       : $("#file1").val(),
			file2       : $("#file2").val(),

			setEnd      : $("#setEnd").val(),
			endDate     : $("#endDate").val(),
			endTime     : $("#endTime").val(),

			userId      : $("#userId").val(),
			newDate     : $("#newDate").val(),
			newTime     : $("#newTime").val(),
			modDate     : $("#modDate").val(),
			modTime	    : $("#modTime").val(),
		};
	};
	var setOrderType04 = function (){
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#company").val(vo.company);
		
		$("#itemNm04").val(vo.itemNm);
		$("#itemSpec04").val(vo.itemSpec);
		$("#totalQty04").val(vo.totalQty);
		$("#paper104").val(vo.paper1);
		$("#paper204").val(vo.paper2);
		$("#paper304").val(vo.paper3);
		$("#paper404").val(vo.paper4);
		$("#parerRoll04").val(vo.parerRoll);
		$("#rollQty04").val(vo.rollQty);
		$("#dueDate04").val(vo.dueDate);
		$("#delivery04").val(vo.delivery);
		
		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#file2").val(vo.file2);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};
	
	var getOrderType05 = function (){
		return {
			orderId     : $("#orderId").val(),
			itemCls     : $("#itemCls").val(),
			company     : $("#company").val(),
			
			itemNm      : $("#itemNm05").val(),
			itemSpec    : $("#itemSpec05").val(),
			totalQty    : $("#totalQty05").val(),
			paper1      : $("#paper105").val(),
			paper2      : $("#paper205").val(),
			paper3      : $("#paper305").val(),
			paper4      : $("#paper405").val(),
			parerRoll   : $("#parerRoll05").val(),
			rollQty     : $("#rollQty05").val(),
			dueDate     : $("#dueDate05").val(),
			delivery    : $("#delivery05").val(),
			
			description : $("#description").val(),
			file1       : $("#file1").val(),
			file2       : $("#file2").val(),

			setEnd      : $("#setEnd").val(),
			endDate     : $("#endDate").val(),
			endTime     : $("#endTime").val(),

			userId      : $("#userId").val(),
			newDate     : $("#newDate").val(),
			newTime     : $("#newTime").val(),
			modDate     : $("#modDate").val(),
			modTime	    : $("#modTime").val(),
		};
	};
	var setOrderType05 = function (){
		$("#orderId").val(vo.orderId);
		$("#itemCls").val(vo.itemCls);
		$("#company").val(vo.company);
		
		$("#itemNm05").val(vo.itemNm);
		$("#itemSpec05").val(vo.itemSpec);
		$("#totalQty05").val(vo.totalQty);
		$("#paper105").val(vo.paper1);
		$("#paper205").val(vo.paper2);
		$("#paper305").val(vo.paper3);
		$("#paper405").val(vo.paper4);
		$("#parerRoll05").val(vo.parerRoll);
		$("#rollQty05").val(vo.rollQty);
		$("#dueDate05").val(vo.dueDate);
		$("#delivery05").val(vo.delivery);
		
		$("#description").val(vo.description);
		$("#file1").val(vo.file1);
		$("#file2").val(vo.file2);

		$("#setEnd").val(vo.setEnd);
		$("#endDate").val(vo.endDate);
		$("#endTime").val(vo.endTime);

		$("#userId").val(vo.userId);
		$("#newDate").val(vo.newDate);
		$("#newTime").val(vo.newTime);
		$("#modDate").val(vo.modDate);
		$("#modTime").val(vo.modTime);
	};
	
	return {
		
	}
};


/********************************************************************************
 * transaction
 ********************************************************************************/
var OrderTransaction = function(){

	var regOrder = function (param) {
        console.log("saveOrder");
        var deferred = $.Deferred();
        try {
            $.ajax({
                url : '/fac/fca/saveOrder',
                method : 'POST',
                contentType : 'application/json',
                dataType : 'text',
                crossDomain : true,
                data : JSON.stringify(param),
                success : function (message) {
                    console.log(message);
                    deferred.resolve(message);
                }
            });
        } catch (err) {
            deferred.reject(err);
        }
        return deferred.promise();
    };
    

	var modOrder = function (param) {
        console.log("saveOrder");
        var deferred = $.Deferred();
        try {
            $.ajax({
                url : '/fac/fca/saveOrder',
                method : 'POST',
                contentType : 'application/json',
                dataType : 'text',
                crossDomain : true,
                data : JSON.stringify(param),
                success : function (message) {
                    console.log(message);
                    deferred.resolve(message);
                }
            });
        } catch (err) {
            deferred.reject(err);
        }
        return deferred.promise();
    };
    
  
    
    var delOrder = function (param) {
        console.log("deleteOrder");

        var deferred = $.Deferred();
        try {
            $.ajax({
                type : "POST",
                url : "/fac/fca/deleteOrder",
                data : param,
                dataType : "text",
                success : function (data) {
                    console.log(data);
                    deferred.resolve(data);
                }
            });
        } catch (err) {
            deferred.reject(err);
        }
        return deferred.promise();
    };
    
    var getList = function (param) {
        console.log("deleteOrder");

        var deferred = $.Deferred();
        try {
            $.ajax({
                type : "POST",
                url : "/fac/fca/deleteOrder",
                data : param,
                dataType : "text",
                success : function (data) {
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
    	regOrder     : regOrder,
    	modOrder     : modOrder,
    	delOrder     : delOrder,
    	getList      : getList
    }
};