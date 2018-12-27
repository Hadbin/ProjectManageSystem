$(function(){

	//单位
	$.ajax({
        type: "get",
        url:'getAllUnitJson.spring',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
    		$(".initallunit").append('<option value="0">全部</option>');
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initallunit").append('<option value="'+info.unitid+'">'+info.title+'</option>');
        		$(".initunit").append('<option value="'+info.unitid+'">'+info.title+'</option>');
        	}
        }
    });
	
	//所属线路
	$.ajax({
        type: "get",
        url:'getInitHangLine.spring',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(d) {
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".inithangline").append('<option value="'+info.HangLineId+'">'+info.Name+'</option>');
        	}
        }
    });
	
	
	//搭挂线杆
	$.ajax({
        type: "get",
        url:'getAllInitPoleJson.spring',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(d) {
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		if(info.Name==undefined||info.Name==""){
            		$(".initpole").append('<option value="'+info.PoleId+'">未命名</option>');
        		}else{
            		$(".initpole").append('<option value="'+info.PoleId+'">'+info.Name+'</option>');
        		}
        	}
        }
    });
	
	//搭挂线路状态
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=10',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".inithangstatus").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
	//搭挂线路类型
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=11',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".inithangtype").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
	//搭挂详情状态
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=12',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".inithdstatus").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
	//用户状态
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=15',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".inituserstatus").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
	//用户类型
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=14',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initusertype").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
	//部门
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=21',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initdept").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
})