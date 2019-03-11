package com.app.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
* @Title: BackendUserController 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */
@Controller
@RequestMapping("/manager")
public class BackendUserController {
	/**
	 * 跳转到管理者登录页面
	 * @Title: DedvUserLogin  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("login")
	public String DedvUserLogin() {
		
		return "backend/main";
	}
}
