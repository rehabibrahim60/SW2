package com.example.demo.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint.*;
import org.aspectj.lang.ProceedingJoinPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;
//import org.apache.lang3.StringUtils;


@Aspect
@Component
public class LogTimeAspect {
   Logger log = LoggerFactory.getLogger(LogTimeAspect.class);
   //AOP1
   @Around(value= "execution (* com.example.demo..*(..,long))")
   public object logTime(ProceedingJoinPoint joinPoint) throws Throwable{
       long startTime =System.currentTimeMillis();
       StringBuilder sb =new StringBuilder("KPI");
       sb.append("[").append(joinPoint.getKind()).append("] \t for: ").append(joinPoint.getSignature())
               .append("\t withArgs: ").append("(").append(StringUtils.join(Joinpoint.getArgs(), ",")).append(")");
       sb.append("\t took:");

       object returnValue=joinPoint.proceed();

       Log.info(sb.append(System.currentTimeMillis() - startTime).append("ms.").toString());
   }


//AOP2
//layers
    @Pointcut(value="execution (* com.com.section1.section1.repository.*(..,long))")
    public void forRepositoryLog(){}

    @Pointcut(value="execution (* com.com.section1.section1.service.*(..,long))")
    public void forServiceLog(){}

    @Pointcut(value="execution (* com.com.section1.section1.controller.*(..,long))")
    public void forControllerLog(){}


    @Pointcut (value="forRepositoryLog() || forServiceLog() || forControllerLog()")
    public void forAllApp(){}

    @Before(value="forAllApp")
    public void beforeMethod(){
    String methodName = joinPoint.getSignature().getName();

    log.info("-----> Method Name is : ",methodName);

    Object [] args = JoinPoint.getArgs();
    for (Object arg : args){

        log.info("-----> with argument : ",arg);

    }

}
}