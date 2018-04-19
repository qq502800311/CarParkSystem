/**
 * 
 */
package org.gzhz.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.gzhz.manage.bean.Menu;
import org.gzhz.manage.bean.MenuTree;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月15日 上午8:21:09 
* @version 1.0 
* @parameter  菜单接口类
* @since  
* @return  
*/
@Repository
public interface MenuMapper {

	//查询所有一级菜单
	public List<Menu> searchFirstMenu();
	
	//查询菜单
	public List<Menu> search(Menu menu);
	
	//增加菜单
	public int add(Menu menu);
	
	//查询菜单重名
	public List<Menu> checkName(Menu menu);
	
	//修改菜单
	public int update(Menu menu);
	
	//查询原生菜单列表
	public List<MenuTree> searchAllMenu();
	
}
