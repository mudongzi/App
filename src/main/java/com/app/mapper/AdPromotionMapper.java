package com.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.app.pojo.AdPromotion;


/** 
 * 
 * @author  姓名 工号
 * @version  [版本号, 2019年1月16日]
 * @see  [相关类/方法]
 * @since  广告信息基本类持久层接口
 */
public interface AdPromotionMapper {
	/**
	 * 
	 * 根据id查找具体的广告对象
	 * @param id 广告id
	 * @return 广告对象
	 * @see 
	 */
	@Select("select * from ad_promotion where id = #{id}")
	AdPromotion getAdPromotion(Integer id);	
	int insertAdPromotion(AdPromotion adPromotion);
	/**
	 * 
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param adPromotion
	 * @return
	 * @see 获得广告，根据条件
	 */
	@SelectProvider(method = "selectParamSql", type = com.app.mapper.AdPromotionDynaSqlProvider.class)
	List<AdPromotion> getAdPromotionByparam(AdPromotion adPromotion);
	/**
	 * 
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param adPromotion
	 * @return 根据条件插入，主键必须
	 * @see 根据条件插入，主键必须
	 */
	@InsertProvider(method="insertParamSql",type=com.app.mapper.AdPromotionDynaSqlProvider.class)
	int insertParamAdPromotion(AdPromotion adPromotion);
	/**
	 * 修改功能
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param adPromotion
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@UpdateProvider(method="updateParamSql",type=com.app.mapper.AdPromotionDynaSqlProvider.class)
	int updateParamAdpromotion(AdPromotion adPromotion);
	/**
	 * 根据id 删除广告
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param id
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@Delete("delete from ad_promotion where id = #{id}")
	int deleAdpromotionById(Integer id);
}
