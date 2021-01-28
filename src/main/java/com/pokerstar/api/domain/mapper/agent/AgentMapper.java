package com.pokerstar.api.domain.mapper.agent;

import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.model.agent.AgentBankBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("agentMapper")
public interface AgentMapper {
    boolean addAgent(Agent entity);

    int deleteAgent(int agentId);

    List<Agent> getAllAgent();

    Agent getAgentById(int agentId);

    int updateAgent(Agent param);

    int toggleAgentStatus(@Param("agentId") int agentId, @Param("status") int status);

    int updateAgentBankInfo(AgentBankBO param);

    int updateAgentPassword(@Param("agentId") int agentId, @Param("password") String password);

    int updateAgentWithdrawPassword(@Param("agentId") int agentId, @Param("withdrawPassword") String withdrawPassword);
}
