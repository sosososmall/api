package com.pokerstar.api.domain.mapper.agent;

import com.pokerstar.api.domain.entity.agent.AgentBalance;
import com.pokerstar.api.domain.entity.agent.AgentBalanceLog;
import com.pokerstar.api.domain.entity.agent.AgentLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("agentLogMapper")
public interface AgentLogMapper {
    boolean addAgentLoginLog(AgentLoginLog entity);

    boolean addAgentBalanceLog(AgentBalanceLog entity);

    int deleteAgentLoginLog(long endTimestamp);

    int deleteAgentBalanceLog(long endTimestamp);

    List<AgentLoginLog> getAllAgentLoginLog();

    List<AgentBalanceLog> getAllAgentBalanceLog();

    int updateAgentBalance(AgentBalance param);
}
