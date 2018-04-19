/**
 * 
 */
package org.gzhz.manage.com.example.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;

import org.gzhz.manage.bean.MenuTree;
import org.gzhz.manage.bean.RoleMenu;
import org.gzhz.manage.dao.MenuMapper;
import org.gzhz.manage.dao.RoleMenuMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月17日 上午8:21:09 
* @version 1.0 
* @parameter  权限类
* @since  
* @return  
*/
@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/authority")
public class AuthorityHandler {
	
	@Resource
	private MenuMapper menuMapper; //菜单接口
	
	@Resource
	private RoleMenuMapper roleMenuMapper; //角色-菜单 接口

	/** 
	* 跳转权限修改界面
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月17日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  权限修改界面
	*/
	@RequestMapping("/pageAuthorityManage.action")
	public ModelAndView pageAuthorityManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/zwhJsp/authorityManage");
		
		return mav;	
	}
	
	/** 
	* 查询原生菜单列表
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月17日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  菜单列表
	*/
	@RequestMapping(value="/searchAllMenu.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String  searchAllMenu() {
		//查询符合条件的菜单
		List<MenuTree> menulist = menuMapper.searchAllMenu();
		Gson gson = new Gson();
		String date = gson.toJson(menulist);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 查询原生菜单列表
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月17日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  菜单列表
	*/
	@RequestMapping(value="/searchRoleMenu.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String searchRoleMenu(String role_id) {
		//显示查询条件
//		System.out.println(role_id);
		//查询符合条件的菜单
		List<RoleMenu> menulist = roleMenuMapper.searchRoleMenu(role_id);
		Gson gson = new Gson();
		String date = gson.toJson(menulist);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 查询原生菜单列表
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月17日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  菜单列表
	*/
	@RequestMapping(value="/updateRoleMenu.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String updateRoleMenu(String role_id, String str) {
		String msg = "修改失败";
		//显示查询条件
		System.out.println(role_id);
		System.out.println(str);
		//查询该角色拥有的菜单
		List<RoleMenu> list = roleMenuMapper.searchRoleMenu(role_id);
		
		
		//------------------------------------备份  开始------------------------------//			
		
		//----------------------设置断点-------------------------------//
		
		//删除
		int update = roleMenuMapper.deleteRoleMenu(role_id);
		//判断删除条数是否正确
		if(update == list.size()) {
			
			
//			List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
			if(str.equals("")) {
				msg = "修改成功";
			}else{
				
			
			
			for(int i=0;i<str.split(",").length;i++) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setRole_id(Integer.parseInt(role_id));
				roleMenu.setMenu_id(Integer.parseInt(str.split(",")[i]));
				
				//备用
				roleMenuMapper.updateRoleMenu1(roleMenu);
				//
				
//				System.out.println(Integer.parseInt(role_id));
//				System.out.println(Integer.parseInt(str.split(",")[i]));
//				roleMenuList.add(roleMenu);
//			}
//			int update1 = roleMenuMapper.updateRoleMenu(roleMenuList);
//			if(update1 == roleMenuList.size()) {
//				msg = "修改成功";
				//----------------------提交事务-------------------------------//
			}
			msg = "修改成功";
		}
		}else {
			//----------------------回滚-------------------------------//
		}
		
//------------------------------------备份  结束------------------------------//	

//		//删除
//		int update = roleMenuMapper.deleteRoleMenu(role_id);
//		//判断删除条数是否正确
//		if(update == list.size()) {
//		
//			try {	
//				for(int i=0;i<str.split(",").length;i++) {
//					RoleMenu roleMenu = new RoleMenu();
//					roleMenu.setRole_id(Integer.parseInt(role_id));
//					roleMenu.setMenu_id(Integer.parseInt(str.split(",")[i]));
//					
//					msg = "修改成功";
//					roleMenuMapper.updateRoleMenu1(roleMenu);
//				}
//			}catch(Exception e){
//				//
//			}
//		}else {
//			
//		}
		
		Gson gson = new Gson();
		String date = gson.toJson(msg);
		System.out.println("返回：" + date);
		return date;
	}
	
}
