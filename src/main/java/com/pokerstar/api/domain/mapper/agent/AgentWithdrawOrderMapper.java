package com.pokerstar.api.domain.mapper.agent;

import com.pokerstar.api.domain.entity.agent.AgentWithdrawOrder;
import com.pokerstar.api.domain.model.agent.AgentWithdrawOrderOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("agentWithdrawOrderMapper")
public interface AgentWithdrawOrderMapper {
    boolean addAgentWithdrawOrder(AgentWithdrawOrder entity);

    int deleteAgentWithdrawOrder(int agentWithdrawOrderId);

    List<AgentWithdrawOrder> getAllAgentWithdrawOrder();

    int updateAgentWithdrawOrderStatus(@Param("agentWithdrawOrderId") int agentWithdrawOrderId, @Param("status") int status);

    int updateAgentWithdrawOrderOperation(AgentWithdrawOrderOperation param);
}
