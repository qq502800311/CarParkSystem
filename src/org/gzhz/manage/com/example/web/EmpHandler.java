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
import org.gzhz.manage.bean.MenuView;
import org.gzhz.manage.dao.EmpMapper;
import org.gzhz.manage.dao.MenuViewMapper;
import org.gzhz.manage.util.CodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



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
	private MenuViewMapper menuViewMapper;		//后台管理菜单接口
	
	/** 
	* 验证码生成
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月12日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  调用验证码工具，返回验证码流
	*/
	@RequestMapping("/createCode.action")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
					session.setAttribute(newEmp.getEmp_id(), newEmp.getEmp_name());	//记录用户ID，名字
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
	
		
}
