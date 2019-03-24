package domain;

public class JobApply {
	private int id;
	private int uid;
	private int job_id;
	private String job_name;
	private int com_id;
	private String com_name;
	private int eid;
	private String apply_time;
	private int status;
	private String refuse_reason;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRefuse_reason() {
		return refuse_reason;
	}
	public void setRefuse_reason(String refuse_reason) {
		this.refuse_reason = refuse_reason;
	}
}
