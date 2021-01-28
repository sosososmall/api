package com.pokerstar.api.domain.mapper.agent;

import com.pokerstar.api.domain.entity.agent.AgentBalance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("agentBalanceMapper")
public interface AgentBalanceMapper {
    boolean addAgentBalance(AgentBalance entity);

    int deleteAgentBalance(int agentBalanceId);

    int deleteAgentBalanceByAgentId(int agentId);

    List<AgentBalance> getAllAgentBalance();

    AgentBalance getAgentBalanceById(int agentBalanceId);

    List<AgentBalance> lstAgentBalance(int agentId);

    int updateAgentBalance(AgentBalance param);
}
