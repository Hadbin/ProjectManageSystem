$(function(){
	//线路状态
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=5',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	
    		$(".initlineallstatus").append('<option value="0">全部</option>');
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initlineallstatus").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        		$(".initlinestatus").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
	//线路类型
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=6',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
    		$(".initlinealltype").append('<option value="0">全部</option>');
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initlinealltype").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        		$(".initlinetype").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
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
        url:'getAllInitLineJson.spring',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(d) {
        	var str = "";
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		str+='<option value="'+info.Lineid+'">'+info.Name+'</option>';
//        		$(".initline").append('<option value="'+info.Lineid+'">'+info.Name+'</option>');
//        		$("#plineid").append('<option value="'+info.Lineid+'">'+info.Name+'</option>');
        	}
        	 $(".initline").html(str);
             $(".initline" ).selectpicker('refresh');
        }
    });
	
	//线杆类型
	$.ajax({
        type: "get",
        url:'getPoleTypeJson.spring',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	//var d=data.data;
        	for(var i=0;i<data.length;i++){
        		var info=data[i];
        		$(".initpoletype").append('<option value="'+info.id+'">'+info.caption+'</option>');
        	}
        }
    });
	
	//线杆状态
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=7',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initpolestatus").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
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