package com.pokerstar.api.domain.service.admin;

import com.pokerstar.api.domain.entity.admin.AdminLog;
import com.pokerstar.api.domain.entity.admin.AdminLoginLog;

import java.util.List;

public interface IAdminLogService {
    boolean addAdminLog(AdminLog entity);

    boolean addAdminLoginLog(AdminLoginLog entity);

    List<AdminLog> getAllAdminLog();

    List<AdminLoginLog> getAllAdminLoginLog();
}
