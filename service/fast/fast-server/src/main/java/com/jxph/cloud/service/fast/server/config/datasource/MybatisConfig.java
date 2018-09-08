package com.jxph.cloud.service.fast.server.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author 谢秋豪
 * @date 2018/9/1 0:07
 */
@Configuration
@Slf4j
public class MybatisConfig {
    /*@Autowired
    @Qualifier(DataSourceConstant.DATASOURCE_NAME_FIRST)
    private DataSource firstDB;
    @Autowired
    @Qualifier(DataSourceConstant.DATASOURCE_NAME_SECOND)
    private DataSource secondDB;*/

    /*@Value("${mybatis.mapper-locations}")
    private String mapperLocations;*/

    /*@Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceConstant.DATASOURCE_NAME_FIRST, firstDB);
        targetDataSources.put(DataSourceConstant.DATASOURCE_NAME_SECOND, secondDB);
        return new DynamicDataSource(firstDB, targetDataSources);
    }*/

   /* @Bean(name="sqlSessionFactory")
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            sqlSessionFactoryBean.setDataSource(dataSource);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
            //-- 加载mybatis的全局配置文件
            //Resource mybatisConfigXml = resolver.getResource("classpath:mybatis/mybatis-config.xml");
            //sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        } catch (IOException e) {
            log.error("sqlSession error:{}",e);
        }
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.jxph.cloud.service.fast.server.dao");
        return mapperScannerConfigurer;
    }*/
}
