package com.pokerstar.api.domain.serviceimpl.admin;

import com.pokerstar.api.domain.dao.admin.IAdminLogDao;
import com.pokerstar.api.domain.entity.admin.AdminLog;
import com.pokerstar.api.domain.entity.admin.AdminLoginLog;
import com.pokerstar.api.domain.service.admin.IAdminLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLogServiceImpl implements IAdminLogService {
    @Autowired
    private IAdminLogDao adminLogDao;

    @Override
    public boolean addAdminLog(AdminLog entity) {
        return adminLogDao.addAdminLog(entity);
    }

    @Override
    public boolean addAdminLoginLog(AdminLoginLog entity) {
        return adminLogDao.addAdminLoginLog(entity);
    }

    @Override
    public List<AdminLog> getAllAdminLog() {
        return adminLogDao.getAllAdminLog();
    }

    @Override
    public List<AdminLoginLog> getAllAdminLoginLog() {
        return adminLogDao.getAllAdminLoginLog();
    }
}
