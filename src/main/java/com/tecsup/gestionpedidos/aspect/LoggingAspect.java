package com.tecsup.gestionpedidos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.tecsup.gestionpedidos.service.*.*(..))")
    public void antesDeEjecutar(JoinPoint joinPoint) {
        System.out.println("Iniciando método: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.tecsup.gestionpedidos.service.*.*(..))")
    public void despuesDeEjecutar(JoinPoint joinPoint) {
        System.out.println("Finalizando método: " + joinPoint.getSignature().getName());
    }
}