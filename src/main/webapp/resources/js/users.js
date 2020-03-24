/**
 * 
 */
var UserApp = function () {
    var transaction  = new UserTransaction();
    var view         = new UserViewHandler(transaction);
    var model        = new UserModel();
    
    var initApp = function (){
    	regEventHandler();
    	
    	var param = {
    		"curentPage"    : "1" 
    	}
    	transaction.getList(param).done(function (resultdata) {
    		view.tableHandler(resultdata);
    		view.pagingHandler(resultdata.totalCnt, resultdata.currentPage);
        });
    };
    var regEventHandler = function(){
    	
		// 로그아웃
		$('#btn_gomain').on('click',	function() {
			location.href = __contextPath__+"/orders";  
		});
    	
    	// 등록 폼 오픈
        $('#regbutton').click(function() {
        	model.setUserInit();
        	view.userFormPopup();
        });
    	
        // 등록 폼 저장
        $('#userFrmSave').click(function() {
        	if(model.valicationCheck){
        		var param = model.getUser();
        		if(param.editflag == "new"){
        			transaction.regUser(param).done(function (resultdata) {
        				$.unblockUI();
        				transaction.getList().done(function (resultdata) {
        					view.tableHandler(resultdata);
        					view.pagingHandler(resultdata.totalCnt, resultdata.currentPage);
        				});
        			});
        		}
        		else {
        			transaction.modUser(param).done(function (resultdata) {
        				$.unblockUI();
        				transaction.getList().done(function (resultdata) {
        					view.tableHandler(resultdata);
        					view.pagingHandler(resultdata.totalCnt, resultdata.currentPage);
        				});
        			});
        		}
        	}
        	else {
        		alert("입력되지 않았습니다.");
        	}
        });
        
        // 등록 폼 닫기 - 취소
        $('#userFrmCancel').click(function() {
        	model.setUserInit();
            $.unblockUI();
        });
        
        // 수정 버튼
        $(document).on("click",".modbutton",function(){
        	console.log(this);
        	console.log($(this).attr("data-userid"));
        	var userid = $(this).attr("data-userid");
        	
        	transaction.getItem(userid).done(function (resultdata) {
        		resultdata.editflag = "mod";
        		console.log(resultdata);
        		model.setUser(resultdata);
        		view.userFormPopup();
            });
        });
        
        $(document).on("click",".delbutton",function(){
        	console.log(this);
        	console.log($(this).attr("data-userid"));
        	var param = {
        		"userId" : $(this).attr("data-userid")
        	};
            transaction.delUser(param).done(function (delresultdata) {
            	transaction.getList().done(function (resultdata) {
            		view.tableHandler(resultdata);
            		view.pagingHandler(resultdata.totalCnt, resultdata.currentPage);
                });
            });
        });
    };
    
    return {
        initApp : initApp
    }
};



/********************************************************************************
 * view handler
 ********************************************************************************/
var UserViewHandler = function(transaction){
	//테이블 핸들러
	var tableHandler = function(data){
		
		var datalist = data.datalist;
		
		var tr_tag = "";
		tr_tag = tr_tag + "<tr style='display:table-row'>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		번호";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		사용자ID";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		사용자(회사)";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		구분";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		가입일";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		최근수정일";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		사용자정보변경";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "	<th>";
		tr_tag = tr_tag + "		사용자 삭제";
		tr_tag = tr_tag + "	</th>";
		tr_tag = tr_tag + "</tr>";

		
		if(datalist.length == 0){
			tr_tag = tr_tag + "<tr style='display:table-row'>";
			tr_tag = tr_tag + "	<td colspan = '7'>";
			tr_tag = tr_tag + "		조회결과가 없습니다.	";
			tr_tag = tr_tag + "	</td>";
			tr_tag = tr_tag + "</tr>";			
		}
		else {
			datalist.forEach(function(vo,idx,arr2){
				
				console.log(vo);
				//첫번쨰 인수는 배열의 각각의 item 
				//두번쨰 인수는 배열의 index 
				//세번째 인수는 배열 그자체
				tr_tag = tr_tag + "<tr>";
				tr_tag = tr_tag + "	<td>";
				tr_tag = tr_tag + ((data.currentPage-1)*10 + (idx + 1));
				tr_tag = tr_tag + "	</td>";
				tr_tag = tr_tag + "	<td style='text-align:left'>";
				tr_tag = tr_tag + vo.userId;
				tr_tag = tr_tag + "	</td>";
				tr_tag = tr_tag + "	<td style='text-align:left'>";
				tr_tag = tr_tag + vo.userComp;
				tr_tag = tr_tag + "	</td>";				
				tr_tag = tr_tag + "	<td>";
				tr_tag = tr_tag + vo.userCls;
				tr_tag = tr_tag + "	</td>";
				tr_tag = tr_tag + "	<td>";
				tr_tag = tr_tag + vo.newDt;
				tr_tag = tr_tag + "	</td>";
				tr_tag = tr_tag + "	<td>";
				tr_tag = tr_tag + vo.modDt;
				tr_tag = tr_tag + "	</td>";
				tr_tag = tr_tag + "	<td style='text-align:center'>";
				tr_tag = tr_tag + "		<button class='modbutton' data-userid='"+vo.userId+"'><img src='"+__contextPath__+"/resources/image/btn/btn_chagne.gif'></button>";
				tr_tag = tr_tag + "	</td>";
				tr_tag = tr_tag + "	<td style='text-align:center'>";
				tr_tag = tr_tag + "		<button class='delbutton' data-userid='"+vo.userId+"'><img src='"+__contextPath__+"/resources/image/btn/btn_delete.gif'></button>";
				tr_tag = tr_tag + "	</td>";
				tr_tag = tr_tag + "</tr>";
				
			});
		}
		
		
		$("#userlist").html(tr_tag);
	};
	//페이징 핸들러
	var pagingHandler = function(totalCnt, curPage){
		
		totalCnt = totalCnt == 0 ? 1 : totalCnt; 
		
		//보여줄 전체 페이지수
		var totalPageCnt = Math.ceil(totalCnt / 10);
		//보여줄 전체 블럭수
		var totalBlockCnt = Math.ceil(totalPageCnt / 10);
		//현재 블럭
		var curBlock = Math.ceil(curPage / 10);
		//블럭 시작
		var startBlock = ((curBlock-1)*10)+1;
		//블럭 마지막
		var endBlock = curBlock * 10 > totalPageCnt ? totalPageCnt : curBlock * 10;
		
		var first = 1
		
//		var prev = startBlock - 10 < 0 ? startBlock : startBlock - 10;
		var prev = startBlock - 1 == 0 ? startBlock : startBlock - 1;
			
//		var next = endBlock + 10 > totalPageCnt ? totalPageCnt : endBlock + 10
		var next = endBlock + 1 > totalPageCnt ? totalPageCnt : endBlock + 1;
			
		var last = totalPageCnt
		
		console.log("totalCnt : ",totalCnt);
		console.log("curPage  : ",curPage);
		console.log("totalPageCnt : ",totalPageCnt);
		console.log("totalBlockCnt : ",totalBlockCnt);
		console.log("curBlock : ",curBlock);
		console.log("startBlock : ",startBlock);
		console.log("endBlock : ",endBlock);
		
		var strLog = "";
		
		strLog = strLog + first;
		strLog = strLog + " | " + prev;
		for (var i = startBlock; i <= endBlock; i++) {
			strLog = strLog + " | " + i;
		}
		strLog = strLog + " | " + next;
		strLog = strLog + " | " + last;
		
		console.log("strPageLog : ",strLog);
		
		var strPageTag = "<ul class='numbering'><li><a data-page='1'><img src='"+__contextPath__+"/resources/image/btn/btn_front.gif' alt='처음'></a></li>";
		strPageTag += "<li><a data-page='"+prev+"'><img src='"+__contextPath__+"/resources/image/btn/btn_pre.gif' alt='이전'></a></li>";
		for (var i = startBlock; i <= endBlock; i++) {
			if(i == curPage){
				strPageTag += "<li style='margin-top:5px;'><a data-page='"+i+"' class='curpage'>"+i+"</a></li>";
			}
			else {
				strPageTag += "<li style='margin-top:5px;'><a data-page='"+i+"'>"+i+"</a></li>";
			}
		}
		strPageTag +="<li><a data-page='"+next+"'><img src='"+__contextPath__+"/resources/image/btn/btn_nxt.gif' alt='다음'></a></li>";
		strPageTag +="<li><a data-page='"+last+"'><img src='"+__contextPath__+"/resources/image/btn/btn_end.gif' alt='끝'></a></li></ul>";
		
		$("#paginate").html(strPageTag);
	};
	
	//layer popup : 등록/수정 폼
	var userFormPopup = function (){
		$.blockUI({ 
            message: $('#userForm'), 
            css: { 
                top:  ($(window).height() - 500) /2 + 'px', 
                left: ($(window).width() - 300) /2 + 'px', 
                width: '300px',
                cursor: 'auto' 
            } 
        }); 
	};
	
	return {
		userFormPopup : userFormPopup,
		tableHandler : tableHandler,
		pagingHandler : pagingHandler,
	};
};

/********************************************************************************
 * model
 ********************************************************************************/
var UserModel = function (){
	
	var getUser = function (){
		return {
			editflag   : $("#editflag").val(),
			userId     : $("#userId").val(),
			userPw     : $("#userPw").val(),
			userComp    : $("#userComp").val(),
		};
	};
	var setUser = function (vo){
		$("#editflag").val(vo.editflag);
		$("#userId").val(vo.userId);
		$("#userPw").val("");
		$("#userComp").val(vo.userComp);
	};
	
	var setUserInit = function (){
		$("#editflag").val("new");
		$("#userId").val("");
		$("#userPw").val("");
		$("#userComp").val("");
	};
	
	var valicationCheck = function (){
    	var userId = $("#userId").val();
    	var userPw = $("#userPw").val();
    	var userComp = $("#userComp").val();
    	if(userId != "" && userPw != "" && userComp != ""){
    		return true;
    	}
    	return false;
	};
	
	
	return {
		setUser : setUser,
		getUser : getUser,

		setUserInit   : setUserInit,
		valicationCheck : valicationCheck,
	}
};


/********************************************************************************
 * transaction
 ********************************************************************************/
var UserTransaction = function(){

	var regUser = function (param) {
        console.log("saveUser");
        var deferred = $.Deferred();
        try {
            $.ajax({
                url : __contextPath__ + '/user/newItem',
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
    

	var modUser = function (param) {
        console.log("saveUser");
        var deferred = $.Deferred();
        try {
            $.ajax({
                url : __contextPath__ + '/user/modItem',
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
    
  
    
    var delUser = function (param) {
        console.log("deleteUser");

        var deferred = $.Deferred();
        try {
            $.ajax({
                type : "POST",
                url : __contextPath__ + "/user/delItem",
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
        console.log("getUserList");

        var deferred = $.Deferred();
        try {
            $.ajax({
                type : "GET",
                url : __contextPath__ + "/user/getList",
                data : param,
                dataType : "json",
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
    
    var getItem = function (param) {
        console.log("getUserItem");

        var deferred = $.Deferred();
        try {
            $.ajax({
                type : "GET",
                url : __contextPath__ + "/user/getItem",
                data : {
                	"userId" : param,
                },
                dataType : "json",
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
    	regUser     : regUser,
    	modUser     : modUser,
    	delUser     : delUser,
    	getList      : getList,
    	getItem      : getItem,
    }
};