/**
 * 
 */
package org.gzhz.manage.com.example.web;

import java.util.List;

import javax.annotation.Resource;

import org.gzhz.manage.bean.Menu;
import org.gzhz.manage.bean.Role;
import org.gzhz.manage.dao.MenuMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月15日 上午8:21:09 
* @version 1.0 
* @parameter  菜单 事务类
* @since  
* @return  
*/
@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/menu")
public class MenuHandler {
	
	@Resource
	private MenuMapper menuMapper; //菜单接口

	/** 
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月15日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  	菜单管理页面
	*/
	@RequestMapping("/pageMenuManage.action")
	public ModelAndView pageRoleManage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/zwhJsp/menuManage");		
		return mav;
	}
	
	/** 
	* 获取第一级菜单
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月15日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  	第一级菜单
	*/
	@RequestMapping(value="/searchFirstMenu.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String searchFirstMenu(){
		List<Menu> menulist = menuMapper.searchFirstMenu();
		Gson gson = new Gson();
		String date = gson.toJson(menulist);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 获取菜单
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月15日 上午8:21:09 
	* @version 1.0 
	* @parameter  Menu(menu_name, menu_pid)
	* @since  
	* @return  	菜单列表
	*/
	@RequestMapping(value="/search.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String search(Menu menu){
		//显示查询条件
//		System.out.println(menu.getMenu_id());
//		System.out.println(menu.getMenu_name());
//		System.out.println(menu.getMenu_pid());
		//查询符合条件的菜单
		List<Menu> menulist = menuMapper.search(menu);
		Gson gson = new Gson();
		String date = gson.toJson(menulist);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 增加菜单
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月15日 上午8:21:09 
	* @version 1.0 
	* @parameter  Menu(menu_name, menu_pid, menu_url)
	* @since  
	* @return  	"增加成功"/"增加失败"
	*/
	@RequestMapping(value="/add.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String add(Menu menu){
		String str = "增加失败";
		//显示查询条件
//		System.out.println(menu.getMenu_name());
//		System.out.println(menu.getMenu_pid());
//		System.out.println(menu.getMenu_url());
		//查询菜单重名
		List<Menu> menuList = menuMapper.checkName(menu);
		if(menuList.size()!=0) {
			str = "增加失败，菜单名重复";
		}else {
			//增加菜单
			int update = menuMapper.add(menu);
			if(update>0) {
				 str = "增加成功";
			}
		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 修改菜单
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月15日 上午8:21:09 
	* @version 1.0 
	* @parameter  Menu(menu_id, menu_name, menu_pid, menu_url,)
	* @since  
	* @return  	"修改成功"/"修改失败"
	*/
	@RequestMapping(value="/update.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String update(Menu menu){
		String str = "修改失败";
		//显示查询条件
//		System.out.println(menu.getMenu_id());
//		System.out.println(menu.getMenu_pid());
//		System.out.println(menu.getMenu_name());
//		System.out.println(menu.getMenu_url());
		//查询菜单重名
		List<Menu> menuList = menuMapper.checkName(menu);
		if(menuList.size()!=0) {
			str = "修改失败，菜单名重复";
		}else {
			//修改菜单
			int update = menuMapper.update(menu);
			if(update>0) {
				str = "修改成功";
			}
		}
		
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
}
