package com.pokerstar.api.domain.controller.admin;

import com.pokerstar.api.domain.entity.admin.Admin;
import com.pokerstar.api.domain.service.admin.IAdminLogService;
import com.pokerstar.api.domain.service.admin.IAdminService;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {
    private static Logger Log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IAdminLogService adminLogService;

    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Result addAdmin(@RequestBody Admin admin) {
        try {
            admin.setAdmin_create_time(DateTimeUtil.getCurrentSecondTimestamp());
            return Result.success(adminService.addAdmin(admin));
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

    @PostMapping
    @ResponseBody
    @RequestMapping("/login")
    public Result adminLogIn(@RequestParam(value = "account") String account,
                             @RequestParam(value = "password") String password) {
        try {

            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }
}
