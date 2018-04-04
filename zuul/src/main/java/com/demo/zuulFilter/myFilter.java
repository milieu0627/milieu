package com.demo.zuulFilter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
@Component
public class myFilter extends ZuulFilter{
	//开启日志
	private final static Logger logger = LoggerFactory.getLogger(myFilter.class);
	/**
	 * 运行逻辑：滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
	 */
	@Override
	public Object run() {
		//获取请求环境
		RequestContext ctx=RequestContext.getCurrentContext();
		//获取请求
		HttpServletRequest request=ctx.getRequest();
		//写入日志
		logger.info("URI::"+request.getRequestURI(),"address::"+request.getLocalAddr());
		//获取请求参数
		Object token=request.getParameter("token");
		HttpServletResponse res=ctx.getResponse();
		if(token==null) {
			//设置路由返回值为false
			ctx.setSendZuulResponse(false);
			//设置状态
			ctx.setResponseStatusCode(401);
			res.setCharacterEncoding("UTF-8");
			//设置返回信息
			try {
				ctx.getResponse().getWriter().write("token  不存在哟");
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		logger.info("ok");
		return null;
	}

	/**
	 * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	/**
	 * 过滤器顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
	/**
	 * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
         pre：路由之前
         routing：路由之时
         post： 路由之后
         error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
