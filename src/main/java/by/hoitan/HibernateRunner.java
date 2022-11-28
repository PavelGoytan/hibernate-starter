package by.hoitan;


import by.hoitan.entity.*;
import by.hoitan.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;


public class HibernateRunner {

    public static void main(String[] args) {

        User user = User.builder()
                .userName("sasha3@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .lastName("Sasha")
                        .firstName("Sasha")
                        .birthDate(new Birthday(LocalDate.of(2000, 1, 2)))
                        .build())
                .build();
        ProFile proFile = ProFile.builder()
                .street("Pavl")
                .language("ru").build();
        proFile.setUser(user);

//        Company company = Company.builder().id(2)
//                .name("Google2")
//                .build();
//
//        User user3 = User.builder().id(2L)
//                .userName("petr5@gmail.com")
//                .personalInfo(PersonalInfo.builder()
//                        .firstName("Petr")
//                        .lastName("Petrov")
//                        .birthDate(new Birthday(LocalDate.of(2000, 12,1)))
//                        .build())
//                .company(company)
//                .role(Role.USER)
//                .build();


        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<User> list = session.createQuery("select u from User u where u.personalInfo.firstName=?1", User.class)
                    .setParameter(1,"Petrs")
                    .list();
            for (User user1 : list) {
                System.out.println(user1);
            }
//            Company company1 = session.get(Company.class, company);
//            List<User> users = company1.getUsers();
//            for (User user : users) {
//                System.out.println(user);
//            }



            //session.delete(user);


            session.getTransaction().commit();
        }
    }
}
