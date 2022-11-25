package by.hoitan.entity;

import by.hoitan.converter.BirthdayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
public class PersonalInfo {

    private String firstName;
    private String lastName;
    @Convert(converter = BirthdayConverter.class)
    @Column(name = "birthday")
    private Birthday birthDate;
}
