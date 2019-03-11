$(function(){  
	//动态加载所属平台列表
	$.ajax({
		type:"POST",//请求类型
		url:"http://127.0.0.1:8080/APP/jsonDyna/datadictionarylist.do",//请求的url
		data:null,//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		contentType : "application/json;charset=UTF-8",
		success:function(data){//data：返回数据（json对象）
			$("#flatformId").html("");
			var options = "<option value=\"\">--请选择--</option>";
			for(var i = 0; i < data.length; i++){
				options += "<option value=\""+data[i].valueId+"\">"+data[i].valueName+"</option>";
			}
			$("#flatformId").html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载平台列表失败！");
		}
	});  
	//动态加载一级分类列表
	//var id =0;
	$.ajax({
		type:"POST",//请求类型
		url:"http://127.0.0.1:8080/APP/jsonDyna/categoryLevel1List.do",//请求的url
		data:0,//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		contentType : "application/json;charset=UTF-8",
		success:function(data){//data：返回数据（json对象）
			$("#categoryLevel1").html("");
			var options = "<option value=\"\">--请选择--</option>";
			for(var i = 0; i < data.length; i++){
				options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
			}
			$("#categoryLevel1").html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载一级分类列表失败！");
		}
	});  
	//动态加载二级分类列表
	$("#categoryLevel1").change(function(){
		var categoryLevel1 = $("#categoryLevel1").val();
		if(categoryLevel1 != '' && categoryLevel1 != null){
			$.ajax({
				type:"POST",//请求类型
				url:"http://127.0.0.1:8080/APP/jsonDyna/categorylevellist.do",//请求的url
				data:categoryLevel1,//请求参数
				dataType:"json",//ajax接口（请求url）返回的数据类型
				contentType : "application/json;charset=UTF-8",
				success:function(data){//data：返回数据（json对象）
					$("#categoryLevel2").html("");
					var options = "<option value=\"\">--请选择--</option>";
					for(var i = 0; i < data.length; i++){
						options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
					}
					$("#categoryLevel2").html(options);
				},
				error:function(data){//当访问时候，404，500 等非200的错误状态码
					alert("加载二级分类失败！");
				}
			});
		}else{
			$("#categoryLevel2").html("");
			var options = "<option value=\"\">--请选择--</option>";
			$("#categoryLevel2").html(options);
		}
		$("#categoryLevel3").html("");
		var options = "<option value=\"\">--请选择--</option>";
		$("#categoryLevel3").html(options);
	});
	//动态加载三级分类列表
	$("#categoryLevel2").change(function(){
		var categoryLevel2 = $("#categoryLevel2").val();
		if(categoryLevel2 != '' && categoryLevel2 != null){
			$.ajax({
				type:"POST",//请求类型
				url:"http://127.0.0.1:8080/APP/jsonDyna/categorylevellist.do",//请求的url
				data:categoryLevel2,//请求参数
				contentType : "application/json;charset=UTF-8",
				dataType:"json",//ajax接口（请求url）返回的数据类型
				success:function(data){//data：返回数据（json对象）
					$("#categoryLevel3").html("");
					var options = "<option value=\"\">--请选择--</option>";
					for(var i = 0; i < data.length; i++){
						options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
					}
					$("#categoryLevel3").html(options);
				},
				error:function(data){//当访问时候，404，500 等非200的错误状态码
					alert("加载三级分类失败！");
				}
			});
		}else{
			$("#categoryLevel3").html("");
			var options = "<option value=\"\">--请选择--</option>";
			$("#categoryLevel3").html(options);
		}
	});
	
	$("#back").on("click",function(){
		window.location.href = "../dev/flatformAppList.do";
	});
	
	$("#APKName").bind("blur",function(){
		//ajax后台验证--APKName是否已存在
		$.ajax({
			type:"POST",//请求类型
			url:"http://127.0.0.1:8080/APP/jsonDyna/apkexist.do",//请求的url
			data:$("#APKName").val(),//请求参数
			//dataType:"json",//ajax接口（请求url）返回的数据类型
			contentType : "application/json;charset=UTF-8",
			success:function(data){
				alert(data);
				//data：返回数据（json对象）
				if(data == "empty"){//参数APKName为空，错误提示
					alert("APKName为不能为空！");
				}else if(data == "exist"){//账号不可用，错误提示
					alert("该APKName已存在，不能使用！");
				}else if(data == "noexist"){//账号可用，正确提示
					alert("该APKName可以使用！");
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("请求错误！");
			}
		});
	});

});
      
      
      