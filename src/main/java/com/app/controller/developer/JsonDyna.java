package com.app.controller.developer;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pojo.AppCategory;
import com.app.pojo.AppInfo;
import com.app.pojo.DataDictionary;
import com.app.pojo.DevUser;
import com.app.service.AppCategoryService;
import com.app.service.AppInFoService;
import com.app.service.DataDictionaryService;
/**
 * 该类做与ajax交互用
* @Title: JsonDyna 
* @Description:   
* @author xudong  
* @date 2019年1月18日
 */
@Controller
@RequestMapping("/jsonDyna")
public class JsonDyna {
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	@Resource
	private AppInFoService appInFoService;
	/**
	 * 在添加页面里动态取一级值
	 * @Title: Json1  
	 * @Description:   
	 * @param parentId
	 * @return
	 */
	@RequestMapping("categoryLevel1List")
	public @ResponseBody List<AppCategory> Json1(){
		System.out.println("加载1级");
		List<AppCategory> categoryLevel1List = appCategoryService.findListAppCategory(0);
		return categoryLevel1List;
	}
	
	/**
	 * 二级三级分类取值
	 * @Title: Json  
	 * @Description:   
	 * @param appCategory
	 * @return
	 */
	@RequestMapping("categorylevellist")	
	public  @ResponseBody List<AppCategory> Json(@RequestBody Integer id){
		System.out.println("jinlai");
		if(id==null||"".equals(id)) {
			List<AppCategory> categoryLevel2List = appCategoryService.findListAppCategoryById(id);
		}
		System.out.println("打印"+id);
		List<AppCategory> categoryLevel2List = appCategoryService.findListAppCategoryById(id);
		return  categoryLevel2List;
	}	
	/**
	 * 交互所属平台
	 * @Title: datadictionarylist  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("datadictionarylist")
	public @ResponseBody List<DataDictionary> datadictionarylist(){
		List<DataDictionary> flatFormList = dataDictionaryService.getListDataDictionary("APP_FLATFORM");
		return flatFormList;
	}
	/**
	 * 交互是否存在相同aPKName
	 * @Title: apkexist  
	 * @Description:   
	 * @param aPKName
	 * @return
	 */
	@RequestMapping("apkexist")
	public @ResponseBody String  apkExist(@RequestBody String aPKName) {
		System.out.println(aPKName);
		AppInfo appInfo = appInFoService.findAppInFoByInfo(aPKName);
		System.out.println(appInfo);
		String aPKName1 = "noexist";
		if(aPKName.trim() ==null) {
			aPKName1 ="empty";
		}
		if(appInfo !=null) {
			aPKName1 ="exist";
		}
		return aPKName1;
	}
	/**
	 * 
	 * @Title: appVersionList  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("deleteApp")
	public @ResponseBody String appVersionList(@RequestBody Integer id ) {
		String data= "true" ;
		System.out.println(id);
		int num = appInFoService.removeAppInFo(id);
		if(num < 1) {
			data = "false";
		}
		return data;
	}
	/**
	 * app上架下架
	 * @Title: openSal  
	 * @Description:   
	 * @param pid
	 * @return
	 */
	@RequestMapping("openSal")
	public @ResponseBody String sale(@RequestBody Integer pid,HttpSession session) {
		Map<String, Object> map = new  HashMap<String, Object>();
		System.out.println("pid"+pid);
		AppInfo appInfo = appInFoService.findOneAppInFoById(pid);
		System.out.println(appInfo.getStatus());
		appInfo.setId(pid);
		//表示现在是下架状态需要做上架
		if(appInfo.getStatus() ==5) {
			map.put("errorCode", 0);
			map.put("resultMsg", "success");
			appInfo.setStatus(4);
			appInfo.setModifyDate(new Date());
			appInfo.setOnSaleDate(new Date());
			appInfo.setModifyBy(((DevUser) session.getAttribute("devUserSession")).getId());
			int num = appInFoService.modifyAppInfo(appInfo);
			
		}else if(appInfo.getStatus() ==4) {
			map.put("errorCode", 0);
			map.put("resultMsg", "success");
			//表示需要做下架
			appInfo.setStatus(5);
			appInfo.setOffSaleDate(new Date());
			appInfo.setModifyDate(new Date());
			appInfo.setModifyBy(((DevUser) session.getAttribute("devUserSession")).getId());
			int num = appInFoService.modifyAppInfo(appInfo);
			
		}
		return "";
	}
}
