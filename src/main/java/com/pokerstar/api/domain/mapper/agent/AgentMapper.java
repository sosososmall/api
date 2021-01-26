package com.pokerstar.api.domain.mapper.agent;

import com.pokerstar.api.domain.entity.agent.Agent;
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

    int updateAgent(Agent param);

    int toggleAgentStatus(@Param("agentId") int agentId, @Param("status") int status);
}
