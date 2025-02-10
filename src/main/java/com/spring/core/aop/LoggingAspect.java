package com.spring.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  
@Component
public class LoggingAspect {
	/**
	 * @Before: Advice type
	 * "execution(* com.spring.core.servicejava.*.*(..))" : Pointcut expression
	 *	execution: Designator
	 *	* : Return type, any
	 * com.spring.core.servicejava: package.class
	 * *.* : method any
	 * *(..) : parameters, zero or multiple arguments
	 * @param joinPoint Provides metadata about the intercepted method call.
	 */
   @Before("execution(* com.spring.core.servicejava.*.*(..))") 
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("[AOP] Before Method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.spring.core.servicejava.*.*(..))", 
    		returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        System.out.println("[AOP] After Method: " + joinPoint.getSignature().getName() + " | Returned: " + result);
    }
}
