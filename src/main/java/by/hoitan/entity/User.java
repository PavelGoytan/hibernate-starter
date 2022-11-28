package by.hoitan.entity;

import by.hoitan.converter.BirthdayConverter;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(exclude = "company")
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
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "company_id")
    private Company company;
   @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
   private ProFile proFile;

}
