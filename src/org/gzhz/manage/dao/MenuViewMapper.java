/**
 * 
 */
package org.gzhz.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.gzhz.manage.bean.MenuView;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的后台管理菜单接口类
* @since  
* @return  
*/
@Repository
public interface MenuViewMapper {
	
	//查询
	public List<MenuView> search(@Param("emp_id")String emp_id);
}
