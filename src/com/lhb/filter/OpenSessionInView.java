package com.lhb.filter;

import com.lhb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;

public class OpenSessionInView implements Filter {
    @Override
    public void init(FilterConfig filterconfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        SqlSession session = MyBatisUtil.getSession();
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession();
        }
    }
    @Override
    public void destroy() {

    }
}
