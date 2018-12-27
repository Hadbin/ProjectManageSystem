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
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initunit").append('<option value="'+info.unitid+'">'+info.title+'</option>');
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