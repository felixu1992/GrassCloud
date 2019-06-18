package top.felixu.grass.baseserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.felixu.grass.common.core.dto.BaseResp;
import top.felixu.grass.common.logging.annotation.AccessLogger;

/**
 * @author felixu
 * @date 2019.06.18
 */
@RestController
public class TestController {

    @GetMapping("/test")
    @AccessLogger(value = "测试接口")
    public BaseResp<String> test() {
        return BaseResp.onSuc("SUCCESS");
    }
}
