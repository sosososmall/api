package com.pokerstar.api.domain.mapper.admin;

import com.pokerstar.api.domain.entity.admin.AdminLog;
import com.pokerstar.api.domain.entity.admin.AdminLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("adminLogMapper")
public interface AdminLogMapper {
    boolean addAdminLog(AdminLog entity);

    boolean addAdminLoginLog(AdminLoginLog entity);

    List<AdminLog> getAllAdminLog();

    List<AdminLoginLog> getAllAdminLoginLog();
}
