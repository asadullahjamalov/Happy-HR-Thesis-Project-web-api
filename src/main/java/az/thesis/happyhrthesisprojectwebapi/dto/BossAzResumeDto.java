package az.thesis.happyhrthesisprojectwebapi.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public class BossAzResumeDto {
    private String occupation;
    private int salary;
    private String name;
    private String city;
    private int age;
    private String gender;
    private String bumpedTime;
    private String expireTime;
    private String phone;
    private String skills;
    private String education;
    private String educationDetails;
    private String experience;
    private String experienceDetails;
    private String additionalInfo;

    public BossAzResumeDto() {
    }

    public BossAzResumeDto(String occupation, int salary, String name, String city,
                           int age, String gender, String bumpedTime, String expireTime,
                           String phone, String skills, String education,
                           String educationDetails, String experience, String experienceDetails,
                           String additionalInfo) {
        this.occupation = occupation;
        this.salary = salary;
        this.name = name;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.bumpedTime = bumpedTime;
        this.expireTime = expireTime;
        this.phone = phone;
        this.skills = skills;
        this.education = education;
        this.educationDetails = educationDetails;
        this.experience = experience;
        this.experienceDetails = experienceDetails;
        this.additionalInfo = additionalInfo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBumpedTime() {
        return bumpedTime;
    }

    public void setBumpedTime(String bumpedTime) {
        this.bumpedTime = bumpedTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(String educationDetails) {
        this.educationDetails = educationDetails;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperienceDetails() {
        return experienceDetails;
    }

    public void setExperienceDetails(String experienceDetails) {
        this.experienceDetails = experienceDetails;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
