package cn.ddnd.huayun.web.msm;

import cn.ddnd.huayun.web.config.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    @Autowired
    JavaMailSenderImpl sender;

    /**
      * 邮件发送
     */
    public void send(String subject, String message, String to) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setTo(to);
        mailMessage.setFrom(Global.monitorEmail);
        sender.send(mailMessage);
    }

}
