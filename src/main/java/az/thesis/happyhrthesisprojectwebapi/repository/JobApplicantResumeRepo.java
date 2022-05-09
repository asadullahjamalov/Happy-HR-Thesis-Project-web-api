package az.thesis.happyhrthesisprojectwebapi.repository;

import az.thesis.happyhrthesisprojectwebapi.entity.BossAzResume;
import az.thesis.happyhrthesisprojectwebapi.entity.JobApplicantResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobApplicantResumeRepo extends JpaRepository<JobApplicantResume, Long> {

    @Query(value = "select j from JobApplicantResume j where j.email=:email")
    JobApplicantResume getJobApplicantResumeByEmail(String email);

    @Transactional
    @Modifying
    @Query("update JobApplicantResume j set j.isActive=true where j.email= :email")
    void changeIsActiveByEmail(String email);

    @Query(value = "select j from JobApplicantResume j where j.isActive=:isActive")
    List<JobApplicantResume> getJobApplicantResumeByIsActive(Boolean isActive);

    @Query("select j from JobApplicantResume j where j.age=:age and j.isActive=:isActive")
    List<JobApplicantResume> getJobApplicantResumeByIsActiveAndAge(int age, Boolean isActive);


    @Query("select j from JobApplicantResume j where j.age >= :minAge and j.age <= :maxAge and j.isActive=:isActive")
    List<JobApplicantResume> getJobApplicantResumesByAgeIntervalAndIsActiveIsTrue(int minAge, int maxAge, Boolean isActive);

    @Query("select j from JobApplicantResume j where j.salary=:salary and j.isActive=:isActive")
    List<JobApplicantResume> getJobApplicantResumesBySalaryAndIsActiveIsTrue(int salary, Boolean isActive);

    @Query("select j from JobApplicantResume j where j.salary >= :minSalary and j.salary <= :maxSalary and j.isActive=:isActive")
    List<JobApplicantResume> getJobApplicantResumesBySalaryIntervalAndIsActiveIsTrue(int minSalary, int maxSalary, Boolean isActive);

}
