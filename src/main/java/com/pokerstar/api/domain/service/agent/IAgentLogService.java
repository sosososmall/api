package com.pokerstar.api.domain.service.agent;

import com.pokerstar.api.domain.entity.agent.AgentBalanceLog;
import com.pokerstar.api.domain.entity.agent.AgentLoginLog;

import java.util.List;

public interface IAgentLogService {
    boolean addAgentLoginLog(AgentLoginLog entity);

    boolean addAgentBalanceLog(AgentBalanceLog entity);

    int deleteAgentLoginLog(long endTimestamp);

    int deleteAgentBalanceLog(long endTimestamp);

    List<AgentLoginLog> getAllAgentLoginLog();

    List<AgentBalanceLog> getAllAgentBalanceLog();
}
