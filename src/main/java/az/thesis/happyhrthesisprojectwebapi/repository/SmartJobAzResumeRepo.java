package az.thesis.happyhrthesisprojectwebapi.repository;

import az.thesis.happyhrthesisprojectwebapi.entity.SmartJobAzResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SmartJobAzResumeRepo extends JpaRepository<SmartJobAzResume, Long> {

    @Query("select s from SmartJobAzResume s where s.minimumSalary=:salary")
    List<SmartJobAzResume> getSmartJobAzResumesBySalary(Double salary);

    @Query("select s from SmartJobAzResume s where s.minimumSalary >= :minSalary and s.minimumSalary <= :maxSalary")
    List<SmartJobAzResume> getSmartJobAzResumesBySalaryInterval(Double minSalary, Double maxSalary);
}
