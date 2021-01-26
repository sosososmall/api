package com.pokerstar.api.domain.dao.admin;

import com.pokerstar.api.domain.entity.admin.AdminLog;
import com.pokerstar.api.domain.entity.admin.AdminLoginLog;

import java.util.List;

public interface IAdminLogDao {
    boolean addAdminLog(AdminLog entity);

    boolean addAdminLoginLog(AdminLoginLog entity);

    List<AdminLog> getAllAdminLog();

    List<AdminLoginLog> getAllAdminLoginLog();
}
