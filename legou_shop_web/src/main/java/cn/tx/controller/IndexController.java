package cn.tx.controller;

import cn.tx.entity.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 登陆成功面用的的 controller
 */
@RestController
@RequestMapping("index")
public class IndexController {

    /**
     * 返回当前用户的用户名
     *
     * @return
     */
    @RequestMapping("findLoginname")
    public Result findLoginname() {
        Result result = null;

        try {
            // SecurityContextHolder 维护 SecurityContext
            // 调用静态方法 getContext 返回springSecurity 静态对象
            SecurityContext context = SecurityContextHolder.getContext();

            //Authentication: 认证方式
            // springSecurity 的加密方式 存储着用户名 密码加密方式等等
            Authentication authentication = context.getAuthentication();
            String name = authentication.getName();
            // 该用户的权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            Object credentials = authentication.getCredentials();
            Object principal = authentication.getPrincipal();


            System.out.println("credentials" + credentials);
            System.out.println("authorities" + authorities);
            System.out.println("name" + name);
            System.out.println("principal" + principal);
            result = new Result(true, "获取用户名成功", name);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "获取用户名失败");
        }
        return result;
    }
}
