package az.thesis.happyhrthesisprojectwebapi.repository;

import az.thesis.happyhrthesisprojectwebapi.entity.BossAzResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BossAzResumeRepo extends JpaRepository<BossAzResume, Long> {

    @Query("select b from BossAzResume b where b.age=:age")
    List<BossAzResume> getBossAzResumesByAge(int age);

    @Query("select b from BossAzResume b where b.age >= :minAge and b.age <= :maxAge")
    List<BossAzResume> getBossAzResumesByAgeInterval(int minAge, int maxAge);

    @Query("select b from BossAzResume b where b.salary=:salary")
    List<BossAzResume> getBossAzResumesBySalary(int salary);

    @Query("select b from BossAzResume b where b.salary >= :minSalary and b.salary <= :maxSalary")
    List<BossAzResume> getBossAzResumesBySalaryInterval(int minSalary, int maxSalary);

}
