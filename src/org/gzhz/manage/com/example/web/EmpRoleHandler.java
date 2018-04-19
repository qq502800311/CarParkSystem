/**
 * 
 */
package org.gzhz.manage.com.example.web;

import javax.annotation.Resource;

import org.gzhz.manage.bean.EmpRole;
import org.gzhz.manage.dao.EmpRoleMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月13日 上午8:21:09 
* @version 1.0 
* @parameter  用户-角色 事务类
* @since  
* @return  
*/
@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/empRole")
public class EmpRoleHandler {
	
	@Resource
	private EmpRoleMapper empRoleMapper;	//用户-角色接口
	
	/** 
	* 增加用户的角色
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  EmpRole(emp_id,role_id)
	* @since  
	* @return  	true/false
	*/
	@RequestMapping(value="/add.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String add(EmpRole empRole){
		String str = "增加失败";
		int update = empRoleMapper.add(empRole);
		if(update>0) {
			str = "增加成功";
		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 删除用户的角色
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  EmpRole(emp_id,role_id)
	* @since  
	* @return  	String("删除失败"/"删除成功")
	*/
	@RequestMapping(value="/delete.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String delete(EmpRole empRole){
		String str = "删除失败";
		int update = empRoleMapper.delete(empRole);
		if(update>0) {
			str = "删除成功";
		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
	
}
