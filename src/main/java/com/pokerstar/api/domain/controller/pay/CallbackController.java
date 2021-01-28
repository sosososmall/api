package com.pokerstar.api.domain.controller.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback")
public class CallbackController {
    private static Logger Log = LoggerFactory.getLogger(CallbackController.class);
}
