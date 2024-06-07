package homework.buy.config;


import homework.buy.aspects.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@ComponentScan(basePackages = "com.example.shop_with_aspects")
//@EnableAspectJAutoProxy
@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
    }

}
