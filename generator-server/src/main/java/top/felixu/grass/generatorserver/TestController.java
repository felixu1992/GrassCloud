package top.felixu.grass.generatorserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author felixu
 * @date 2019.05.16
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/test")
    public Object test() {
        return "SUCCESS";
    }
}
