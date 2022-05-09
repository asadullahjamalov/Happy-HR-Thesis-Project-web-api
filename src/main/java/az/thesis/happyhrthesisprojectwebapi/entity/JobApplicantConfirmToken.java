package az.thesis.happyhrthesisprojectwebapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_applicant_confirm_tokens")
public class JobApplicantConfirmToken  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String confirmationToken;

    private LocalDateTime createdDate;

    @OneToOne(targetEntity = JobApplicantResume.class)
    @JoinColumn(nullable = false, name = "job_applicant_id")
    private JobApplicantResume jobApplicantResume;
}
