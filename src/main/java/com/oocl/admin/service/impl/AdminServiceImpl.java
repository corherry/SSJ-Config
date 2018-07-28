package com.oocl.admin.service.impl;

import com.oocl.admin.dao.IAdminDao;
import com.oocl.admin.model.Admin;
import com.oocl.admin.service.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements IAdminService{

    @Resource(name = "adminDao")
    private IAdminDao adminDao;

    @Transactional
    public void register(Admin admin) {
        adminDao.addAdmin(admin);
    }
}
