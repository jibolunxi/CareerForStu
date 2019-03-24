package domain;

public class Student {
	private int id;
	private int uid;
	private String name;
	private int sex;
	private String birthday;
	private String telphone;
	private String email;
	private int college_id;
	private String college_name;
	private int dept_id;
	private String dept_name;
	private String major_name;
	private String edu;
	private String description;
	private String resume_photo;
	private String qq;
	private String wxewm;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	
	public String getResume_photo() {
		return resume_photo;
	}
	public void setResume_photo(String resume_photo) {
		this.resume_photo = resume_photo;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWxewm() {
		return wxewm;
	}
	public void setWxewm(String wxewm) {
		this.wxewm = wxewm;
	}
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
}
