package com.pokerstar.api.domain.controller.pay;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "支付回调管理")
@RestController
@RequestMapping("/callback")
public class CallbackController {
    private static Logger Log = LoggerFactory.getLogger(CallbackController.class);
}
