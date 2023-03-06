package hm.conn_bd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Main_Ctrl {

    @GetMapping("")
    public String showHomePage(){

        return "Index";
    }
}
