/**
 * 
 */
package org.gzhz.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.gzhz.manage.bean.RoleMenu;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月13日 上午8:21:09 
* @version 1.0 
* @parameter  角色-菜单接口类
* @since  
* @return  
*/
@Repository
public interface RoleMenuMapper {

	//根据角色ID查询对应菜单关系
	public List<RoleMenu> searchRoleMenu(@Param("role_id")String role_id);
	
	//删除角色对应菜单关系
	public int deleteRoleMenu(@Param("role_id")String role_id);
	
	//增加新的角色菜单关系
	public int updateRoleMenu(List<RoleMenu> roleMenuList);
	
	//增加新的角色菜单关系(备用)
	public int updateRoleMenu1(RoleMenu roleMenu);
}
