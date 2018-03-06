package allen.zuul.bus;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class TestFilter extends ZuulFilter {

    @Override
    public Object run() {
	RequestContext ctx = RequestContext.getCurrentContext();
	HttpServletRequest request = ctx.getRequest();

	return null;
    }

    @Override
    public boolean shouldFilter() {
	RequestContext ctx = RequestContext.getCurrentContext();
	if (ctx.contains("isSuccess")) {
//	    return (boolean) ctx.get("isSuccess");// 如果前一个过滤器的结果为true，则说明上一个过滤器成功了，需要进入当前的过滤，如果前一个过滤器的结果为false，则说明上一个过滤器没有成功，则无需进行下面的过滤动作了，直接跳过后面的所有过滤器并返回结果
	}
	return true;
    }

    @Override
    public int filterOrder() {
	return 0;
    }

    @Override
    public String filterType() {
	return "pre"; // route post error
    }

}
