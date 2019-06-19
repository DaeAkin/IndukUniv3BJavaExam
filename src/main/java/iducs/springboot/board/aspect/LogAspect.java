package iducs.springboot.board.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    Logger logger =  LoggerFactory.getLogger(LogAspect.class);
    /*
     * UserService의 모든 메서드에 대하여 어드바이스 지정
     * Around는 Advice의 동작시점 중 하나로 메소드 호출 전, 후, 예외 발생등 모든 시점에 서 동작
     * "execution(* iducs.springboot.board.service.*Service.*(..))" <- 포인트 컷 표현식
     * 
     * @Around("execution(* iducs.springboot.board.controller..*.*(..))")
     * @Around("execution(* iducs.springboot.board..*.*(..))")
     */    
    @Around("execution(* iducs.springboot.board.service.*Service.*(..))")
    
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + 
        		" / " + pjp.getSignature().getName() + "()");
        Object result = pjp.proceed();
        logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + 
        		" / " + pjp.getSignature().getName());
        return result;
    }
}