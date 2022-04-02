package az.thesis.happyhrthesisprojectwebapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "boss_az_resumes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BossAzResume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String occupation;
    private int salary;
    private String name;
    private String city;
    private int age;
    private String gender;
    private String bumpedTime;
    private String expireTime;
    private String phone;
    @Column(length = 4096)
    private String skills;
    @Column(length = 4096)
    private String education;
    @Column(columnDefinition="text")
    private String educationDetails;
    private String experience;
    @Column(columnDefinition="text")
    private String experienceDetails;
    @Column(columnDefinition="text")
    private String additionalInfo;

}
