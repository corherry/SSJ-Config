package com.oocl.admin.aspect;

import com.oocl.admin.model.Admin;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EncryptAspect {

    @Pointcut("execution(public * login (..)) || execution(public * register (..))")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint  pjp) throws Throwable {
        Object args[] = pjp.getArgs();
        Admin admin = (Admin) args[0];
        String password = admin.getPassword();
        admin.setPassword(DigestUtils.md5Hex(password));
        args[0] = admin;
        admin = (Admin) pjp.proceed(args);
        return admin;
    }
}
