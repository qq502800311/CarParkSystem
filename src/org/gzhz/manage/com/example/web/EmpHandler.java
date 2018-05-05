/**
 * 
 */
package org.gzhz.manage.com.example.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gzhz.manage.bean.Emp;
import org.gzhz.manage.bean.EmpRole;
import org.gzhz.manage.bean.MenuView;
import org.gzhz.manage.dao.EmpMapper;
import org.gzhz.manage.dao.EmpRoleMapper;
import org.gzhz.manage.dao.MenuViewMapper;
import org.gzhz.manage.util.CodeUtil;
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
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的用户事务类
* @since  
* @return  
*/
@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/emp")
public class EmpHandler {
	
	@Resource
	private EmpMapper empMapper;	//用户类接口
	@Resource
	private EmpRoleMapper empRoleMapper;	//用户角色-角色类接口
	@Resource
	private MenuViewMapper menuViewMapper;		//后台管理菜单接口
	
	/** 
	* 验证码生成
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月12日 上午8:21:09 
	* @version 	1.0 
	* @parameter  URL请求
	* @since  
	* @return  调用验证码工具，返回验证码流
	*/
	@RequestMapping("/createCode.action")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        CodeUtil.getCode(request, response);
    }
	
	
	/** 
	* 跳转登录界面
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月12日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  用户登录界面
	*/
	@RequestMapping("/pageLogin.action")
	public ModelAndView pageLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/zwhJsp/empLogin");
		
		return mav;	
	}
	
	/** 
	* 登录判断
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月12日 上午8:21:09 
	* @version 1.0 
	* @parameter  用户对象（帐号、密码），验证码
	* @since  
	* @return  用户登录界面/后台界面
	*/
	@RequestMapping("/login.action")
	public ModelAndView login(HttpServletRequest request, Emp emp ,String code) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		//判断验证码
		if(code.equals(session.getAttribute("code"))) {
			//验证码正确
			List<Emp> empList = empMapper.checkLogin(emp.getEmp_id(), emp.getEmp_pwd());	//登录验证
			//非空引用，非空数据
			if(empList != null && !empList.isEmpty()) {
				Emp newEmp = empList.get(0);	//获得用户对象
				if(newEmp.getEmp_status().equals("启用")) {
					//登录成功
					mav.setViewName("/zwhJsp/houTai");	//跳转目标为后台页面
					session.setAttribute("emp_id", newEmp.getEmp_id());	//记录用户ID
					session.setAttribute("emp_name", newEmp.getEmp_name());	//记录用户名称
					//获取用户 菜单，写入session					
//					HashMap<String, Object> menuMap = new HashMap<String, Object>();
					//用户对应的菜单视图
					System.out.println(newEmp.getEmp_id());
					List<MenuView> menuList = menuViewMapper.search(newEmp.getEmp_id());
					//（一级菜单名，对应的二级菜单对象）								
					HashMap<String, ArrayList<MenuView>> menu = new HashMap<String, ArrayList<MenuView>>();
					for(Object obj:menuList) {
						MenuView vw = (MenuView)obj;
						if(!menu.containsKey(vw.getFirst_menu_name())) {
							menu.put(vw.getFirst_menu_name(), new ArrayList<MenuView>());
						}
						((ArrayList<MenuView>)(menu.get(vw.getFirst_menu_name()))).add(vw);
					}
					session.setAttribute("menu", menu);
					
					
				}else {
					//登录失败，返回用户名，错误提示
					mav.setViewName("/zwhJsp/empLogin");
					mav.addObject("emp_id", emp.getEmp_id());
					mav.addObject("errorMsg", "帐号被禁用");
				}
			}else {
				//登录失败，返回用户名，错误提示
				mav.setViewName("/zwhJsp/empLogin");
				mav.addObject("emp_id", emp.getEmp_id());
				mav.addObject("errorMsg", "帐号或密码错误");
			}		
		}else {
			//登录失败，返回用户名，错误提示
			mav.setViewName("/zwhJsp/empLogin");
			mav.addObject("emp_id", emp.getEmp_id());
			mav.addObject("errorMsg", "验证码错误");
		}
		return mav;	
	}

	/** 
	* 跳转人员管理界面
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  人员管理界面
	*/
	@RequestMapping("/pageEmpManage.action")
	public ModelAndView pageEmpManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/zwhJsp/empManage");		
		return mav;
	}
	
	/** 
	* 人员查询
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  查询条件（用户ID，用户名，用户状态）
	* @since  
	* @return  	用户信息
	*/
	@RequestMapping(value="/search.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String search(String emp_id, String emp_name, String emp_status, int pageNum, int pageSize){
		//显示查询条件
//		System.out.println(emp_id);
//		System.out.println(emp_name);
//		System.out.println(emp_status);
		//查询符合条件的用户
		PageHelper.startPage(pageNum, pageSize);
		List<Emp> empList = empMapper.searchInfo(emp_id, emp_name, emp_status);
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(empList);
//		System.out.println("pageInfo:" + pageInfo);
		
		Gson gson = new Gson();
		String date = gson.toJson(pageInfo);
		System.out.println("返回（包含分页信息）：" + date);
		return date;
	}
	
	/** 
	* 更改用户状态
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  查询条件（用户ID，用户状态）
	* @since  
	* @return  	String("失败"/"禁用成功""启用成功")
	*/
	@RequestMapping(value="/updateStatus.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String updateStatus(String emp_id, String emp_status){
		String str = "失败";
		//显示查询条件
//		System.out.println(emp_id);
//		System.out.println(emp_status);
		//查询符合条件的用户
		int update = empMapper.updateStatus(emp_id, emp_status);
		if(update>0) {
			if(emp_status.equals("启用")) {
				str = "禁用成功";
			}else {
				str = "启用成功";
			}
		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 重置用户密码
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月13日 上午8:21:09 
	* @version 1.0 
	* @parameter  查询条件（用户ID）
	* @since  
	* @return  	String("重置失败"/"重置失败")
	*/
	@RequestMapping(value="/updatePwd.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String updatePwd(String emp_id){
		String str = "重置失败";
		//显示查询条件
//		System.out.println(emp_id);
		//查询符合条件的用户
		int update = empMapper.updatePwd(emp_id);
		if(update>0) {
			str = "重置成功";
		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 增加员工
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年5月5日 上午8:21:09 
	* @version 1.0 
	* @parameter  用户名、角色ID
	* @since  
	* @return  	String("新增成功"/"新增失败")
	*/
	@RequestMapping(value="/add.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String add(String emp_name, String role_id){
		String str = "新增失败";
		//显示查询条件
		System.out.println(emp_name);
		System.out.println(role_id);
		//查询ID最大的的用户
		String newEmpID = "";
		Emp emp = empMapper.searchEmp();		
		if(emp != null) {
			//计算新增用户ID
			String maxID = emp.getEmp_id();
			String newID = maxID.substring(3);
			String num = "" + (Integer.parseInt(newID) + 1);
			while(num.length()<4) {
				num = "0" + num;
			}			
			newEmpID = "EM" + num;			
		}else {
			newEmpID = "EM0001";
		}
		
		//新增用户信息
		Emp newEmp = new Emp(newEmpID, emp_name, "123456", "启用");
		int update = empMapper.add(newEmp);
		if(update > 0) {
			//新增角色信息
			EmpRole empRole = new EmpRole(0, newEmpID, Integer.parseInt(role_id));
			int a = empRoleMapper.add(empRole);
			if(a > 0) {
				str = "新增成功";
			}
		}
		
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
}
