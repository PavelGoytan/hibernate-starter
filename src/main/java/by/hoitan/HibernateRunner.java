package by.hoitan;

import by.hoitan.converter.BirthdayConverter;
import by.hoitan.entity.Birthday;
import by.hoitan.entity.Role;
import by.hoitan.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.configure();

        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = User.builder()
                    .userName("ivan2@gmail.com")
                    .firstName("Ivan")
                    .lastName("Ivanov")
                    .birthDate(new Birthday(LocalDate.of(2000, 11, 11)))
                    .role(Role.ADMIN)
                    .build();

            //session.delete(user);
            User user1 = session.get(User.class, "ivan@gmail.com");
            System.out.println(user1);

            session.getTransaction().commit();
        }
    }
}
