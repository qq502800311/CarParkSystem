/**
 * 
 */
package org.gzhz.manage.dao;

import java.util.List;

import org.gzhz.manage.bean.Parameter;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月15日 上午8:21:09 
* @version 1.0 
* @parameter  参数 接口类
* @since  
* @return  
*/
@Repository
public interface ParameterMapper {
	
	//查询参数类型列表
	public List<Parameter> searchParameterType();

	//查询参数列表
	public List<Parameter> search(Parameter parameter);
	
	//增加参数
	public int add(Parameter parameter);
	
	//修改参数
	public int update(Parameter parameter);
}
