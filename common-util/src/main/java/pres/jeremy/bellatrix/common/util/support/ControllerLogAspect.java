package pres.jeremy.bellatrix.common.util.support;

import cn.hutool.core.date.SystemClock;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pres.jeremy.bellatrix.common.util.utils.UserUtil;
import pres.jeremy.bellatrix.user.dto.UserDTO;

@Component
@Slf4j
@Aspect
public class ControllerLogAspect {

    @Around(value = "@within(controllerLog) || @annotation(controllerLog)")
    public Object round(ProceedingJoinPoint joinPoint, EnableControllerLog controllerLog) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        StringBuilder logContext = new StringBuilder(joinPoint.getTarget().getClass().getSimpleName())
                .append("#").append(methodSignature.getName());
        StringBuilder paramContext = new StringBuilder(logContext);
        for (String parameterName : parameterNames) {
            paramContext.append(parameterName).append("=>【{}】;");
        }
        UserDTO user = UserUtil.getUser();
        if (user != null && StringUtils.isNotEmpty(user.getName())) {
            log.info("operator:【{}】", user.getName());
        }
        log.info(paramContext.toString(), joinPoint.getArgs());
        long startTime = SystemClock.now();
        Object proceed = joinPoint.proceed();
        log.info(logContext.append(" consuming 【{}】 ms").toString(), SystemClock.now() - startTime);
        return proceed;
    }
}
