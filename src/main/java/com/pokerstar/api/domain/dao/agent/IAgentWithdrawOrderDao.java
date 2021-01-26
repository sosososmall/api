package com.pokerstar.api.domain.dao.agent;

import com.pokerstar.api.domain.entity.agent.AgentWithdrawOrder;
import com.pokerstar.api.domain.model.agent.AgentWithdrawOrderOperation;

import java.util.List;

public interface IAgentWithdrawOrderDao {
    boolean addAgentWithdrawOrder(AgentWithdrawOrder entity);

    int deleteAgentWithdrawOrder(int agentWithdrawOrderId);

    List<AgentWithdrawOrder> getAllAgentWithdrawOrder();

    int updateAgentWithdrawOrderStatus(int agentWithdrawOrderId, int status);

    int updateAgentWithdrawOrderOperation(AgentWithdrawOrderOperation param);
}
