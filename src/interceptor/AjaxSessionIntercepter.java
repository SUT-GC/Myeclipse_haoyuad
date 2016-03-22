package interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AjaxSessionIntercepter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("这里走了AjaxSessionIntercepter拦截器 ====start====");
		
		ActionContext actionContext = actionInvocation.getInvocationContext();
		Map session = actionContext.getSession();
		
		//创建session中获取的量进行初始化，以便于后面的比对
		int userid = -1;
		String useraccount = null;
		String username = null;
		int userpower = -1;
		//设置返回值result并且初始化
		
		
		
		if(session.get("userid") == null ||  session.get("useraccount") == null || session.get("username") == null || session.get("userpower") == null){
			ServletActionContext.getRequest().getSession().setAttribute("sessionout", "yes");
			System.out.println("经过ajax session拦截器判定， session已经过期");
		}else{
			System.out.println("经过ajax session拦截器判定， session没有过期");
			ServletActionContext.getRequest().getSession().setAttribute("sessionout", "no");
		}
		System.out.println("这里输出了AjaxSessionIntercepter中的sessionout的值"+ServletActionContext.getRequest().getSession().getAttribute("sessionout"));
		System.out.println("这里走了AjaxSessionIntercepter拦截器  ====end====");
		
		return actionInvocation.invoke();
	}

}
