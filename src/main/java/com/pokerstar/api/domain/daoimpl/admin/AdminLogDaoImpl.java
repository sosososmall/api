package com.pokerstar.api.domain.daoimpl.admin;

import com.pokerstar.api.domain.dao.admin.IAdminLogDao;
import com.pokerstar.api.domain.entity.admin.AdminLog;
import com.pokerstar.api.domain.entity.admin.AdminLoginLog;
import com.pokerstar.api.domain.mapper.admin.AdminLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminLogDaoImpl implements IAdminLogDao {

    @Autowired
    private AdminLogMapper adminLogMapper;


    @Override
    public boolean addAdminLog(AdminLog entity) {
        return adminLogMapper.addAdminLog(entity);
    }

    @Override
    public boolean addAdminLoginLog(AdminLoginLog entity) {
        return adminLogMapper.addAdminLoginLog(entity);
    }

    @Override
    public List<AdminLog> getAllAdminLog() {
        return adminLogMapper.getAllAdminLog();
    }

    @Override
    public List<AdminLoginLog> getAllAdminLoginLog() {
        return adminLogMapper.getAllAdminLoginLog();
    }
}
