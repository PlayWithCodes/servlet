package study.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import study.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");//application/json은 스펙에서 utf-8 형식을 사용하도록 정의되어 있으므로 필요없음
        resp.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("Lee");
        helloData.setAge(10);

        //{"username":"Lee", "age":10}
        String result = objectMapper.writeValueAsString(helloData);
        resp.getWriter().write(result);
    }
}
