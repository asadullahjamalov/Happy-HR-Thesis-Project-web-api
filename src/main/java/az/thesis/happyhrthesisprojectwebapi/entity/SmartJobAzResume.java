package az.thesis.happyhrthesisprojectwebapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "smart_job_az_resumes")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SmartJobAzResume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hasDrivingLicence;
    private String hasCar;
    private String workingTime;
    @Column(columnDefinition="text")
    private String about;
    private String minimumSalary;
    private String gender;
    private String birthDate;
    private String education;
    private String experience;
    private String city;
    private String address;
    private String phone;

}
