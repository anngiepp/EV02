package com.tecsup.gestionpedidos.aspect;

import com.tecsup.gestionpedidos.entity.AuditoriaLog;
import com.tecsup.gestionpedidos.repository.AuditoriaLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Aspect
@Component
public class AuditoriaAspect {

    private final AuditoriaLogRepository auditoriaLogRepository;

    public AuditoriaAspect(AuditoriaLogRepository auditoriaLogRepository) {
        this.auditoriaLogRepository = auditoriaLogRepository;
    }

    @AfterReturning("execution(* com.tecsup.gestionpedidos.service.*.guardar(..)) || " +
            "execution(* com.tecsup.gestionpedidos.service.*.actualizar(..)) || " +
            "execution(* com.tecsup.gestionpedidos.service.*.eliminar(..)) || " +
            "execution(* com.tecsup.gestionpedidos.service.PedidoService.registrarPedido(..))")
    public void registrarAuditoria(JoinPoint joinPoint) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String usuario = "desconocido";

        if (auth != null && auth.isAuthenticated()) {
            usuario = auth.getName();
        }

        AuditoriaLog log = new AuditoriaLog();
        log.setAccion("Operación ejecutada");
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(Timestamp.valueOf(LocalDateTime.now()));
        log.setUsuario(usuario);

        auditoriaLogRepository.save(log);
    }
}