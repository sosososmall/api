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

    List<AgentBalance> getAllAgentBalance();

    int updateAgentBalance(AgentBalance param);
}
