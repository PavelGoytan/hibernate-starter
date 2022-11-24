package by.hoitan.entity;

import by.hoitan.converter.BirthdayConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "public")
public class User {


    @Id
    private String userName;
    private String firstName;
    private String lastName;
    @Convert(converter = BirthdayConverter.class)
    @Column(name = "birthday")
    private Birthday birthDate;
    @Enumerated(EnumType.STRING)
    private Role role;

}
