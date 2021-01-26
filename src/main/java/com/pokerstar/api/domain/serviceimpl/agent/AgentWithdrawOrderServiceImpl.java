package com.pokerstar.api.domain.serviceimpl.agent;

import com.pokerstar.api.domain.dao.agent.IAgentWithdrawOrderDao;
import com.pokerstar.api.domain.entity.agent.AgentWithdrawOrder;
import com.pokerstar.api.domain.model.agent.AgentWithdrawOrderOperation;
import com.pokerstar.api.domain.service.agent.IAgentWithdrawOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentWithdrawOrderServiceImpl implements IAgentWithdrawOrderService {
    @Autowired
    private IAgentWithdrawOrderDao agentWithdrawOrderDao;

    @Override
    public boolean addAgentWithdrawOrder(AgentWithdrawOrder entity) {
        return agentWithdrawOrderDao.addAgentWithdrawOrder(entity);
    }

    @Override
    public int deleteAgentWithdrawOrder(int agentWithdrawOrderId) {
        return agentWithdrawOrderDao.deleteAgentWithdrawOrder(agentWithdrawOrderId);
    }

    @Override
    public List<AgentWithdrawOrder> getAllAgentWithdrawOrder() {
        return agentWithdrawOrderDao.getAllAgentWithdrawOrder();
    }

    @Override
    public int updateAgentWithdrawOrderStatus(int agentWithdrawOrderId, int status) {
        return agentWithdrawOrderDao.updateAgentWithdrawOrderStatus(agentWithdrawOrderId, status);
    }

    @Override
    public int updateAgentWithdrawOrderOperation(AgentWithdrawOrderOperation param) {
        return agentWithdrawOrderDao.updateAgentWithdrawOrderOperation(param);
    }
}
