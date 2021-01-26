package com.pokerstar.api.domain.serviceimpl.admin;

import com.pokerstar.api.domain.dao.admin.IAdminDao;
import com.pokerstar.api.domain.entity.admin.Admin;
import com.pokerstar.api.domain.service.admin.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminDao adminDao;

    @Override
    public boolean addAdmin(Admin entity) {
        return adminDao.addAdmin(entity);
    }

    @Override
    public int deleteAdmin(int adminId) {
        return adminDao.deleteAdmin(adminId);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public int updateAdmin(Admin param) {
        return adminDao.updateAdmin(param);
    }

    @Override
    public int toggleAdminStatus(int adminId, int status) {
        return adminDao.toggleAdminStatus(adminId, status);
    }
}
