package domain;

public class Comfavorite {
	private int id;
	private int com_id;
	private int resume_id;
	private int uid;
	private String resume_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		this.resume_id = resume_id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getResume_name() {
		return resume_name;
	}
	public void setResume_name(String resume_name) {
		this.resume_name = resume_name;
	}
}
