package com.app.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.app.pojo.AdPromotion;

/** 
 * <一句话功能简述> 
 * <功能详细描述> 
 * 
 * @author  姓名 工号
 * @version  [版本号, 2019年1月16日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]Adpromotion动态sql类 :广告类动态sql
 */
public class AdPromotionDynaSqlProvider {
/** 	
 * <一句话功能简述>
 * <功能详细描述>
 * @param adpromotion
 * @return 广告类的动态sql的语句
 * @see [类、类#方法、类#成员] 产生广告类的动态sql的语句
 */
 public String insertParamSql(AdPromotion adpromotion) {
	 return new SQL() {
			{
			INSERT_INTO("ad_promotion");
			if(adpromotion.getId()!=null) {
				VALUES("id","#{id}");
			}
			if(adpromotion.getAppId()!=null) {
				VALUES("appId","#{appId}");
			}
			if(adpromotion.getAdPicPath()!=null) {
				VALUES("adPicPath","#{adPicPath}");
			}
			if(adpromotion.getAdPV()!=null) {
				VALUES("adPV","#{adPV}");
			}
			if(adpromotion.getCarouselPosition()!=null) {
				VALUES("carouselPosition","#{carouselPosition}");
			}
			if(adpromotion.getStartTime()!=null) {
				VALUES("startTime","#{startTime}");
			}
			if(adpromotion.getEndTime()!=null) {
				VALUES("endTime","#{endTime}");
			}
			if(adpromotion.getCreatedBy()!=null) {
				VALUES("createdBy","#{createdBy}");
			}
			if(adpromotion.getCreationDate()!=null) {
				VALUES("creationDate","#{creationDate}");
			}
			if(adpromotion.getModifyBy()!=null) {
				VALUES("modifyBy","#{modifyBy}");
			}
			if(adpromotion.getModifyDate()!=null) {
				VALUES("modifyDate","#{modifyDate}");
			}		
		 }	
			
		}.toString();	 
 }
 /**
  * 
  * <一句话功能简述>
  * <功能详细描述>
  * @param adpromotion
  * @return 根据条件查询广告的sql
  * @see [类、类#方法、类#成员] 产生根据条件查询广告的sql
  */
 public String selectParamSql(AdPromotion adpromotion) {
		
		return new SQL() {
			{
				SELECT("*") ;
				FROM("ad_promotion");
						
			}
		}.toString();
	}
 /**
  * 
  * <一句话功能简述>
  * <功能详细描述>
  * @param adpromotion
  * @return
  * @see  根据id修改广告动态sql AdPromotion
  */
 public String updateParamSql(AdPromotion adpromotion)
 {
     return new SQL()
     {
         {
             UPDATE("ad_promotion");      
            
            
             WHERE ("id = #{id}");
            
         }
         
     }.toString();
 }
}
