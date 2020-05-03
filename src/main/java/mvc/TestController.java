package mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
        request.getRequestURI();
        return "test";
    }
}
