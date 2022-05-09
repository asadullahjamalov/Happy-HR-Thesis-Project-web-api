package az.thesis.happyhrthesisprojectwebapi.util;

import az.thesis.happyhrthesisprojectwebapi.entity.JobApplicantResume;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageUtil {

    @Value("${mail.registration.success.subject}")
    private String successMessageSubject;

    @Value("${mail.registration.success.message}")
    private String successMessageText;

    @Value("${mail.registration.confirm.subject}")
    private String registrationVerifySubject;

    @Value("${mail.registration.confirm.message}")
    private String registrationVerifyText;


    private final MailSenderUtil mailSenderUtil;

    public MessageUtil(MailSenderUtil mailSenderUtil) {
        this.mailSenderUtil = mailSenderUtil;
    }


    public void regVerifyNotification(JobApplicantResume jobApplicantResume, String token) {
        mailSenderUtil.sendEmail(jobApplicantResume.getEmail(), registrationVerifySubject,
                String.format(registrationVerifyText, token));
    }

    public void successRegister(JobApplicantResume jobApplicantResume) {
        mailSenderUtil.sendEmail(jobApplicantResume.getEmail(), successMessageSubject, successMessageText);
    }
}

