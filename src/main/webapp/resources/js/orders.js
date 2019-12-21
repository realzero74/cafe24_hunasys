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

	var vo = {
			
	};
	
	var getOrderType01 = function (){};
	var setOrderType01 = function (){};
	
	var getOrderType02 = function (){};
	var setOrderType02 = function (){};
	
	var getOrderType03 = function (){};
	var setOrderType03 = function (){};
	
	var getOrderType04 = function (){};
	var setOrderType04 = function (){};
	
	var getOrderType05 = function (){};
	var setOrderType05 = function (){};
	
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