package com.example.jpa.auditing;

import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

/**
 * @author : zhaojh
 * @date : 2019-07-27
 * @function :实现AauditorAware接口告诉jpa当前用户是谁
 */

public class ArticleAuditingAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        /**
         * 第一种实现方式；如果使用spring的security，直接通过一下方式获取当前请求的用户
         *
         */


        /**
         * 第二种实现方式 通过request去session中直接获取
         */
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object userId = requestAttributes.getRequest().getSession().getAttribute("user_id");

        return Optional.empty();
    }
}
