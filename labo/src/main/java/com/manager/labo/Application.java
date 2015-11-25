package com.manager.labo;

import com.manager.labo.entities.Icd;
import com.manager.labo.service.IcdService;
import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Piotr
 */
@Transactional
public class Application {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IcdService icdService = context.getBean(IcdService.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Icd icd = icdService.getById(1L);

        context.close();


        System.out.println("App");
    }
}
