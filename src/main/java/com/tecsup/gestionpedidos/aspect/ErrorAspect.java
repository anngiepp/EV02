package com.tecsup.gestionpedidos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorAspect {

    @AfterThrowing(
            pointcut = "execution(* com.tecsup.gestionpedidos.service.*.*(..))",
            throwing = "ex"
    )
    public void capturarError(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Error en método: " + joinPoint.getSignature().getName());
        System.out.println("Mensaje del error: " + ex.getMessage());
    }
}