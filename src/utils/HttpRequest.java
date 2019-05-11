package utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import domain.Admin;
import domain.College;
import domain.Company;
import domain.CompanyCollection;
import domain.CompanyJob;
import domain.CompanyJobMin;
import domain.Department;
import domain.Friend;
import domain.Industry;
import domain.JobApply;
import domain.JobInterview;
import domain.News;
import domain.Origine;
import domain.StuFavorite;
import domain.Student;
import domain.StudentEdu;
import domain.StudentExp;
import domain.JobClass;
import domain.JobExpect;
 
public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
	private static String URLROOT = "http://47.96.70.17/career/api/";
//	private static String URLROOT = "http://47.96.70.17/career/service/";
//	private static String URLROOT = "http://47.254.22.209:8080/careerdev/api/";
	private static String TOKEN = "0e173882280f4303ba144b8b653c1c00";
	
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
 
    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            System.out.println(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("post推送结果："+result);
        return result;
    }
    
    public static void main(String[] args) {

    }
    
    //通过名字获取登录账号
    public Admin getAdminByName(String name) {
		Admin admin=new Admin();
		String s=HttpRequest.sendPost(URLROOT+"get/admin", "token="+TOKEN+"&where=name=\""+name+"\"");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			admin = JSON.parseObject(data.get(0).toString(),Admin.class);
			return admin;
		}
		return null;
	}
    
    public Admin getAdminByPhone(String phonenumber) {
		Admin admin=new Admin();
		String s=HttpRequest.sendGet(URLROOT+"get/admin", "token="+TOKEN+"&where=mobile="+phonenumber);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			admin = JSON.parseObject(data.get(0).toString(),Admin.class);
			return admin;
		}
		return null;
	}    
	
	//通过公司id获取公司信息
	public Company getCompanyById(int id) {
		Company company=new Company();
		String s=HttpRequest.sendGet(URLROOT+"get/company_info", "token="+TOKEN+"&where=id="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			company = JSON.parseObject(data.get(0).toString(),Company.class);
			return company;
		}
		return null;
	}
	
	//通过id获取职位详情
	public CompanyJob getCompanyJobById(int id) {
		CompanyJob companyJob=new CompanyJob();
		String s=HttpRequest.sendGet(URLROOT+"get/company_job", "token="+TOKEN+"&where=id="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			companyJob = JSON.parseObject(data.get(0).toString(),CompanyJob.class);
			return companyJob;
		}
		return null;
	}
	
	//通过id获取学生信息
	public Student getStudentById(int id) {
		Student student=new Student();
		String s=HttpRequest.sendGet(URLROOT+"get/resume", "token="+TOKEN+"&where=uid="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			student = JSON.parseObject(data.get(0).toString(),Student.class);
			return student;
		}
		return null;
	}
	
	//通过学号获取学生原始信息
	public Origine getOrigineByNumber(String number) {
		Origine origine=new Origine();
		String s=HttpRequest.sendGet(URLROOT+"get/student_origine", "token="+TOKEN+"&where=number="+number);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			origine = JSON.parseObject(data.get(0).toString(),Origine.class);
			return origine;
		}
		return null;
	}
	
	//更新学生原始信息
	public void updateOrigine(Origine origine) {
		String data=JSON.toJSONString(origine);
		HttpRequest.sendPost(URLROOT+"merge/student_origine", "token="+TOKEN+"&data="+data);
	}
	
	//添加学生
	public void addStudent(Student student) {
		String data=JSON.toJSONString(student);
		HttpRequest.sendPost(URLROOT+"merge/resume", "token="+TOKEN+"&data="+data);
	}
	
	//添加学生登录
	public void addAdmin(Admin admin) {
		String data=JSON.toJSONString(admin);
		HttpRequest.sendPost(URLROOT+"merge/admin", "token="+TOKEN+"&data="+data);
	}
	
	//通过学生、企业id获取交友信息
	public Friend getFriendByCSId(int comId,int stuId) {
		Friend friend=new Friend();
		String s=HttpRequest.sendPost(URLROOT+"get/friends", "token="+TOKEN+"&where=uid1="+comId+" and uid2="+stuId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			friend = JSON.parseObject(data.get(0).toString(),Friend.class);
			return friend;
		}
		return null;
	}
	
	//通过job中id获取投递简历列表
	public List<JobApply> getJobGetResumeListByJobId(int jobId){
		List<JobApply> list = new ArrayList<JobApply>();
		String s=HttpRequest.sendGet(URLROOT+"get/job_apply", "token="+TOKEN+"&where=job_id="+jobId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), JobApply.class);
			return list;
		}
		return null;
	}
	
	//通过job中id获取投递简历列表
	public List<JobApply> getResumeListById(int comId){
		List<JobApply> list = new ArrayList<JobApply>();
		String s=HttpRequest.sendGet(URLROOT+"get/job_apply", "token="+TOKEN+"&where=com_id="+comId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), JobApply.class);
			return list;
		}
		return null;
	}
	
	//通过学生、企业id判断是否收藏简历
	public int isCollection(int companyId,int studentId){
		String s=HttpRequest.sendPost(URLROOT+"get/favorite_resume", "token="+TOKEN+"&where=com_id="+companyId+" and uid="+ studentId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			return 1;
		}
		return 0;
	}
	
	public int isSend(int jobId, int stuId) {
		String s1 = HttpRequest.sendPost(URLROOT+"get/job_apply","token="+TOKEN+"&where=job_id=" + jobId + " and uid="+stuId);
		JSONObject object1 = JSONObject.parseObject(s1);
		JSONArray data1 = object1.getJSONArray("data");
		if (data1.size()!=0) {
			return 1;
		}
		return 0;
	}
	
	public List<Company> getCompanyByOthers(List<String> list){
		List<Company> companyList = new ArrayList<Company>();
		String sql = "";
		if(!list.isEmpty()) {
			sql += " where ";
			for(int i=0;i<list.size()/2;i++) {
				sql += list.get(2*i);
				sql += " = '";
				sql += list.get(2*i+1);
				sql += "'";
				System.out.println(list.get(2*i));
				System.out.println(list.get(2*i+1));
				if (i<list.size()/2-1) {
					sql += " and ";
				}
			}
		}
		String s=HttpRequest.sendPost(URLROOT+"get/company_info", "token="+TOKEN+"&"+sql);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			companyList = JSONArray.parseArray(data.toString(), Company.class);
			return companyList;
		}
		return null;
	}
	
	//发送面试邀请
	public void sendInterview(JobInterview jobInterview){
		String data = JSON.toJSONString(jobInterview);
		HttpRequest.sendPost(URLROOT+"merge/job_interview","token="+TOKEN+"&data="+data);
	}	
	
	//收藏学生简历
	public void addCollection(CompanyCollection companyCollection) {
		String data = JSON.toJSONString(companyCollection);
		HttpRequest.sendPost(URLROOT+"merge/favorite_resume","token="+TOKEN+"&data="+data);
	}

	//取消收藏
	public void removeCollection(int stuId,int com_id) {
		HttpRequest.sendPost(URLROOT+"delete/favorite_resume", "token="+TOKEN+"&where=uid="+stuId+" and com_id="+com_id);
	}
	
	//通过id获取消息列表
	public List<Friend> getMessageListById(int id){
		List<Friend> list = new ArrayList<Friend>();
		String s=HttpRequest.sendGet(URLROOT+"get/friends", "token="+TOKEN+"&where=uid2="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Friend.class);
			return list;
		}
		return null;
	}
	
	//申请、同意好友申请
	public void updateMessage(Friend friend) {
		String data=JSON.toJSONString(friend);
		HttpRequest.sendPost(URLROOT+"merge/friends", "token="+TOKEN+"&data="+data);
	}
	
	//删除消息
	public void removeMessage(int friendId) {
		HttpRequest.sendPost(URLROOT+"delete/friends", "token="+TOKEN+"&id="+friendId);
	}
	
	//更新面试邀请
	public void updateInterview(JobInterview jobInterview) {
		String data = JSON.toJSONString(jobInterview);
		HttpRequest.sendPost(URLROOT+"merge/job_interview","token="+TOKEN+"&data="+data);
	}
	
	//删除面试邀请
	public void deleteInterview(int jobInterviewId) {
		HttpRequest.sendPost(URLROOT+"delete/job_interview","token="+TOKEN+"&where=id="+jobInterviewId);
	}
	
	//获取公司收藏简历列表
	public List<CompanyCollection> getComCollectionListById(int com_id){
		List<CompanyCollection> list = new ArrayList<CompanyCollection>();
		String s=HttpRequest.sendGet(URLROOT+"get/favorite_resume", "token="+TOKEN+"&where=com_id="+com_id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), CompanyCollection.class);
			return list;
		}
		return null;
	}
	
	//删除简历
	public void removeResume(int stuId,int com_id) {
		HttpRequest.sendPost(URLROOT+"delete/job_apply", "token="+TOKEN+"&where=uid="+stuId+" and com_id="+com_id);
	}
	
	//添加职位
	public void addJob(CompanyJob companyJob) {
		String data=JSON.toJSONString(companyJob);
		HttpRequest.sendPost(URLROOT+"merge/company_job", "token="+TOKEN+"&data="+data);
	}
	
	//行业列表
	public List<Industry> getIndustryList(){
		List<Industry> list = new ArrayList<Industry>();
		String s=HttpRequest.sendGet(URLROOT+"get/industry", "token="+TOKEN);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Industry.class);
			return list;
		}
		return null;
	}
	
	//删除工作
	public void deleteJob(CompanyJob companyJob) {
		HttpRequest.sendPost(URLROOT+"delete/company_job", "token="+TOKEN+"&id="+companyJob.getId());
		HttpRequest.sendPost(URLROOT+"delete/favorite_job", "token="+TOKEN+"&job_id="+companyJob.getId());
		HttpRequest.sendPost(URLROOT+"delete/job_apply", "token="+TOKEN+"&job_id="+companyJob.getId());
		HttpRequest.sendPost(URLROOT+"delete/job_interview", "token="+TOKEN+"&job_id="+companyJob.getId());
	}

	//获取学生教育经历
	public List<StudentEdu> getStudentEduListById(int studentId) {
		List<StudentEdu> list = new ArrayList<StudentEdu>();
		String s=HttpRequest.sendGet(URLROOT+"get/resume_edu", "token="+TOKEN+"&where=uid="+studentId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), StudentEdu.class);
			return list;
		}
		return null;
	}
	
	//获取学生求职期望
	public List<StudentExp> getStudentExpListById(int studentId) {
		List<StudentExp> list = new ArrayList<StudentExp>();
		String s=HttpRequest.sendGet(URLROOT+"get/resume_expect", "token="+TOKEN+"&where=uid="+studentId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), StudentExp.class);
			return list;
		}
		return null;
	}

	public List<JobClass> getJobClassList() {
		List<JobClass> list = new ArrayList<JobClass>();
		String s=HttpRequest.sendGet(URLROOT+"get/job_class", "token="+TOKEN);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), JobClass.class);
			return list;
		}
		return null;
	}
   
    

	public Admin getAdminByItemId(int id) {
		Admin admin=new Admin();
		String s=HttpRequest.sendGet(URLROOT+"get/admin", "token="+TOKEN+"&where=item_id="+id+"&fields=id,item_id,password,type");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			admin = JSON.parseObject(data.get(0).toString(),Admin.class);
			return admin;
		}
		return null;
	}

	public Admin getAdminById(int id) {
		Admin admin=new Admin();
		String s=HttpRequest.sendGet(URLROOT+"get/admin", "token="+TOKEN+"&where=id="+id+"&fields=id,item_id,password,type");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			admin = JSON.parseObject(data.get(0).toString(),Admin.class);
			return admin;
		}
		return null;
	}
	
	public List<CompanyCollection> getComfavoriteListById(int com_id){
		List<CompanyCollection> list = new ArrayList<CompanyCollection>();
		String s=HttpRequest.sendGet(URLROOT+"get/favorite_resume", "token="+TOKEN+"&where=com_id="+com_id+"&fields=id,com_id,resume_id,uid,resume_name");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), CompanyCollection.class);
			return list;
		}
		return null;
	}
	
	public News getNewsById(int id) {
		News news=new News();
		String s=HttpRequest.sendGet(URLROOT+"get/college_news", "token="+TOKEN+"&where=id="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			news = JSON.parseObject(data.get(0).toString(),News.class);
			return news;
		}
		return null;
	}
	
	public List<News> getNewsListByColId(int colId){
		List<News> list = new ArrayList<News>();
		String s=HttpRequest.sendGet(URLROOT+"get/college_news", "token="+TOKEN+"&where=college_id="+colId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), News.class);
			return list;
		}
		return null;
	}
	
	public List<StuFavorite> getStuFavoriteListById(int id){
		List<StuFavorite> list = new ArrayList<StuFavorite>();
		String s=HttpRequest.sendGet(URLROOT+"get/favorite_job", "token="+TOKEN+"&where=uid="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), StuFavorite.class);
			return list;
		}
		return null;
	}
	
	public Student getStudentByStuId(int stuId) {
		Student student=new Student();
		String s=HttpRequest.sendGet(URLROOT+"get/resume", "token="+TOKEN+"&where=uid="+stuId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			student = JSON.parseObject(data.get(0).toString(),Student.class);
			return student;
		}
		return null;
	}
	
	public List<Student> getStudentListByCollege(int collegeId,int departmentId) {
		List<Student> list = new ArrayList<Student>();
		String s=HttpRequest.sendPost(URLROOT+"get/resume", "token="+TOKEN+"&where=college_id="+collegeId+" and dept_id="+departmentId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Student.class);
			return list;
		}
		return null;
	}
	
	public StudentExp getStudentExpById(int stuId) {
		StudentExp studentExp=new StudentExp();
		String s=HttpRequest.sendGet(URLROOT+"get/resume_expect", "token="+TOKEN+"&where=uid="+stuId+"&fields=id,eid,uid,title,name,hy_name,job_name,province_name,city_name,jobstatus,type_name,report_name,open,def_job,idcard_status,status,edu,minsalary,maxsalary");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			studentExp = JSON.parseObject(data.get(0).toString(),StudentExp.class);
			return studentExp;
		}
		return null;
	}
	
	public List<CompanyJob> getCompanyJobListByHyname(String hyname){
		List<CompanyJob> list = new ArrayList<CompanyJob>();
		String s=HttpRequest.sendPost(URLROOT+"get/company_job", "token="+TOKEN+"&where=hy_name=\""+hyname+"\"");
		
		JSONObject object=JSONObject.parseObject(s);
		if (object!=null) {
			JSONArray data = object.getJSONArray("data");
			if(data.size()!=0) {
				list = JSONArray.parseArray(data.toString(), CompanyJob.class);
				return list;
			}
		}
		return null;
	}
	
	//获取所有职位
	public List<CompanyJob> getAllCompanyJobList(){
		List<CompanyJob> list = new ArrayList<CompanyJob>();
		String s=HttpRequest.sendPost(URLROOT+"get/company_job", "token="+TOKEN);
		
		JSONObject object=JSONObject.parseObject(s);
		if (object!=null) {
			JSONArray data = object.getJSONArray("data");
			if(data.size()!=0) {
				list = JSONArray.parseArray(data.toString(), CompanyJob.class);
				return list;
			}
		}
		return null;
	}
	
	public List<Department> getDepartmentListByCollegeId(int collegeId){
		List<Department> list = new ArrayList<Department>();
		String s=HttpRequest.sendGet(URLROOT+"get/department", "token="+TOKEN+"&where=parent_id="+collegeId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Department.class);
			return list;
		}
		return null;
	}
	
	public List<CompanyJob> getCompanyJobList(){
		List<CompanyJob> list = new ArrayList<CompanyJob>();
		String s=HttpRequest.sendGet(URLROOT+"get/company_job", "token="+TOKEN);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), CompanyJob.class);
			return list;
		}
		return null;
	}
	
	public List<College> getCollegeList(){
		List<College> list = new ArrayList<College>();
		String s=HttpRequest.sendGet(URLROOT+"get/college", "token="+TOKEN);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), College.class);
			return list;
		}
		return null;
	}
	
	public List<CompanyJobMin> getCompanyJobMinListById(int id){
		List<CompanyJobMin> list = new ArrayList<CompanyJobMin>();
		String s=HttpRequest.sendGet(URLROOT+"get/company_job", "token="+TOKEN+"&where=com_id="+id+"&fields=id,name,jobhits,snum,status");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), CompanyJobMin.class);
			return list;
		}
		return null;
	}
	
	public List<JobExpect> getJobExpectListById(int uid){
		List<JobExpect> list = new ArrayList<JobExpect>();
		String s=HttpRequest.sendGet(URLROOT+"get/resume_expect", "token="+TOKEN);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data!=null && data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), JobExpect.class);
			return list;
		}
		return null;
	}
	
	public List<Friend> getFriendsListById(int id){
		List<Friend> list = new ArrayList<Friend>();
		String s=HttpRequest.sendPost(URLROOT+"get/friends", "token="+TOKEN+"&where=uid1="+id+" or uid2="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Friend.class);
			return list;
		}
		return null;
	}
	
	public void collectJob(StuFavorite stuFavorite) {
    	String data = JSON.toJSONString(stuFavorite);
    	String s=HttpRequest.sendPost(URLROOT+"merge/favorite_job", "token="+TOKEN+"&data="+data);
    	System.out.println(s);
	}
	
	public void removeCollectStudent(int stuId,int com_id) {
    	String s=HttpRequest.sendPost(URLROOT+"delete/favorite_resume", "token="+TOKEN+"&where=resume_id="+stuId+" and com_id="+com_id);
    	System.out.println(s);
	}
	
	public void addFriends(Friend friend) {
		String data = JSON.toJSONString(friend);
		String s=HttpRequest.sendPost(URLROOT+"merge/friends", "token="+TOKEN+"&data="+data);
    	System.out.println(s);
	}
	
	public void updateFriends(Friend friend) {
		String data=JSON.toJSONString(friend);
		String s=HttpRequest.sendPost(URLROOT+"merge/friends", "token="+TOKEN+"&data="+data);
    	System.out.println(s);
	}
	
	public void removeFriends(Friend friend) {
		String data="uid1="+friend.getUid1()+" and uid2="+friend.getUid2();
    	String s=HttpRequest.sendPost(URLROOT+"delete/friends", "token="+TOKEN+"&where="+data);
    	System.out.println(s);
	}

	public void removeCollectJob(int jobId,int stuId) {
    	String s=HttpRequest.sendPost(URLROOT+"delete/favorite_job", "token="+TOKEN+"&where=uid="+stuId+" and job_id="+jobId);
    	System.out.println(s);
	}
	
	public void updateStudent(Student student) {
		String data=JSON.toJSONString(student);
		String s=HttpRequest.sendPost(URLROOT+"merge/resume", "token="+TOKEN+"&data="+data);
    	System.out.println(s);
	}
	
	public void AddJobExpect(JobExpect jobExpect) {
		String data = JSON.toJSONString(jobExpect);
		String s=HttpRequest.sendPost(URLROOT+"merge/resume_expect", "token="+TOKEN+"&data="+data);
    	System.out.println(s);
	}

	
	public void sendResume(JobApply jobApply) {
		String data=JSON.toJSONString(jobApply);
		String s=HttpRequest.sendPost(URLROOT+"merge/job_apply", "token="+TOKEN+"&data="+data);
    	System.out.println(s);
	}
	
	public void updateJob(CompanyJob companyJob) {
		String data=JSON.toJSONString(companyJob);
		String s=HttpRequest.sendPost(URLROOT+"merge/company_job", "token="+TOKEN+"&data="+data);
    	System.out.println(s);
	}
	
	//面试邀请列表
	public List<JobInterview> getInterviewList(int uid){
		List<JobInterview> list = new ArrayList<JobInterview>();
		String s=HttpRequest.sendPost(URLROOT+"get/job_interview", "token="+TOKEN+"&where=uid="+uid);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), JobInterview.class);
			return list;
		}
		return null;
	}

	//通过ID获取面试信息
	public JobInterview getInterviewById(int id){
		JobInterview interview = new JobInterview();
		String s=HttpRequest.sendPost(URLROOT+"get/job_interview", "token="+TOKEN+"&where=id="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			interview = JSON.parseObject(data.get(0).toString(),JobInterview.class);
			return interview;
		}
		return null;
	}
	
}
