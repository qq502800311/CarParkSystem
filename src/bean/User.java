package bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月29日 下午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的用户类
* @since  
* @return  
*/
@Component
public class User extends Object{
	private Integer user_id;
	private String  user_name;
	private String  user_psw;
	private Integer user_point;
	private String  user_grade;
	private String  user_avatarURL;
	private String  user_type;
	private String  user_sex;
	private String  user_education;
	private String  user_career;
	private String  user_phone;
	private String  user_Email;
	
	private String  user_date;
	private Integer user_dl_number;
	private Integer user_up_number;
	private Integer user_enable;//用户启用禁用状态，1表示启用
	
	
	public User() {
		super();
	}
	
	

	public User(String user_name, String user_psw) {
		super();
		this.user_name = user_name;
		this.user_psw = user_psw;
	}



	public Integer getUser_id() {
		
		
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_psw() {
		return user_psw;
	}

	public void setUser_psw(String user_psw) {
		this.user_psw = user_psw;
	}

	public Integer getUser_point() {
		return user_point;
	}

	public void setUser_point(Integer user_point) {
		this.user_point = user_point;
	}

	public String getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}

	public String getUser_avatarURL() {
		return user_avatarURL;
	}

	public void setUser_avatarURL(String user_avatarURL) {
		this.user_avatarURL = user_avatarURL;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_education() {
		return user_education;
	}

	public void setUser_education(String user_education) {
		this.user_education = user_education;
	}

	public String getUser_career() {
		return user_career;
	}

	public void setUser_career(String user_career) {
		this.user_career = user_career;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_Email() {
		return user_Email;
	}

	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}

	public String getUser_date() {
		return user_date;
	}

	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}

	public Integer getUser_dl_number() {
		return user_dl_number;
	}

	public void setUser_dl_number(Integer user_dl_number) {
		this.user_dl_number = user_dl_number;
	}

	public Integer getUser_up_number() {
		return user_up_number;
	}

	public void setUser_up_number(Integer user_up_number) {
		this.user_up_number = user_up_number;
	}

	public Integer getUser_enable() {
		return user_enable;
	}

	public void setUser_enable(Integer user_enable) {
		this.user_enable = user_enable;
	}
	
	
}
