package com.kunchi.common.aop;

import com.kunchi.common.response.ResponseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class ValidatorInterceptor {
    @Around( "execution(* com.kunchi.service.*.*(..)) && args(..,bindingResult)" )
    public Object validateParam(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable {

        StringBuilder sb=new StringBuilder();

        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().stream().forEach(p->{
                sb.append(p.getDefaultMessage());
                sb.append(",");
            });

            return new ResponseResult<Object>(false,sb.toString().substring(0,sb.length()-1),null);
        }

        return  pjp.proceed();
    }
}
