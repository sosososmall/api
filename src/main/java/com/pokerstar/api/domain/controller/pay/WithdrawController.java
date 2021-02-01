package com.pokerstar.api.domain.controller.pay;

import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import com.pokerstar.api.infrastructure.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Api(tags = "提现")
@RestController
@RequestMapping("/withdraw")
public class WithdrawController {
    private static Logger Log = LoggerFactory.getLogger(WithdrawController.class);


    @ApiOperation(value = "提现", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/create")
    public Result createWithdrawOrder(@RequestBody WithdrawRequest pay) {
        try {

            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }
}
