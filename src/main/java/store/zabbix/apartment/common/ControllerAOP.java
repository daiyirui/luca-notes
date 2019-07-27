package store.zabbix.apartment.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * description: 全局异常处理
 *
 * @author eyck.cui update: 2019-07-25 00:41
 **/
@Component
@Aspect
@Slf4j
public class ControllerAOP {

    //切点方法
    @Pointcut(value = "execution(public store.zabbix.apartment.common.*ResultBean *(..))")
    public void pointResultBean(){}


    @Around(value = "pointResultBean()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;
        try {
            result = (ResultBean<?>) pjp.proceed();
            log.info( "{} 耗时:{} ms", pjp.getSignature() ,  (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }


    /**
     * 封装异常信息，注意区分已知异常（自己抛出的）和未知异常
     */
    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("错误信息[").append(e.getLocalizedMessage()).append("]错误详细信息===》").append(Arrays.toString(e.getStackTrace()));
        log.error(stringBuilder.toString());
        result.setMsg(stringBuilder.toString());
        result.setCode(ResultBean.FAIL);
        return result;
    }

}
