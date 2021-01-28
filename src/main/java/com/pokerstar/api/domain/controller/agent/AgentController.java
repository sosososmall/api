package com.pokerstar.api.domain.controller.agent;

import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.service.agent.IAgentBalanceService;
import com.pokerstar.api.domain.service.agent.IAgentLogService;
import com.pokerstar.api.domain.service.agent.IAgentService;
import com.pokerstar.api.domain.service.agent.IAgentWithdrawOrderService;
import com.pokerstar.api.infrastructure.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Result addAgent(@RequestBody Agent agent) {
        try {

            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

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
}
