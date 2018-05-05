package org.gzhz.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.gzhz.manage.bean.Emp;
import org.springframework.stereotype.Repository;



/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的用户接口类
* @since  
* @return  
*/
@Repository
public interface EmpMapper {
	
	//登录验证
	public List<Emp> checkLogin(@Param("emp_id")String emp_id, @Param("emp_pwd")String emp_pwd);
	
	//查询
	public List<Emp> search(@Param("emp_id")String emp_id, @Param("emp_name")String emp_name, @Param("emp_status")String emp_status);

	//查询全部信息（包含角色）
	public List<Emp> searchInfo(@Param("emp_id")String emp_id, @Param("emp_name")String emp_name, @Param("emp_status")String emp_status);
	
	//修改用户状态
	public int updateStatus(@Param("emp_id")String emp_id, @Param("emp_status")String emp_status);
	
	//重置用户密码
	public int updatePwd(@Param("emp_id")String emp_id);
	
	//查询目前员工ID最大的员工信息
	public Emp searchEmp();
	
	//增加员工
	public int add(Emp emp);
	
	
}
