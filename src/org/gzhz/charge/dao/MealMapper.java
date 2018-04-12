package org.gzhz.charge.dao;

import java.util.List;
import org.gzhz.charge.bean.Meal;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月12日 上午10:59:49 
* @version 1.03
* @parameter  
* @since  
* @return  List<CarportUserMsg>
*/

@Repository
public interface MealMapper {
	
	public List<Meal> findAllMeal();

}
