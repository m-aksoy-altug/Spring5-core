package com.spring.core.aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.spring.domain.DummyDomain;

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
	// Before Advice: Executes before the method is invoked
   @Before("execution(* com.spring.core.servicejava.*.*(..))") 
    public void logBeforeMethod(JoinPoint joinPoint) {
	   
        System.out.println("[AOP] Before Method: " + joinPoint.getSignature().getName());
    }
   
   // AfterReturning Advice: Executes after the method successfully returns a result
    @AfterReturning(value = "execution(* com.spring.core.servicejava.*.*(..))", 
    		returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) { // can be direct Object, no need to cast it.
    	DummyDomain resultDomain = (result instanceof DummyDomain) ? (DummyDomain) result : null;
        System.out.println("[AOP] After Method: " + joinPoint.getSignature().getName() + " | Returned: " + resultDomain.toString());
    }
    
    // After Advice: Executes after the method completes, regardless of success or exception
    @After("execution(* com.spring.core.servicejava.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        System.out.println("[AOP] After (Finally Block Equivalent): " + joinPoint.getSignature().getName());
    }
    
    // After Throwing Advice: Executes after the method throws exception, it won't handle the exception
    @AfterThrowing(pointcut = "execution(* com.spring.core.servicejava.*.*(..))", throwing = "ex")
    public void logException(Exception ex) {
        System.out.println("[AOP] [EXCEPTION] Exception Occurred: " + ex.getMessage());
    }
    
    // Around Advice: Executes before and after JoinPoint, regardless of success or exception
    @Around("execution(* com.spring.core.repo.*.*(..))")
    public Object inspectModifyMeasure(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // Execute custom behaviour both before and after joinpoint.
        // Access to return value of joinpoint, can modify the value and return the modified value back to client
        // Access to method arguments of joinpoint, can modify the arguments and pass the modified arguments to client
        Object[] args= joinPoint.getArgs();
        System.out.println("[AOP] [INSPECT/MODIFY ARGS]" + joinPoint.getSignature().getName() +
        		"args :"+Arrays.toString(args));        
        Object result = joinPoint.proceed(args); // Execute the actual method with args
        // Object result = joinPoint.proceed(); // Execute the actual method
        long endTime = System.currentTimeMillis();
        System.out.println("[AOP] [PERFORMANCE] Execution time of " + joinPoint.getSignature().getName() +
                ": " + (endTime - startTime) + "ms");
        return result;
    }
    
}
