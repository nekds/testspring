package su.xlegion.testspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "su.xlegion.testspring.repository")
@SpringBootApplication
public class TestSpringApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(TestSpringApplication.class, args);
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		//dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("spring");
		dataSource.setPassword("spring");
		dataSource.setUrl(
				"jdbc:mysql://localhost:3306/spring?createDatabaseIfNotExist=true&useUnicode=true&serverTimezone=UTC");
		return dataSource;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		return new LocalContainerEntityManagerFactoryBean() {
			{
				setDataSource(dataSource());
				//setPersistenceUnitName(this.getPersistenceUnitName());// "jpaData");
				setJpaVendorAdapter(new HibernateJpaVendorAdapter(){{
					setShowSql(false);
					setGenerateDdl(true);
					setDatabase(Database.MYSQL);
				}});
				//setPersistenceUnitName("jpaData");
				setJpaProperties(new Properties() {{
					put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
					put("hibernate.show_sql", true);
					put("hibernate.format_sql", false);
					put("hibernate.use_sql_comments", true);
					put("hibernate.hbm2ddl.auto", "create");
					put("hibernate.max_fetch_depth", 3);
					put("hibernate.jdbc.batch_size", 10);
					put("hibernate.jdbc.fetch_size", 50);
				}});
				setPackagesToScan("su.xlegion.testspring.entity");
				setPersistenceUnitName("jpaData");
			}};
	}
	@Bean
	public JpaTransactionManager transactionManager() throws IOException {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return jpaTransactionManager;
//		HibernateTransactionManager transactionManager =
//				new HibernateTransactionManager(sessionFactory());

//		return transactionManager;
	}
}
