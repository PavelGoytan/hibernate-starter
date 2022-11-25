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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;
    @AttributeOverride(name = "birthDate", column = @Column(name = "birthday"))
    private PersonalInfo personalInfo;
    @Enumerated(EnumType.STRING)
    private Role role;

}
