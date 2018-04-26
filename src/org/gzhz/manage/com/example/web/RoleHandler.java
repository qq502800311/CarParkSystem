/**
 * 
 */
package org.gzhz.manage.com.example.web;

import java.util.List;

import javax.annotation.Resource;

import org.gzhz.manage.bean.Parameter;
import org.gzhz.manage.bean.Role;
import org.gzhz.manage.dao.RoleMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月13日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的角色事务类
* @since  
* @return  
*/
@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/role")
public class RoleHandler {
	
	@Resource
	private RoleMapper roleMapper;	//角色接口
	
	/** 
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月14日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  	角色管理页面
	*/
	@RequestMapping("/pageRoleManage.action")
	public ModelAndView pageRoleManage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/zwhJsp/roleManage");		
		return mav;
	}
		
	/** 
	* 查询所有角色
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求（role_name）
	* @since  
	* @return  	角色表信息
	*/
	@RequestMapping(value="/search.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String search(String role_name, int pageNum, int pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		List<Role> roleList = roleMapper.searchAll(role_name);
		PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
		
		Gson gson = new Gson();
		String date = gson.toJson(pageInfo);
		System.out.println("返回全部角色信息:" + date);
		return date;
	}
	
	/** 
	* 增加角色
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求（role_name）
	* @since  
	* @return  	"增加失败"/"增加成功"
	*/
	@RequestMapping(value="/add.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String add(Role role){
		String str = "增加失败";
		//显示查询条件
		System.out.println(role.getRole_name());
		//查询符合条件的用户
		int update = roleMapper.add(role);
		if(update>0) {
			str = "增加成功";
		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 修改角色
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求（role_id,role_name）
	* @since  
	* @return  	"修改失败"/"修改成功"
	*/
	@RequestMapping(value="/updateName.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String updateName(Role role){
		String str = "修改失败";
		//显示查询条件
//		System.out.println(role.getRole_id());
//		System.out.println(role.getRole_name());
		//查询符合条件的用户
		int update = roleMapper.updateName(role);
		if(update>0) {
			str = "修改成功";
		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
	
}
