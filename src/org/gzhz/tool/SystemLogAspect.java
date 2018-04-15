package org.gzhz.tool;


import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;



/**
 * @author zx
 * @desc 切点类 
 */

@Aspect 		//自动代理，从配置文件获得
@Component				//用于注入，IOC反向控制生成类
public class SystemLogAspect {
//	@Autowired  
//	private  HttpServletRequest request; 
    //注入Service用于把日志保存数据库  
//    @Resource  //这里我用resource注解
//    private SystemLogService systemLogService;  

    
    //Controller层切点  
	//第一个星代表包上层的包，第二个..*代表包下面不论多少层的类,第三个*(..)第二个条件中的任意方法任意参数
//    @Pointcut("execution (* org.great.aoplog..*.*(..))")  
//    @Pointcut("execution (* org.gzhz..*.*(..))") 
	@Pointcut("execution (org.gzhz.tool.MyDateUnitl.*(..)") 
    public  void controllerAspect() {  
    }  
    
    /** 
     * 前置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */ 
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("==========执行车辆进入前置通知===============");
        
    }    
    
    /** 
     * 后置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */  
    @After("controllerAspect()")  
    public  void after(JoinPoint joinPoint) throws Throwable{
    	
//    	Admin admin = (Admin) ServletActionContext.getRequest().getSession().getAttribute("admin");
//    	HttpServletRequest request = (HttpServletRequest) (RequestContextHolder.getRequestAttributes());
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//				.getRequest();
//    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
		// 读取session中的用户
//		Admin admin = (Admin) session.getAttribute("admin");
//		 请求的IP
//		String ip = request.getRemoteAddr();
        
         try {  
//            System.out.println("登录的管理员名称："+admin.getA_name());
//            System.out.println("登录的管理员密码："+admin.getA_psw());
//            System.out.println("登录的管理员IP："+ip);
            String targetName = joinPoint.getTarget().getClass().getName();  
            String methodName = joinPoint.getSignature().getName();  
            Object[] arguments = joinPoint.getArgs();  
            Class targetClass = Class.forName(targetName);  
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            String abc = "";
             for (Method method : methods) {  
                 if (method.getName().equals(methodName)) {  
                    Class[] clazzs = method.getParameterTypes();  
                     if (clazzs.length == arguments.length) {  
                         operationType = method.getAnnotation(Log.class).operationType();
                         operationName = method.getAnnotation(Log.class).operationName();
                         abc = method.getAnnotation(Log.class).abc();
                         break;  
                    }  
                }  
            }
            //*========控制台输出=========*//  
            System.out.println("=====执行车辆进入后置通知开始=====");  
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            System.out.println("方法描述:" + operationName); 
            System.out.println("abc:" + abc); 
            System.out.println("=====执行车辆进入后置通知结束=====");  
        }  catch (Exception e) {  
            //记录本地异常日志  
            
            
            throw e;
        }  
    } 

}