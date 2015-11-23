package com.manager.labo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.sql.SQLException;

/**
 * Created by Piotr on 2015-11-23.
 */
public class Application {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("hibernate-context.xml", "applicationContext.xml");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        sessionFactory.getCurrentSession();

        context.close();
        System.out.println("App");
    }
}
