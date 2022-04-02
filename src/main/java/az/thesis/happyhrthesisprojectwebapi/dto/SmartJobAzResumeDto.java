package az.thesis.happyhrthesisprojectwebapi.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public class SmartJobAzResumeDto {
    private String name;
    private String hasDrivingLicence;
    private String hasCar;
    private String workingTime;
    private String about;
    private Double minimumSalary;
    private String gender;
    private String birthDate;
    private String education;
    private String experience;
    private String city;
    private String address;
    private String phone;

    public SmartJobAzResumeDto() {
    }

    public SmartJobAzResumeDto(String name, String hasDrivingLicence, String hasCar,
                               String workingTime, String about, Double minimumSalary,
                               String gender, String birthDate, String education,
                               String experience, String city, String address, String phone) {
        this.name = name;
        this.hasDrivingLicence = hasDrivingLicence;
        this.hasCar = hasCar;
        this.workingTime = workingTime;
        this.about = about;
        this.minimumSalary = minimumSalary;
        this.gender = gender;
        this.birthDate = birthDate;
        this.education = education;
        this.experience = experience;
        this.city = city;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHasDrivingLicence() {
        return hasDrivingLicence;
    }

    public void setHasDrivingLicence(String hasDrivingLicence) {
        this.hasDrivingLicence = hasDrivingLicence;
    }

    public String getHasCar() {
        return hasCar;
    }

    public void setHasCar(String hasCar) {
        this.hasCar = hasCar;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Double getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(Double minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
