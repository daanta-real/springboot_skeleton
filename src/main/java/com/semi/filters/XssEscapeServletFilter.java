package com.semi.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class XssEscapeServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        XssEscapeHttpServletRequestWrapper wrappedRequest = new XssEscapeHttpServletRequestWrapper(httpRequest);
        chain.doFilter((ServletRequest) wrappedRequest, response);
    }

    @Override
    public void destroy() {
        // Cleanup logic, if needed
    }

    private static class XssEscapeHttpServletRequestWrapper extends HttpServletRequestWrapper {
        XssEscapeHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            return value != null ? Encode.forHtml(value) : null;
        }

        // Override other request parameter retrieval methods if needed
        // Example: getParameterValues, getParameterMap, etc.
    }
}