package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - Start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paraName -> System.out.println(paraName + " = " + request.getParameter(paraName)));

        System.out.println("[전체 파라미터 조회] - End");
        request.getParameterNames();

        System.out.println("[단일 파라미터 조회] - Start");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        System.out.println("username = " + username);
        System.out.println("sex = " + sex);

        System.out.println("[단일 파라미터 조회] - End");

        System.out.println("[복수 파라미터 조회] - Start");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);    
        }

        System.out.println("[복수수 파라미터 조] - End");

    }
}
