package com.pokerstar.api.domain.mapper.admin;

import com.pokerstar.api.domain.entity.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("adminMapper")
public interface AdminMapper {
    boolean addAdmin(Admin entity);

    int deleteAdmin(int adminId);

    List<Admin> getAllAdmin();

    int updateAdmin(Admin param);

    int toggleAdminStatus(@Param("adminId") int adminId, @Param("status") int status);
}
