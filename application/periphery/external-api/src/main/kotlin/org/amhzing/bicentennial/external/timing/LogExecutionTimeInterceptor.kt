package org.amhzing.bicentennial.external.timing

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Component
@Aspect
class LogExecutionTimeInterceptor {

    @Around("anyPublicOperation() && @annotation(org.amhzing.bicentennial.external.timing.LogExecutionTime)")
    @Throws(Throwable::class)
    fun logExecutionTaken(joinPoint: ProceedingJoinPoint): Any {
        val nameOfClass = joinPoint.target.toString()
        val logger = LoggerFactory.getLogger(nameOfClass)

        val shortDescr = joinPoint.toShortString()
        val nameOfMethod = joinPoint.signature.name

        val sw = StopWatch()

        // Start the stopwatch
        sw.start(nameOfMethod)

        // Invoke method
        val retVal = joinPoint.proceed()

        // Stop the stopwatch
        sw.stop()

        val totalTimeMillis = java.lang.Long.valueOf(sw.totalTimeMillis)

        logger.info("{} took {}ms", *arrayOf(shortDescr, totalTimeMillis))

        return retVal
    }

    @Pointcut("execution(public * *(..))")
    private fun anyPublicOperation() {
        // Any public method with or without arguments
    }
}