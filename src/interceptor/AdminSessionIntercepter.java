package interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminSessionIntercepter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("这里走了AdminSessionInterceptor拦截器 ====start====");
		
		ActionContext actionContext = actionInvocation.getInvocationContext();
		Map session = actionContext.getSession();
		
		//创建session中获取的量进行初始化，以便于后面的比对
		int userid = -1;
		String useraccount = null;
		String username = null;
		int userpower = -1;
		//设置返回值result并且初始化
		String result = "sessionout";
		
		
		
		if(session.get("userid") == null ||  session.get("useraccount") == null || session.get("username") == null || session.get("userpower") == null){
			result =  "sessionout";
			ServletActionContext.getRequest().getSession().setAttribute("sessionout", "yes");
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("sessionout", "no");
			//获取session中对应的值
			userid = (Integer) session.get("userid");
			useraccount = (String) session.get("useraccount");
			username = (String) session.get("username");
			userpower = (Integer) session.get("userpower");
			System.out.println("访问者的权限是: "+userpower);
			//获取到访问的页面
			String url = actionContext.getName();
			System.out.println("要访问的url是:"+url);
			if(userpower == 0){
				if(!url.startsWith("admin")){
					System.out.println("非admin用户访问admin页面");
					result = actionInvocation.invoke();
				}
			}
			if(userpower == 1){
				if(url.startsWith("admin")){
					System.out.println("admin用户访问admin页面");
					result = actionInvocation.invoke();
				}
			}
		}
		System.out.println("这里走了AdminSessionInterceptor拦截器 result = "+result+"====end====");
		return result;
	}

}
