package domain;

public class Friend {
	private int id;
	private int uid1;
	private String uname1;
	private int uid2;
	private String uname2;
	private int status;
	private String reply_time;
	private String create_time;
	private String delete_time;
	private String msg;
	private String resume_photo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getUid1() {
		return uid1;
	}
	public void setUid1(int uid1) {
		this.uid1 = uid1;
	}
	public String getUname1() {
		return uname1;
	}
	public void setUname1(String uname1) {
		this.uname1 = uname1;
	}
	public int getUid2() {
		return uid2;
	}
	public void setUid2(int uid2) {
		this.uid2 = uid2;
	}
	public String getUname2() {
		return uname2;
	}
	public void setUname2(String uname2) {
		this.uname2 = uname2;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getReply_time() {
		return reply_time;
	}
	public void setReply_time(String reply_time) {
		this.reply_time = reply_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getDelete_time() {
		return delete_time;
	}
	public void setDelete_time(String delete_time) {
		this.delete_time = delete_time;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getResume_photo() {
		return resume_photo;
	}
	public void setResume_photo(String resume_photo) {
		this.resume_photo = resume_photo;
	}

}
