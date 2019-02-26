package foo.amqpboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ImportResource("si-context.xml")
public class SampleController {

    @Autowired
    private Gate gate;

    @RequestMapping("/")
    @ResponseBody
    String home() throws Exception {
        gate.send("Hello, world!");
        return gate.result();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

}
