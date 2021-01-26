package com.pokerstar.api.domain.daoimpl.admin;

import com.pokerstar.api.domain.dao.admin.IAdminDao;
import com.pokerstar.api.domain.entity.admin.Admin;
import com.pokerstar.api.domain.mapper.admin.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDaoImpl implements IAdminDao {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean addAdmin(Admin entity) {
        return adminMapper.addAdmin(entity);
    }

    @Override
    public int deleteAdmin(int adminId) {
        return adminMapper.deleteAdmin(adminId);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminMapper.getAllAdmin();
    }

    @Override
    public int updateAdmin(Admin param) {
        return adminMapper.updateAdmin(param);
    }

    @Override
    public int toggleAdminStatus(int adminId, int status) {
        return adminMapper.toggleAdminStatus(adminId, status);
    }
}
