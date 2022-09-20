package top.bing6749.config;
/*
 * @author  MaRui
 * @date  2022/6/17 20:31
 * @version 1.0
 */


import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import top.bing6749.utils.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MaRui
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
//        查看请求中是否存在token，如果不存在直接跳转到登陆页面
        String token = tokenUtil.getToken(request);
        if (StringUtils.isEmpty(token)) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
