package com.pokerstar.api.domain.controller.agent;

import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.model.agent.AgentBankBO;
import com.pokerstar.api.domain.service.agent.IAgentBalanceService;
import com.pokerstar.api.domain.service.agent.IAgentLogService;
import com.pokerstar.api.domain.service.agent.IAgentService;
import com.pokerstar.api.domain.service.agent.IAgentWithdrawOrderService;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "代理信息管理")
@RestController
@RequestMapping("/agent")
public class AgentController {
    private static Logger Log = LoggerFactory.getLogger(AgentController.class);

    @Autowired
    private IAgentService agentService;

    @Autowired
    private IAgentWithdrawOrderService agentWithdrawOrderService;

    @Autowired
    private IAgentLogService agentLogService;

    @Autowired
    private IAgentBalanceService agentBalanceService;

    @ApiOperation(value = "新增代理", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Result addAgent(@RequestBody Agent agent) {
        try {
            agent.setAgent_create_time(DateTimeUtil.getCurrentSecondTimestamp());
            return Result.success(agentService.addAgent(agent));
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

    @ApiOperation(value = "代理登录", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/login")
    public Result agentLogIn(@RequestParam(value = "account") String account,
                             @RequestParam(value = "password") String password) {
        try {

            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

    @ApiOperation(value = "代理提现", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/withdraw")
    public Result withdrawApply() {
        try {

            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

    @ApiOperation(value = "修改代理银行信息", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/updateBankInfo")
    public Result updateBankInfo(@RequestBody AgentBankBO agentBank) {
        try {
            return Result.success(agentService.updateAgentBankInfo(agentBank));
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }
}
