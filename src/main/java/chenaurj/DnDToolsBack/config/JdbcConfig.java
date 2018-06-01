package chenaurj.DnDToolsBack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import chenaurj.DnDToolsBack.BasePackageTarget;

@Configuration
@ComponentScan(basePackageClasses = {BasePackageTarget.class})
@EnableTransactionManagement
@EnableWebMvc
public class JdbcConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dndtools");
		dataSource.setUsername("root");
		dataSource.setPassword("ScaryPumpkinBaby6146");
		
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(DriverManagerDataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		return jdbcTemplate;
	}
	
}
