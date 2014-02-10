/**
 * 
 */
$(function(){
	 $("#focusedInput").change(
				function(){					
					var userName = $("#focusedInput").val();
					if(!($.trim(userName))){
						 $("#focusedInput").val("");
						 $("#focusedInput").focus();
						alert("用户名不能为空");
					}else{
						var param ={"userInfo.username":userName};
						$.post(g_ctx + "/user/hasUser.action", param, function(res){
							if(res){
								$("#focusedInput").val("");
								 $("#focusedInput").focus();							 
								alert("用户名已经存在，请重新输入！");
							}
						});
					}
				});
	
	 $("#rePwd").blur(function(){
		var pwd = $("#pwd").val();
		var rePwd =  $("#rePwd").val();
		if(rePwd){
			if(rePwd!=pwd){
				 $("#rePwd").val("");
				 $("#rePwd").focus();
				alert("两次输入密码不一致！");
			}
	 }
	});
 });