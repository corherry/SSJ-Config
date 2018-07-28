package com.oocl.admin.controller;

import com.oocl.admin.model.Admin;
import com.oocl.admin.service.IAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "adminService")
    private IAdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Admin register(Admin admin){
        adminService.register(admin);
        return admin;
    }
}
