/**
 * 
 */
package org.gzhz.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.gzhz.manage.bean.Role;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月13日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的角色接口类
* @since  
* @return  
*/
@Repository
public interface RoleMapper {

	//查询角色
	public List<Role> searchAll(@Param("role_name")String role_name);
	
	//增加角色
	public int add(Role role);
	
	//修改角色名称
	public int updateName(Role role);
	
}
