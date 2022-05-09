package az.thesis.happyhrthesisprojectwebapi.repository;

import az.thesis.happyhrthesisprojectwebapi.entity.JobApplicantConfirmToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicantConfirmTokenRepo extends JpaRepository<JobApplicantConfirmToken, Long> {

    JobApplicantConfirmToken getJobApplicantConfirmTokenByConfirmationToken(String confirmationToken);

}
