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
import domain.Comfavorite;
import domain.Company;
import domain.CompanyJob;
import domain.CompanyJobMin;
import domain.Department;
import domain.Friends;
import domain.JobApply;
import domain.JobExpect;
import domain.News;
import domain.StuFavorite;
import domain.Student;
import domain.StudentEdu;
import domain.StudentExp;

 
public class HttpRequest {
	private static String URLROOT = "http://47.96.70.17/career/";
	private static String URLROOT2 = "http://47.254.22.209:8080/careerdev/";
	private static String TOKEN = "0e173882280f4303ba144b8b653c1c00";
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */

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
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //1.获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //2.中文有乱码的需要将PrintWriter改为如下
            //out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8")
            // 发送请求参数
            out.print(param);
            System.out.println(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
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
//    	String data="{\"id\": 0,\"name\": \"chenyuhang\"}";
//    	String s=HttpRequest.sendPost(URLROOT2+"api/merge/admin", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
//    	System.out.println(s);
//    	String s=HttpRequest.sendGet(URLROOT2+"api/delete/admin", "token=0e173882280f4303ba144b8b653c1c00&id=49");
//    	System.out.println(s);
//    	String data="{\"id\": 0,\"uid1\": "+1+",\"uname1\": \""+"132"+"\",\"uid2\": "+5+",\"uname2\": \""+"3243"+"\",\"status\": 0,\"msg\": \""+"hhhhhhhhhhhh"+"\"}";
//    	String s=HttpRequest.sendPost(URLROOT2+"api/merge/friends", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
//    	System.out.println(s);
//    	CompanyJob companyJob = new CompanyJob();
//    	HttpRequest httpRequest=new HttpRequest();
//    	httpRequest.addJob(companyJob);
//    	System.out.println(JSON.toJSONString(companyJob));
    }
    
  //通过名字获取登录账号
    public Admin getAdminByName(String name) {
		Admin admin=new Admin();
		String s=HttpRequest.sendPost(URLROOT+"api/get/admin", "token="+TOKEN+"&where=name=\""+name+"\"");
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
		String s=HttpRequest.sendGet(URLROOT2+"api/get/admin", "token=0e173882280f4303ba144b8b653c1c00&where=mobile="+phonenumber+"&fields=id,item_id,password,type");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			admin = JSON.parseObject(data.get(0).toString(),Admin.class);
			return admin;
		}
		return null;
	}
    

	public Admin getAdminByItemId(int id) {
		Admin admin=new Admin();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/admin", "token=0e173882280f4303ba144b8b653c1c00&where=item_id="+id+"&fields=id,item_id,password,type");
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
		String s=HttpRequest.sendGet(URLROOT2+"api/get/admin", "token=0e173882280f4303ba144b8b653c1c00&where=id="+id+"&fields=id,item_id,password,type");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			admin = JSON.parseObject(data.get(0).toString(),Admin.class);
			return admin;
		}
		return null;
	}
	
	public List<Comfavorite> getComfavoriteListById(int com_id){
		List<Comfavorite> list = new ArrayList<Comfavorite>();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/favorite_resume", "token=0e173882280f4303ba144b8b653c1c00&where=com_id="+com_id+"&fields=id,com_id,resume_id,uid,resume_name");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Comfavorite.class);
			return list;
		}
		return null;
	}
	
	public News getNewsById(int id) {
		News news=new News();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/college_news", "token=0e173882280f4303ba144b8b653c1c00&where=id="+id);
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
		String s=HttpRequest.sendGet(URLROOT2+"api/get/college_news", "token=0e173882280f4303ba144b8b653c1c00&where=college_id="+colId);
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
		String s=HttpRequest.sendGet(URLROOT2+"api/get/favorite_job", "token=0e173882280f4303ba144b8b653c1c00&where=uid="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), StuFavorite.class);
			return list;
		}
		return null;
	}
	
	public Company getCompanyById(int id) {
		Company company=new Company();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/company_info", "token=0e173882280f4303ba144b8b653c1c00&where=id="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			company = JSON.parseObject(data.get(0).toString(),Company.class);
			return company;
		}
		return null;
	}
	
	public Student getStudentByStuId(int stuId) {
		Student student=new Student();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/resume", "token=0e173882280f4303ba144b8b653c1c00&where=uid="+stuId);
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
		String s=HttpRequest.sendPost(URLROOT2+"api/get/resume", "token=0e173882280f4303ba144b8b653c1c00&where=college_id="+collegeId+" and dept_id="+departmentId);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Student.class);
			return list;
		}
		return null;
	}
	
	public Student getStudentById(int id) {
		Student student=new Student();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/resume", "token=0e173882280f4303ba144b8b653c1c00&where=id="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			student = JSON.parseObject(data.get(0).toString(),Student.class);
			return student;
		}
		return null;
	}
	
	public StudentExp getStudentExpById(int stuId) {
		StudentExp studentExp=new StudentExp();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/resume_expect", "token=0e173882280f4303ba144b8b653c1c00&where=uid="+stuId+"&fields=id,eid,uid,title,name,hy_name,job_name,province_name,city_name,jobstatus,type_name,report_name,open,def_job,idcard_status,status,edu,minsalary,maxsalary");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			studentExp = JSON.parseObject(data.get(0).toString(),StudentExp.class);
			return studentExp;
		}
		return null;
	}
	
	public CompanyJob getCompanyJobById(int id) {
		CompanyJob companyJob=new CompanyJob();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/company_job", "token=0e173882280f4303ba144b8b653c1c00&where=id="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			companyJob = JSON.parseObject(data.get(0).toString(),CompanyJob.class);
			return companyJob;
		}
		return null;
	}
	
	public List<CompanyJob> getCompanyJobListByHyname(String hyname){
		List<CompanyJob> list = new ArrayList<CompanyJob>();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/company_job", "token=0e173882280f4303ba144b8b653c1c00&where=hy_name="+hyname);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), CompanyJob.class);
			return list;
		}
		return null;
	}
	
	public List<Department> getDepartmentListByCollegeId(int collegeId){
		List<Department> list = new ArrayList<Department>();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/department", "token=0e173882280f4303ba144b8b653c1c00&where=parent_id="+collegeId);
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
		String s=HttpRequest.sendGet(URLROOT2+"api/get/company_job", "token=0e173882280f4303ba144b8b653c1c00");
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
		String s=HttpRequest.sendGet(URLROOT2+"api/get/college", "token=0e173882280f4303ba144b8b653c1c00");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), College.class);
			return list;
		}
		return null;
	}
	
	public List<StudentEdu> getStudentEduListById(int stuId){
		List<StudentEdu> list = new ArrayList<StudentEdu>();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/resume_edu", "token=0e173882280f4303ba144b8b653c1c00&where=uid="+stuId+"&fields=id,uid,eid,name,starttime,endtime,college,major,edu_name");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), StudentEdu.class);
			return list;
		}
		return null;
	}
	
	public List<CompanyJobMin> getCompanyJobMinListById(int id){
		List<CompanyJobMin> list = new ArrayList<CompanyJobMin>();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/company_job", "token=0e173882280f4303ba144b8b653c1c00&where=com_id="+id+"&fields=id,name,jobhits,snum,status");
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
		String s=HttpRequest.sendGet(URLROOT2+"api/get/resume_expect", "token=0e173882280f4303ba144b8b653c1c00&where=uid="+uid+"&fields=id,uid,title,hy_id,hy_name,job_classid,job_classname,prvince_name,city_name,jobstatus,type_id,type_name,report,open,def_job,name,status,edu,minsalary,maxsalary");
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data!=null && data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), JobExpect.class);
			return list;
		}
		return null;
	}
	
	public List<Friends> getFriendsListById(int id){
		List<Friends> list = new ArrayList<Friends>();
		String s=HttpRequest.sendPost(URLROOT2+"api/get/friends", "token=0e173882280f4303ba144b8b653c1c00&where=uid1="+id+" or uid2="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Friends.class);
			return list;
		}
		return null;
	}
	
	public List<Friends> getMessageListById(int id){
		List<Friends> list = new ArrayList<Friends>();
		String s=HttpRequest.sendGet(URLROOT2+"api/get/friends", "token=0e173882280f4303ba144b8b653c1c00&where=uid2="+id);
		JSONObject object=JSONObject.parseObject(s);
		JSONArray data = object.getJSONArray("data");
		if(data.size()!=0) {
			list = JSONArray.parseArray(data.toString(), Friends.class);
			return list;
		}
		return null;
	}
	
	public void collectStudent(Comfavorite comfavorite) {
    	String data = JSON.toJSONString(comfavorite);
    	String s=HttpRequest.sendPost(URLROOT2+"api/merge/favorite_resume", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}
	
	public void collectJob(StuFavorite stuFavorite) {
    	String data = JSON.toJSONString(stuFavorite);
    	String s=HttpRequest.sendPost(URLROOT2+"api/merge/favorite_job", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}
	
	public void removeCollectStudent(int stuId,int com_id) {
    	String s=HttpRequest.sendPost(URLROOT2+"api/delete/favorite_resume", "token=0e173882280f4303ba144b8b653c1c00&where=resume_id="+stuId+" and com_id="+com_id);
    	System.out.println(s);
	}
	
	public void addFriends(Friends friends) {
		String data = JSON.toJSONString(friends);
		String s=HttpRequest.sendPost(URLROOT2+"api/merge/friends", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}
	
	public void updateFriends(Friends friends) {
		String data=JSON.toJSONString(friends);
		String s=HttpRequest.sendPost(URLROOT2+"api/merge/friends", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}
	
	public void removeFriends(Friends friends) {
		String data="uid1="+friends.getUid1()+" and uid2="+friends.getUid2();
    	String s=HttpRequest.sendPost(URLROOT2+"api/delete/friends", "token=0e173882280f4303ba144b8b653c1c00&where="+data);
    	System.out.println(s);
	}

	public void removeCollectJob(int jobId,int stuId) {
    	String s=HttpRequest.sendPost(URLROOT2+"api/delete/favorite_job", "token=0e173882280f4303ba144b8b653c1c00&where=uid="+stuId+" and job_id="+jobId);
    	System.out.println(s);
	}
	
	public void updateStudent(Student student) {
		String data=JSON.toJSONString(student);
		String s=HttpRequest.sendPost(URLROOT2+"api/merge/resume", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}
	
	public void AddJobExpect(JobExpect jobExpect) {
		String data = JSON.toJSONString(jobExpect);
		String s=HttpRequest.sendPost(URLROOT2+"api/merge/resume_expect", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}
	
	public void addJob(CompanyJob companyJob) {
		String data=JSON.toJSONString(companyJob);
		String s=HttpRequest.sendPost(URLROOT2+"api/merge/company_job", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}
	
	public void sendResume(JobApply jobApply) {
		String data=JSON.toJSONString(jobApply);
		String s=HttpRequest.sendPost(URLROOT2+"api/merge/job_apply", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}
	
	public void updateJob(CompanyJob companyJob) {
		String data=JSON.toJSONString(companyJob);
		String s=HttpRequest.sendPost(URLROOT2+"api/merge/company_job", "token=0e173882280f4303ba144b8b653c1c00&data="+data);
    	System.out.println(s);
	}

	public int isSend(int jobId, int stuId) {
		String s1 = HttpRequest.sendPost(URLROOT+"api/get/job_apply","token=0e173882280f4303ba144b8b653c1c00&where=job_id=" + jobId + " and uid="+stuId);
		JSONObject object1 = JSONObject.parseObject(s1);
		JSONArray data1 = object1.getJSONArray("data");
		if (data1.size()!=0) {
			return 1;
		}
		return 0;
	}


	
}
