/*#############图片处理开始##############*/
	
	var detaildata={"polename":[],"unit":[],"hlname":[]};
	var ImageSlide = function(){};
        //缩略图部分
        ImageSlide.prototype = {

            constructor: ImageSlide,
            self: this,

            currentIndex : 0, //正在详细展示的图片索引
            outIndex : 0, //剩余未被展示的缩略图数
            maxOutIndex : 0, //剩余未被展示的缩略图数的最大值
            inIndex : 8, //最多可以一次显示几张缩略图
            thrumWidth : 110, //每一个缩略图的宽度

            
            //添加图像函数
            addImage : function (imgobj, url, desc, date,otherdata) {
            	var thrumsHtml = '<li><img src="' + path+ '' + imgobj[url] + '" /><em>' + imgobj[date] + '</em></li>',
                	detailsHtml = '<li><img src="' + path+ '' + imgobj[url] + '" /><em>' + imgobj[date] +
              					  '</em><div class="detailInfo"><div class="col-lg-12"><div class="input-group bottom-10px"><span class="input-group-addon">线杆名称</span><input readOnly style="background:#ffffff" class="form-control" value="'+otherdata.polename+'"/></div></div>'+
                                  '<div class="col-lg-12"><label><strong>搭挂线路</strong></label><textarea readOnly  rows="2" class="form-control">' + otherdata.hlname + '</textarea></div>'+
                                  '<div class="col-lg-12"><label><strong>搭挂单位</strong></label><textarea readOnly  rows="2" class="form-control">' + otherdata.unit + '</textarea></div>'+
                                  '<div class="col-lg-12"><label><strong>缺陷描述</strong></label><textarea readOnly  rows="3" class="form-control">' + imgobj[desc] + '</textarea></div>'+
                                  '<a class="btn btn-info btn-sm yt" href="' + path+ '' + imgobj[url] + '" target="_blank">查看原图</a>   <button class="btn btn-info btn-sm yt" type="button" onclick="delPhoto('+imgobj.PhotoId+')">删除照片</button>'+
                                  '</div></li>';
                $("#image-thrums ul").append(thrumsHtml);
                $("#image-details ul").append(detailsHtml);

                //......
                self.maxOutIndex = $("#image-thrums ul li").length - self.inIndex;
            },

            //删除所有图片
            deleteAllImages : function () {
                $("#image-details ul").children("li").remove();
                $("#image-thrums ul").children("li").remove();
            }
            
        };


        var initImgs = function (imgs,url,desc,date,id,detaildata1) {

            var self = new ImageSlide();

            var otherdata=JSON.parse(detaildata1);
            //alert(detaildata1);
            //激活当前图片
            var selectImage = function () {
                var currentImageDom = $("#image-details li").eq(self.currentIndex),
                    currentThrumDom = $("#image-thrums li").eq(self.currentIndex);
                currentThrumDom.addClass("thrum-active").siblings().removeClass("thrum-active");
                currentImageDom.addClass("image-active").siblings().removeClass("image-active");
                //currentImageDom.children("div:first ").fadeIn().parent("li").siblings().children("div:first").fadeOut();
                //currentImageDom.children("div:last ").slideDown().parent("li").siblings().children("div:last").slideUp()
                console.log("当前节点-----" + self.currentIndex);
            };

            //处理缩略图的点击事件函数
            var handleImageClick = function () {
                $("#image-thrums ul").delegate("li", "click", function () {
                	//alert(imgs[self.currentIndex][url]);
                    $("#image-thrums ul img").eq(self.currentIndex).attr("src", path+imgs[self.currentIndex][url]);
                	self.currentIndex = $(this).index();
                	if(!$("#image-upload").hasClass('disabled')){
                    	$("#image-details ul img").eq(self.currentIndex).attr("src",path+imgs[self.currentIndex][url]);
                	}
                    selectImage();
                });
            };

            //处理上一张下一张的点击事件函数
            var handleLeftAndRightClick = function () {

                $("#image-details ul button").on("click", function () {
                    var imgLength = $("#image-thrums ul li").length;
                    if ($(this).attr("id") == "image-prev") {
                        self.currentIndex--;
                        if (self.currentIndex < 0) {
                            self.currentIndex = imgLength - 1;
                            self.outIndex = self.maxOutIndex + 1;
                            console.log(self.outIndex);
                        }

                        //处理滚动条滚动事件
                        if (self.outIndex != 0) self.outIndex--;
                    } else if ($(this).attr("id") == "image-next") {
                        self.currentIndex++;
                        if (self.currentIndex > imgLength - 1) {
                            self.currentIndex = 0;
                            self.maxOutIndex = self.outIndex;
                            self.outIndex = 0;
                        }

                        //处理滚动条滚动事件
                        if ((self.currentIndex + 2) * self.thrumWidth > $("#image-thrums").width()) self.outIndex++;
                    }
                    selectImage();
                    $("#image-thrums").getNiceScroll(0).doScrollLeft(self.outIndex * self.thrumWidth);
                });
            };

            //删除当前激活状态图片对象,并激活其他图片
            var deleteImage = function () {
                console.log("正在删除节点---"+self.currentIndex);
                var liLength = $("#image-thrums ul li").length;
                $("#image-details ul li").eq(self.currentIndex).remove();
                $("#image-thrums ul li").eq(self.currentIndex).remove();
                //self.currentIndex--;
                var maxIndex = $("#image-thrums ul li").length;
                if ($("#image-thrums ul li").index() == "-1") {
            
                } else if (self.currentIndex == liLength - 1) {
                    self.currentIndex--;  
                } 
                selectImage();
            };


            //其他初始化
            var othersInit = function() {
                $("#image-details ul li").eq(self.currentIndex).addClass("image-active");
                $("#image-thrums ul li").eq(self.currentIndex).addClass("thrum-active");
       
                //得到单个缩略图像所在的li的宽度
                self.thrumWidth = parseInt($("#image-thrums ul img").width()) + 2 * parseInt($("#image-thrums ul li")
                    .css("margin-left"));
                //......
                self.inIndex = Math.round((parseInt($("body").width()) * 0.6 - 70) / self.thrumWidth);

                $("#image-thrums").niceScroll({
                    cursorcolor: "#65cea7",
                    cursorwidth: '6',
                    cursorborderradius: '0px',
                    background: '#424f63',
                    spacebarenabled: false,
                    cursorborder: '0',
                    zindex: '1000',
                    autohidemode: "hidden"
                });
                $("#image-thrums").getNiceScroll().resize();
            };

                //初始化前清空所有
                self.deleteAllImages();
                
                for (var i = 0, l = imgs.length; i < l; i++) {
                	var od={};
                	if(otherdata.polename[i]==null){od.polename="";}
                	else{od.polename=otherdata.polename[i];}
                	
                	if(otherdata.unit[i]==null){od.unit="";}
                	else{od.unit=otherdata.unit[i];}
                	
                	if(otherdata.hlname[i]==null){od.hlname="";}
                	else{od.hlname=otherdata.hlname[i];}
                	
                    self.addImage(imgs[i],url,desc,date,od);
                }
                othersInit();
                handleImageClick();
                handleLeftAndRightClick();
            }

       
		function photoHangLine(id){
			detaildata.unit=[];
			detaildata.polename=[];
			detaildata.hlname=[];
			$.ajax({
		        type: "POST",
		        url:'getPhotoByHangLine.spring?hanglineid='+id,
		        dataType: "json",
		        error: function(request) {
		            alert("请求超时，请重试");
		        },
		        success: function(data) {
		           if(data.length>0){
		        	  imgs=data;
		        	  for(var i=0;i<data.length;i++){
		        		  detaildata.unit.push(data[i].unitname);
		        		  detaildata.polename.push(data[i].Name);
		        		  detaildata.hlname.push(data[i].hlname);
		        	  }
		        	  initImgs(imgs,'Directory','photodsc','createTime','d',JSON.stringify(detaildata));
		           }else{
		        	   imgs=[{"Name":"","createTime":"","photochk":"","photodsc":"空","Directory":"/PatrolPhotos/notpic.jpg"}];
		        	   initImgs(imgs,'Directory','photodsc','createTime','d',JSON.stringify(detaildata));
		           }
		        }
		    });
			 $("#manage-bug").modal('show');
		}
		
		function photoHangdtl(id){
			$.ajax({
		        type: "POST",
		        url:'getPhotoByHangDtl.spring?hangdtlid='+id,
		        dataType: "json",
		        error: function(request) {
		            alert("请求超时，请重试");
		        },
		        success: function(data) {
		           if(data.length>0){
		        	  imgs=data;
		        	  for(var i=0;i<data.length;i++){
		        		  detaildata.unit.push(data[i].unitname);
		        		  detaildata.polename.push(data[i].Name);
		        		  detaildata.hlname.push(data[i].hlname);
		        	  }
		        	  initImgs(imgs,'Directory','photodsc','createTime','d',JSON.stringify(detaildata));
		           }else{
		        	   imgs=[{"Name":"","createTime":"","photochk":"","photodsc":"空","Directory":"/PatrolPhotos/notpic.jpg"}];
		        	   initImgs(imgs,'Directory','photodsc','createTime','d',JSON.stringify(detaildata));
		           }
		        }
		    });
			 $("#manage-bug").modal('show');
		}
		
		function delPhoto(imgid){
			//alert(imgid);
			$.confirm({
			    title: '系统提示!',
			    content: '您确定要删除该信息吗？',
			    type:'red',
			    buttons: {
			        ok: {
			            text: '确认',
			            btnClass: 'btn-primary',
			            action: function(){
			            	$.ajax({
			    		        type: "Get",
			    		        url:'deletePhotoById.spring?photoid='+imgid,
			    		        dataType: "text",
			    		        error: function(request) {
			    		            alert("请求超时，请重试");
			    		        },
			    		        success: function(data) {
			    		           if(data.length>0){
			    		        	   $("#manage-bug").modal('hide');
			    		           }
			    		        }
			    		    });
			            }
			        },
			        cancel: {
			            text: '取消',
			            btnClass: 'btn-primary',
			            action: function(){
			                // button action.
			            }
			        },
			     }
			});
		}
        /*#############图片处理结束##############*/