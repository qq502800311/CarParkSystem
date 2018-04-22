/**
 * 
 */
package org.gzhz.manage.com.example.web;

import java.util.List;

import javax.annotation.Resource;

import org.gzhz.manage.bean.Emp;
import org.gzhz.manage.bean.Menu;
import org.gzhz.manage.bean.Parameter;
import org.gzhz.manage.dao.ParameterMapper;
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
* @date 创建时间：2018年4月16日 上午8:21:09 
* @version 1.0 
* @parameter  参数 事务类
* @since  
* @return  
*/
@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/parameter")
public class ParameterHandler {
	
	@Resource
	private ParameterMapper parameterMapper; //参数接口
	
	/** 
	* 跳转参数管理界面
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月16日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  参数管理界面
	*/
	@RequestMapping("/pageParameterManage.action")
	public ModelAndView pageParameterManage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/zwhJsp/parameterManage");		
		return mav;
	}
	
	/** 
	* 获取参数类型列表
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月16日 上午8:21:09 
	* @version 1.0 
	* @parameter  URL请求
	* @since  
	* @return  	参数类型列表
	*/
	@RequestMapping(value="/searchParameterType.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String searchParameterType(){
		List<Parameter> parameterTypelist = parameterMapper.searchParameterType();
		Gson gson = new Gson();
		String date = gson.toJson(parameterTypelist);
		System.out.println("返回：" + date);
		return date;
	}
	
	
	/** 
	* 获取参数列表
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月16日 上午8:21:09 
	* @version 1.0 
	* @parameter  Parameter(parameter_id, parameter_pid, parameter_name)
	* @since  
	* @return  	参数列表
	*/
	@RequestMapping(value="/search.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String search(Parameter parameter, int pageNum, int pageSize){
		//显示查询条件
//		System.out.println(parameter.getParameter_id());
//		System.out.println(parameter.getParameter_name());
//		System.out.println(parameter.getParameter_pid());
		//查询符合条件的菜单
		PageHelper.startPage(pageNum, pageSize);
		List<Parameter> parameterList = parameterMapper.search(parameter);
		PageInfo<Parameter> pageInfo = new PageInfo<Parameter>(parameterList);
		
		Gson gson = new Gson();
		String date = gson.toJson(pageInfo);
		System.out.println("返回（包含分页信息）" + date);
		return date;
	}
	
	/** 
	* 增加参数
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月16日 上午8:21:09 
	* @version 1.0 
	* @parameter  Parameter(parameter_pid, parameter_name)
	* @since  
	* @return  	"增加失败"/"增加成功"
	*/
	@RequestMapping(value="/add.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String add(Parameter parameter){
		String str = "增加失败";
		//显示查询条件
//		System.out.println(parameter.getParameter_name());
//		System.out.println(parameter.getParameter_pid());
		//增加参数
		int update = parameterMapper.add(parameter);
		if(update>0) {
			str = "增加成功";
		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
	
	/** 
	* 修改参数
	* @author  作者 E-mail: 郑伟豪
	* @date 创建时间：2018年4月16日 上午8:21:09 
	* @version 1.0 
	* @parameter  Parameter(parameter_pid, parameter_name)
	* @since  
	* @return  	"修改失败"/"修改成功"
	*/
	@RequestMapping(value="/update.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String update(Parameter parameter){
		String str = "修改失败";
		//显示查询条件
		System.out.println(parameter.getParameter_id());
		System.out.println(parameter.getParameter_name());
		System.out.println(parameter.getParameter_pid());
//		//查询参数重名
//		List<Parameter> parameterList = parameterMapper.checkName(parameter);
//		if(parameterList.size()!=0) {
//			str = "修改失败，参数名重复";
//		}else {
			//修改参数
			int update = parameterMapper.update(parameter);
			if(update>0) {
				str = "修改成功";
			}
//		}
		Gson gson = new Gson();
		String date = gson.toJson(str);
		System.out.println("返回：" + date);
		return date;
	}
}
