package net.xdclass.demo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1）使用Servlet3.0的注解进行配置
 * 2）启动类里面增加 @ServletComponentScan，进行扫描
 * 3）新建一个Filter类，implements Filter，并实现对应的接口
 * 4) @WebFilter 标记一个类为filter，被spring进行扫描
 *    urlPatterns：拦截规则，支持正则
 *
 * 6）控制chain.doFilter的方法的调用，来实现是否通过放行
 * 	  不放行，web应用resp.sendRedirect("/index.html");
 * 	  场景：权限控制、用户登录(非前端后端分离场景)等
 *
 * @author hdz
 */
@WebFilter(urlPatterns = "/api/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private final String USER_NAME = "xdClass";

    /**
     * 容器加载的时候调用
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }

    /**
     * 请求被拦截的时候进行调用
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest
                        , ServletResponse servletResponse
                        , FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter loginFilter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String userName = req.getParameter("username");
        if (USER_NAME.equals(userName)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("/index.html");
        }
    }

    /**
     * 容器被销毁的时候被调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy loginFilter");
    }
}
