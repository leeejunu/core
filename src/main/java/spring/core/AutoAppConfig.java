package spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


/**
 * basePackages와 basePackageClasses 설정하지 않은 default @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
 * AutoAppConfig의 위치 package spring.core 하위는 다 뒤진다.
 */
@ComponentScan(
        basePackages = "spring.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
@Configuration
public class AutoAppConfig {
}
