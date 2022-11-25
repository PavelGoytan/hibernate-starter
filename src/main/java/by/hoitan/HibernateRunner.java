package by.hoitan;


import by.hoitan.entity.Birthday;
import by.hoitan.entity.PersonalInfo;
import by.hoitan.entity.Role;
import by.hoitan.entity.User;
import by.hoitan.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;



public class HibernateRunner {

    public static void main(String[] args) {

        User user3 = User.builder()
                .userName("petr3@gmail.com")
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
            session.saveOrUpdate(user3);

            //session.delete(user);


            session.getTransaction().commit();
        }
    }
}
