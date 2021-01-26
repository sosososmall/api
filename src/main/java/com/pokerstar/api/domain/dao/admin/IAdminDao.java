package com.pokerstar.api.domain.dao.admin;

import com.pokerstar.api.domain.entity.admin.Admin;

import java.util.List;

public interface IAdminDao {
    boolean addAdmin(Admin entity);

    int deleteAdmin(int adminId);

    List<Admin> getAllAdmin();

    int updateAdmin(Admin param);

    int toggleAdminStatus(int adminId, int status);
}
