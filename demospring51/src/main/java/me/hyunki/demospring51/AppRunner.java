package me.hyunki.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // >> class org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
        System.out.println(resourceLoader.getClass());

        // 1. "classpath:" 라는 prefix를 줬을 경우
        // >> class org.springframework.core.io.ClassPathResource
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println(resource.getClass());
        System.out.println(resource.exists());

        // 2. prefix를 주지 않았을 경우 에는, ServletContextResource
        // >> 기본적으로 ServletContextResource가 되기 때문에 context path 부터 resource를 찾게된다.
        // >> 그러나 스프링 부트 톰캣의 context path에는 경로가 지정되어 있지 않기 때문에 resource를 찾을 수 없기 때문에 false.
        // classpath를 항상 꼭 명시 해주는게 좋다.
        resource = resourceLoader.getResource("test.txt");
        System.out.println(resource.getClass());
        System.out.println(resource.exists()); // false
    }
}
