package az.thesis.happyhrthesisprojectwebapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_resumes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class JobApplicantResume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String occupation;
    private int salary;
    private String name;
    private String city;
    private int age;
    private String gender;
    private String phone;
    private String skills;
    private String education;
    private String experience;
}
