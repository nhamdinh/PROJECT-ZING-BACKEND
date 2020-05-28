package com.codegym;


import com.codegym.model.Role;
import com.codegym.service.*;
import com.codegym.service.Impl.AlbumServiceImpl;
import com.codegym.service.Impl.SingerServiceImpl;
import com.codegym.service.Impl.UsersServiceImpl;
import com.codegym.service.SongService;
import com.codegym.service.Impl.SongServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableSpringDataWebSupport
@PropertySource("classpath:global_config_app.properties")
@ComponentScan("com.codegym")
@EnableJpaRepositories("com.codegym.repository")
public class AppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Autowired
    Environment environment;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.codegym.model"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/project_zing?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("password1");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        return messageSource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }


    @Bean
    public SongService songService() {
        return new SongServiceImpl();
    }

    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl();
    }

    @Bean
    public Role roleUser(){
        return new Role(1L,"ROLE_USER");
    }

    @Bean
    public Role roleAdmin(){
        return new Role(2L,"ROLE_ADMIN");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String imageUpload = environment.getProperty("image_upload").toString();
        String audioUploadUpload = environment.getProperty("audio_upload").toString();

        registry.addResourceHandler("/i/**")
                .addResourceLocations("file:" + imageUpload);
        registry.addResourceHandler("/i/**")
                .addResourceLocations("file:" + audioUploadUpload);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(5242880);

        return resolver;

    }

    @Bean
    public AlbumService albumService(){
        return new AlbumServiceImpl();
    }

    @Bean
    public SingerService singerService(){
        return new SingerServiceImpl();
    }

}
