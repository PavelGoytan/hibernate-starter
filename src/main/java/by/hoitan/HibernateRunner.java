package by.hoitan;


import by.hoitan.entity.*;
import by.hoitan.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;



public class HibernateRunner {

    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Google")
                .build();

        User user3 = User.builder()
                .userName("petr4@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .firstName("Petr")
                        .lastName("Petrov")
                        .birthDate(new Birthday(LocalDate.of(2000, 12,1)))
                        .build())
                .role(Role.USER)
                .build();


        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(company);
            session.saveOrUpdate(user3);

            //session.delete(user);


            session.getTransaction().commit();
        }
    }
}
