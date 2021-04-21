package me.hyunki.demospring51;

import java.lang.annotation.*;

/**
 * 이 에노테이션을 사용하면 성능을 로깅해 줍니다.
 *
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS) //기본 값이 클래스
public @interface PerfLogging {
}
