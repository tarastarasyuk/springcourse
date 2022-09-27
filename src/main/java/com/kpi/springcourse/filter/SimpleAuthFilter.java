package com.kpi.springcourse.filter;

import com.kpi.springcourse.constants.SpringCourseConstants;
import com.kpi.springcourse.service.EditorService;
import com.kpi.springcourse.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@AllArgsConstructor
@Component
@WebFilter(value = {"/editor/**", "profile/**"})
public class SimpleAuthFilter implements Filter {

    private final StudentService studentService;
    private final EditorService editorService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String sessionUserEmail = (String) request.getSession().getAttribute(SpringCourseConstants.SESSION_AUTH_ATTR);

        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/editor")) {
            if (editorService.checkIfEmailAvailable(sessionUserEmail)) {
                // TODO: make a handler to render a page with error msg
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        } else if (requestURI.startsWith("/profile")) {
            if (studentService.checkIfEmailAvailable(sessionUserEmail)) {
                // TODO: make a handler to render a page with error msg
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
