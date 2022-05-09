package az.thesis.happyhrthesisprojectwebapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "job_applicant_resumes")
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
    private String email;
    private String skills;
    private String education;
    private String experience;
    private Boolean isActive = false;
}
