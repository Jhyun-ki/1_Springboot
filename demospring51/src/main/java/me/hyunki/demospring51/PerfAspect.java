package me.hyunki.demospring51;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    // logPerf 함수 : AOP의 advice(해야 할 일)에 해당함.
    // pjp : advice가 적용되는 대상 (Ex: createEvent, publishEvent)
    // @Around : advice를 어떻게 적용할 것인가. 메서드를 감싸는형태로 적용됨, 메서드 호출 이전 이후 Exception 시에도 특정한 일을 할 수 있다.
    // @Around("execution(* me.hyunki..*.EventService.*(..))") -> EventService 안에 있는 모든 메서드에 아래의 행위를 적용 하라는 뜻 (PointCut을 정의함)
    // @Around("bean(simpleEventService)") : bean을 사용 -> 해당 bean의 모든 메서드에 적용되어 버리는 단점
    @Around("@annotation(PerfLogging)") // Delete에는 적용하고 싶지 않기 때문에 어노테이션이 있는 곳에만 실행 되게끔 설정함. (이게 가장 유용함)
    //원본 코드에 수정이나 추가 없이 많은 클래스에 아래의 행위를 끼워 넣을수 있다.
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed(); //메서드 실행
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    //모든 메서드 실행 이전에 hello가 찍힘
    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("hello");
    }
}
