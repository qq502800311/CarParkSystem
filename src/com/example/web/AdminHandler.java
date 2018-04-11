package com.example.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.User;
import dao.UserMapper;

//-----------------------验证码部分开始--------------------------------//
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

//-----------------------验证码部分结束--------------------------------//


@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/admin")
public class AdminHandler {
	//----------------------验证码部分变量开始----------------------------//
	private int width = 180;// 定义图片的width
    private int height = 40;// 定义图片的height
    private int codeCount = 4;// 定义图片上显示验证码的个数
    private int xx = 30;
    private int fontHeight = 30;
    private int codeY = 25;
    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
  //----------------------验证码部分变量结束----------------------------//
	@Resource
	private UserMapper userMapper;
	//localhost:8080/2018-04-08-mySpringMVC/admin/hello.action
	@RequestMapping("/hello.action")
	public ModelAndView hello(){
		System.out.println("hello方法被调用了...");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		return mav;
	}
	
	//localhost:8080/2018-04-08-mySpringMVC/index.jsp
	@RequestMapping(value="/userinfo.action")
	public ModelAndView userinfo(HttpServletRequest request, 
			@RequestParam(value="username", required=true, defaultValue="empty")String name, 			
			@RequestParam(value="password", required=true, defaultValue="empty")String password){
		System.out.println(name + ":" + password);
		System.out.println("userinfo方法被调用了...");
	
		//DAO 
		//
		HttpSession session = request.getSession();
		session.setAttribute("user", new User(name, password));
		
		//
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("userinfo");
		mav.setViewName("user_search");
		return mav;
	}
	
	
	
	
	
	
	//localhost:8080/2018-04-08-mySpringMVC/index.jsp
	@RequestMapping(value="/userinfo2.action")
	public String userinfo2(HttpServletRequest request, 
			User user,String code){
		String resultStr = "haha";
		System.out.println(user);
		System.out.println("userinfo2方法被调用了...");
		System.out.println(user.getUser_name());
		System.out.println(user.getUser_psw());
//		MyEmpUnitl meu = new MyEmpUnitl();
//		User user2 = meu.loginEmp(user.getUser_name(), user.getUser_psw());
//		if (user2 != null) {
//			resultStr = "user_search";
//		}
		User nuser = new User(user.getUser_name(),user.getUser_psw());
		User nuser2 = userMapper.loginUser(nuser);
		System.out.println(nuser2.getUser_name());
		HttpSession session = request.getSession();
//		session.setAttribute("code", user);
		
//		String code=request.getParameter("code");
		System.out.println("输入的验证码：" + code);
		System.out.println("本来的验证码：" + session.getAttribute("code").toString());
		   if (!(code.equalsIgnoreCase(session.getAttribute("code").toString()))) {  //忽略验证码大小写  
		            System.out.println("验证码错误!");
		   }
		
		if(nuser2!=null){
			resultStr = "userinfo";
		}
		List<User> ulist = new ArrayList<User>();
		
		
		request.setAttribute("UL", ulist);
		
		
		return resultStr; //可通过String类型返回信息
	}
	
	
	
	
	//localhost:8080/2018-04-08-mySpringMVC/index.jsp
	@RequestMapping(value="/userinfo3.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody User userinfo3(String username, String password){
		System.out.println(username + ":" + password);
		System.out.println("userinfo3方法被调用了...");
		return new User(username, password);
	}
	
	//localhost:8080/2018-04-08-mySpringMVC/index.jsp
	@RequestMapping(value="/userinfo4.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
//	public @ResponseBody User userinfo4(@RequestBody User user){
	public @ResponseBody User userinfo4(User user){
		System.out.println(user);
		System.out.println("userinfo4方法被调用了...");
		return user;
	}
	
	//localhost:8080/2018-04-08-mySpringMVC/index.jsp
	@RequestMapping(value="/fileact.action", method=RequestMethod.POST)
	public ModelAndView fileact(MultipartFile fileact){
		String filename = fileact.getOriginalFilename();
		System.out.println("获取到的文件名:" + filename);
		try {
			fileact.transferTo(new File("D:/" + filename));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userinfo");
		return mav;
	}
	
	//--------------------验证码部分函数开始-----------------------------//
	 @RequestMapping("/code.action")
	    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	        // 定义图像buffer
	        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        Graphics gd = buffImg.getGraphics();
	        // 创建一个随机数生成器类
	        Random random = new Random();
	        // 将图像填充为白色
	        gd.setColor(Color.WHITE);
	        gd.fillRect(0, 0, width, height);
	        // 创建字体，字体的大小应该根据图片的高度来定。
	        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
	        // 设置字体。
	        gd.setFont(font);
	        // 画边框。
	        gd.setColor(Color.BLACK);
	        gd.drawRect(0, 0, width - 1, height - 1);
	        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
	        gd.setColor(Color.BLACK);
	        for (int i = 0; i < 40; i++) {
	            int x = random.nextInt(width);
	            int y = random.nextInt(height);
	            int xl = random.nextInt(12);
	            int yl = random.nextInt(12);
	            gd.drawLine(x, y, x + xl, y + yl);
	        }
	        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
	        StringBuffer randomCode = new StringBuffer();
	        int red = 0, green = 0, blue = 0;
	        // 随机产生codeCount数字的验证码。
	        for (int i = 0; i < codeCount; i++) {
	            // 得到随机产生的验证码数字。
	            String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length-1)]);
	            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
	            red = random.nextInt(255);
	            green = random.nextInt(255);
	            blue = random.nextInt(255);
	            // 用随机产生的颜色将验证码绘制到图像中。
	            gd.setColor(new Color(red, green, blue));
	            gd.drawString(code, (i + 1) * xx, codeY);
	            // 将产生的四个随机数组合在一起。
	            randomCode.append(code);
	        }
	        // 将四位数字的验证码保存到Session中。
	        HttpSession session = req.getSession();
	        System.out.println("生成验证码："+randomCode);
	        session.setAttribute("code", randomCode.toString());
	        // 禁止图像缓存。
	        resp.setHeader("Pragma", "no-cache");
	        resp.setHeader("Cache-Control", "no-cache");
	        resp.setDateHeader("Expires", 0);
	        resp.setContentType("image/jpeg");
	        // 将图像输出到Servlet输出流中。
	        ServletOutputStream sos = resp.getOutputStream();
	        ImageIO.write(buffImg, "jpeg", sos);
	        sos.close();
	    }

//--------------------验证码部分函数结束-----------------------------//
	
}
