$(function(){
	
	//参数类型
	$.ajax({
        type: "get",
        url:'getAllDicItemJson.spring?typeId=22',
        dataType: "json",
        error: function(request) {
            alert("请求超时，请重试");
        },
        success: function(data) {
        	var d=data.data;
        	for(var i=0;i<d.length;i++){
        		var info=d[i];
        		$(".initsysprmtype").append('<option value="'+info.dicitemid+'">'+info.title+'</option>');
        	}
        }
    });
	
})