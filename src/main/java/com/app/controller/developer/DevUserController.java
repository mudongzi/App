package com.app.controller.developer;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.AppCategory;
import com.app.pojo.AppInfo;
import com.app.pojo.AppVersion;
import com.app.pojo.DataDictionary;
import com.app.pojo.DevUser;
import com.app.service.AppCategoryService;
import com.app.service.AppInFoService;
import com.app.service.AppVersionService;
import com.app.service.DataDictionaryService;
import com.app.service.DevUserService;
/**
 * 
* @Title: DevUserController 
* @Description:   
* @author xudong  
* @date 2019年1月18日
 */
@Controller
@RequestMapping("/dev")
public class DevUserController {
	@Resource
	private DevUserService devUserService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	@Resource
	private AppInFoService appInFoService;
	@Resource
	private	 AppVersionService appVersionService;
	/**
	 * 开发者进入登录
	 * @Title: devUserToLogin  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("login")
public String devUserToLogin(DevUser devUser) {
		System.out.println("进入开发者登录");
		System.out.println("跳转到登录页面");
		return "devlogin";
	}
	/**
	 * 开发者登录
	 * @Title: devUserLogin  
	 * @Description:   
	 * @param devUser
	 * @return
	 */
	@RequestMapping("dologin")
	public String devUserLogin(DevUser devUser,HttpSession session,Model model) {
		if(((devUser.getDevCode().trim() !=null)&&(devUser.getDevPassword().trim() != null))
			&&(!"".equals(devUser.getDevCode().trim())||!"".equals(devUser.getDevPassword().trim())) ){
		DevUser devUser2 = devUserService.selectDevUser(devUser);
			//判断是否登录成功
			if(devUser2 !=null) {
				session.setAttribute("devUserSession",devUser2 );
				return "developer/main";
			}
			System.out.println(devUser.getDevCode());
			System.out.println(devUser.getDevPassword()+"密码");
			//登录错误
			model.addAttribute("error","账户或密码错误");
			return "devlogin";
		}
		//登录为空
		model.addAttribute("error","账户密码不能为空");
		return "devlogin";
	}
	
	/**
	 * 开发者退出登录
	 * @Title: devUserLogout  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("logout")
	public String devUserLogout(HttpSession session) {
		//将保存的用户设为空值
		session.setAttribute("devUserSession", "");
		//重定向至登录方法、或者登录页面
		//return "redirect:/dev/login.do";
		return "devlogin";
	}
	/**
	 * APP信息管理维护
	 * @Title: toFlatformAppList  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("flatformAppList")
	public String toFlatformAppList (Model model
		 ) {
		//设置APP状态值
		List<DataDictionary> statusList = dataDictionaryService.getListDataDictionary("APP_STATUS");
		model.addAttribute("statusList", statusList);
		//设置所属平台
		List<DataDictionary> flatFormList = dataDictionaryService.getListDataDictionary("APP_FLATFORM");
		model.addAttribute("flatFormList", flatFormList);
		
		//设置首次进入一级分类的值
		List<AppCategory> categoryLevel1List = appCategoryService.findListAppCategory(0);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		//设置首次进入二级分类的值
		//得到是1的二级分类
		List<AppCategory> listAppCategory1 = appCategoryService.findListAppCategory(1);
		//得到是1的二级分类
		List<AppCategory> listAppCategory2 = appCategoryService.findListAppCategory(2);
		//设置二级分类所有值
		List<AppCategory> categoryLevel2List = new ArrayList<AppCategory>();
		for (AppCategory appCategory : listAppCategory2) {
			categoryLevel2List.add(appCategory);
		}
		for (AppCategory appCategory : listAppCategory1) {
			categoryLevel2List.add(appCategory);
		}
		model.addAttribute("categoryLevel2List", categoryLevel2List);
		return "developer/appinfolist";
	}
	
	
	/**
	 * 根据页面数据模糊查询
	 * @Title: getListAppInFo  
	 * @Description:   
	 * @param session
	 * @param softwareName
	 * @param status
	 * @param flatformId
	 * @param categoryLevel1
	 * @param categoryLevel2
	 * @param categoryLevel3
	 * @return
	 */
	@RequestMapping("list")
	public String getListAppInFo(HttpSession session,Model model,
			@RequestParam(value="querySoftwareName") String softwareName,
			@RequestParam(value="queryStatus" ,required=false) Integer status,
			@RequestParam(value="queryFlatformId")	Integer flatformId,
			@RequestParam(value="queryCategoryLevel1") Integer categoryLevel1,
			@RequestParam(value="queryCategoryLevel2") Integer categoryLevel2,
			@RequestParam(value="queryCategoryLevel3" ,defaultValue="0") Integer categoryLevel3 ) {
		AppInfo appInfo = new AppInfo();
		//将页面传输值设置到appInfo
		appInfo.setCategoryLevel1(categoryLevel1);
		appInfo.setCategoryLevel2(categoryLevel2);
		appInfo.setCategoryLevel3(categoryLevel3);
		appInfo.setSoftwareName(softwareName);
		appInfo.setStatus(status);
		appInfo.setFlatformId(flatformId);
		//查询符合条件的所有值
		List<AppInfo> appInfoList = appInFoService.findAllListAppInfo(appInfo);
		//将值保存至session中下次进来直接覆盖
		session.setAttribute("appInfoList", appInfoList);
		model.addAttribute("appInfoList", appInfoList);
		return "redirect:/dev/flatformAppList.do";
	}
	/**
	 * 跳转添加APP信息页面
	 * @Title: addAppInfo  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("addAppInFo")
	public String addAppInfo() {
		
		return "developer/appinfoadd";
	}
	/**
	 * 添加appInFo信息
	 * 没有拿到服务器图片地址
	 * @Title: appInFoAddSave  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("appInFoAddSave")
	public String appInFoAddSave(	@RequestParam(value="a_logoPicPath", required=false)MultipartFile filePact,
			AppInfo appInfo,HttpSession session,Model model, HttpServletRequest request)throws Exception {
		String path="F://eclipse//APP//src//main//webapp//statics//images/";
		//上传图片，设置图片名称防止重复
		String picName = UUID.randomUUID().toString();
		//获取文件名
		String oriName = filePact.getOriginalFilename();
		//获得图片后缀名
		String extName = oriName.substring(oriName.lastIndexOf("."));
		//判断是否为图片
		if((!extName.equalsIgnoreCase(".jpg")) && (!extName.equalsIgnoreCase(".png")) &&
		   (!extName.equalsIgnoreCase(".jepg")) && (!extName.equalsIgnoreCase(".pneg"))) {
			model.addAttribute("fileUploadError", "上传文件不是图片");
			return "developer/appinfoadd";	
		}
		//判断是否上传图片过大
		if(filePact.getSize() > 5000000) {
			model.addAttribute("fileUploadError", "上传图片过大"+filePact.getSize());
			return "developer/appinfoadd";	
		}
		
		//开始上传
		filePact.transferTo(new File(path+picName+extName));
		//设置图片的路径表示的是文件名+后缀名 url路径
		appInfo.setLogoPicPath(picName+extName);
		//设置当前服务器访问路径
		//appInfo.setLogoLocPath(session.getServletContext().getRealPath("/webapp/WEB-INF/img/")+picName+extName);
		//设置状态码
		appInfo.setStatus(Integer.valueOf(1));
		appInfo.setDevId(((DevUser) session.getAttribute("devUserSession")).getId());
		appInfo.setCreationDate(new Date());
		appInfo.setCreatedBy(((DevUser)session.getAttribute("devUserSession")).getId());
		int num = appInFoService.addAppIFo(appInfo);
		if(num==0) {
			model.addAttribute("fileUploadError", "上传失败");
		}
		return "redirect:/dev/flatformAppList.do";
		
	}
	/**
	 * 进入修改APPInfo基本信息页面
	 * @Title: appInfoModify  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("appInfoModify")
	public String appInfoModify(Integer id,Model model) {
		System.out.println(id);
		AppInfo appInfo = appInFoService.findOneAppInFoById(id);
		model.addAttribute("appInfo",  appInfo);
		return "developer/appinfomodify";
	}
	/**
	 * 
	 * @Title: appInfoModifySave  
	 * @Description: 保存更新  
	 * @return
	 */
	@RequestMapping("appinfomodifysave")
	public String appInfoModifySave(@RequestParam(value="attach", required=false)MultipartFile filePact,
			AppInfo appInfo,HttpSession session,Model model) throws Exception
	{
		String path="F://eclipse//APP//src//main//webapp//statics//images/";
		//上传图片，设置图片名称防止重复
		String picName = UUID.randomUUID().toString();
		//获取文件名
		String oriName = filePact.getOriginalFilename();
		//获得图片后缀名
		String extName = oriName.substring(oriName.lastIndexOf("."));
		//判断是否为图片
		if((!extName.equalsIgnoreCase(".jpg")) && (!extName.equalsIgnoreCase(".png")) &&
		   (!extName.equalsIgnoreCase(".jepg")) && (!extName.equalsIgnoreCase(".pneg"))) {
			model.addAttribute("fileUploadError", "上传文件不是图片");
			return "developer/appinfoadd";	
		}
		//判断是否上传图片过大
		if(filePact.getSize() > 5000000) {
			model.addAttribute("fileUploadError", "上传图片过大"+filePact.getSize());
			return "developer/appinfoadd";	
		}
		//开始上传文件
		filePact.transferTo(new File(path+picName+extName));
		//设置图片的路径表示的是文件名+后缀名 url路径
		appInfo.setLogoPicPath(picName+extName);
		//appInfo.setStatus(Integer.valueOf(1));
		appInfo.setDevId(((DevUser) session.getAttribute("devUserSession")).getId());
		appInfo.setModifyDate(new Date());
		appInfo.setModifyBy(((DevUser)session.getAttribute("devUserSession")).getId());
		int num = appInFoService.modifyAppInfo(appInfo);
		if(num==0) {
			model.addAttribute("fileUploadError", "修改失败");
			return "developer/appinfolist";
		}
		System.out.println("修改成功");
		return "redirect:/dev/flatformAppList.do";
	}
	/**
	 * 进入添加版本信息页面
	 * @Title: showAppVersion  
	 * @Description:   
	 * @param appId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("appversionadd")
	public String showAppVersion(@RequestParam(value="id",required=false) Integer appId,Model model,HttpSession session) {
		session.setAttribute("appId", appId);
		System.out.println("appid="+appId);
		List<AppVersion> appVersionList = appVersionService.findAllAppVersionById(appId);
		for (AppVersion appVersion : appVersionList) {
			System.out.println(appVersion);
		}
		model.addAttribute("appVersionList", appVersionList);
		
		return "developer/appversionadd";
	}
	/**
	 * 添加版本信息
	 * @Title: addAppVersion  
	 * @Description:   
	 * @param filePact
	 * @param appVersion
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addVersionSave")
	public String  addAppVersion(@RequestParam(value="a_downloadLink",required=false)MultipartFile filePact
			,AppVersion appVersion,Model model,HttpSession session ) throws Exception{
		System.out.println("添加斑斑信息"+appVersion);
		//上传文件路径
		String path="F://eclipse//APP//src//main//webapp//statics//fonts/";
		//得到上传文件名
		String oriName = filePact.getOriginalFilename();
		//得到上传文件的后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));
		//判断上传文件是否符合规定
		//if( extName != "" ) {}
		//上传文件
		filePact.transferTo(new File(path+oriName));
		//设置上传路径
		appVersion.setApkLocPath(path);
		//设置
		appVersion.setApkFileName(oriName);
		//设置新增时间、人
		appVersion.setCreationDate(new Date());
		appVersion.setCreatedBy(((DevUser)session.getAttribute("devUserSession")).getId());
		appVersion.setAppId((int)session.getAttribute("appId"));
		appVersion.setDownloadLink(path+oriName);
		//添加版本信息
		System.out.println("添加斑斑信息1"+appVersion);
		int num = appVersionService.addAppVersion(appVersion);
		if(num < 0) {
			model.addAttribute("fileUploadError", "添加失败");
			//再次进入添加版本信息页面
			return "developer/appversionadd";
		}
		return "redirect:/dev/flatformAppList.do";
	}
	/**
	 * 进入修改版本信息页面
	 * @Title: appVersionModify  
	 * @Description:   
	 * @param appId
	 * @param vid
	 * @param model
	 * @return
	 */
	@RequestMapping("appVersionModify")
	public String appVersionModify(@RequestParam(value="aid",required=false) int appId, int vid,Model model){
		System.out.println("修改本案版信息");
		List<AppVersion> appVersionList = appVersionService.findAllAppVersionById(appId);
		for (AppVersion appVersion : appVersionList) {
			System.out.println(appVersion);
		}
		System.out.println("vid="+ vid);
		AppVersion appVersion = appVersionService.findAppVersionById(vid);
		model.addAttribute("appVersionList", appVersionList);
		model.addAttribute("appVersion", appVersion);
		return "developer/appversionmodify";
	}
	/**
	 * 修改并保存app版本信息
	 * @Title: appversionModifySave  
	 * @Description:   
	 * @param appVersion
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("appversionModifySave")
	public String appversionModifySave(AppVersion appVersion,HttpSession session,Model model) {
		System.out.println(appVersion);
		appVersion.setModifyBy(((DevUser)session.getAttribute("devUserSession")).getId());
		appVersion.setModifyDate(new Date());
		int num = appVersionService.modityAppVersion(appVersion);
		if(num <1) {
			model.addAttribute("fileUploadError", "修改失败");
		}
		return "redirect:/dev/flatformAppList.do";
	}
	/**
	 * 查看app所有的信息
	 * @Title: lookAppInFo  
	 * @Description:   
	 * @return
	 */
	@RequestMapping("lookAppInFoView")
	public String lookAppInFo(@RequestParam(value="appInfoid",required=false)Integer id,Model model) {
		System.out.println(id);
		AppInfo appInFo = appInFoService.findOneAppInFoById(id);
		model.addAttribute("appInfo", appInFo);
		List<AppVersion> appVersionList = appVersionService.findAllAppVersionById(id);
		model.addAttribute("appVersionList", appVersionList);
		return "/developer/appinfoview";
	}
	
}
