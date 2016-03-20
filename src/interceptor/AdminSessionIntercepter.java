package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminSessionIntercepter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("这里走了AdminSessionInterceptor拦截器 ====start====");
		
		
		
		System.out.println("这里走了AdminSessionInterceptor拦截器 ====end====");
		return null;
	}

}
