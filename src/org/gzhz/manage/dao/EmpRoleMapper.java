/**
 * 
 */
package org.gzhz.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.gzhz.manage.bean.EmpRole;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的用户-角色关系接口类
* @since  
* @return  
*/
@Repository
public interface EmpRoleMapper {

	//查询角色
	public List<EmpRole> search();
	
	//增加用户的角色
	public int add(EmpRole empRole);
	
	//删除用户的角色
	public int delete(EmpRole empRole);
}
