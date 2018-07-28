package com.oocl.admin.dao.impl;

import com.oocl.admin.dao.IAdminDao;
import com.oocl.admin.model.Admin;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("adminDao")
public class AdminDaoImpl implements IAdminDao{

    @PersistenceContext(name = "em")
    private EntityManager em;

    public void addAdmin(Admin admin) {
        em.persist(admin);
    }
}
