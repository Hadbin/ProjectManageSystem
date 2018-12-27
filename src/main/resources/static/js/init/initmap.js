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
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
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
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
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
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		
        		if(usertype==2){
        			if(userunit==info.unitid){
        				$(".initunit").append('<option value="'+info.unitid+'">'+info.title+'</option>');
        			}
        		}else{
        			$(".initunit").append('<option value="'+info.unitid+'">'+info.title+'</option>');
        		}
        		
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
        	$(".initline").append('<option value="0">不属于线路</option>');
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initline").append('<option value="'+info.Lineid+'">'+info.Name+'</option>');
        	}
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
})