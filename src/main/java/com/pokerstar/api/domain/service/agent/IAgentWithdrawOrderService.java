package com.pokerstar.api.domain.service.agent;

import com.pokerstar.api.domain.entity.agent.AgentWithdrawOrder;

import java.util.List;

public interface IAgentWithdrawOrderService {
    boolean addAgentWithdrawOrder(AgentWithdrawOrder entity);

    int deleteAgentWithdrawOrder(int agentWithdrawOrderId);

    List<AgentWithdrawOrder> getAllAgentWithdrawOrder();

    int updateAgentWithdrawOrderStatus(int agentWithdrawOrderId, int status);

    int updateAgentWithdrawOrderOperation(AgentWithdrawOrder param);
}
