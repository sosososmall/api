package com.pokerstar.api.domain.daoimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentWithdrawOrderDao;
import com.pokerstar.api.domain.entity.agent.AgentWithdrawOrder;
import com.pokerstar.api.domain.mapper.agent.AgentWithdrawOrderMapper;
import com.pokerstar.api.domain.model.agent.AgentWithdrawOrderOperationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgentWithdrawOrderDaoImpl implements IAgentWithdrawOrderDao {
    @Autowired
    private AgentWithdrawOrderMapper agentWithdrawOrderMapper;


    @Override
    public boolean addAgentWithdrawOrder(AgentWithdrawOrder entity) {
        return agentWithdrawOrderMapper.addAgentWithdrawOrder(entity);
    }

    @Override
    public int deleteAgentWithdrawOrder(int agentWithdrawOrderId) {
        return agentWithdrawOrderMapper.deleteAgentWithdrawOrder(agentWithdrawOrderId);
    }

    @Override
    public List<AgentWithdrawOrder> getAllAgentWithdrawOrder() {
        return agentWithdrawOrderMapper.getAllAgentWithdrawOrder();
    }

    @Override
    public int updateAgentWithdrawOrderStatus(int agentWithdrawOrderId, int status) {
        return agentWithdrawOrderMapper.updateAgentWithdrawOrderStatus(agentWithdrawOrderId, status);
    }

    @Override
    public int updateAgentWithdrawOrderOperation(AgentWithdrawOrderOperationBO param) {
        return agentWithdrawOrderMapper.updateAgentWithdrawOrderOperation(param);
    }
}
