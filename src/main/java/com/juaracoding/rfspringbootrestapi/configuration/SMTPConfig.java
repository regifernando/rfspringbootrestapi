package com.juaracoding.rfspringbootrestapi.configuration;


import com.juaracoding.rfspringbootrestapi.core.Crypto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:smtpconfig.properties")
public class SMTPConfig {

    private static String emailUsername;
    private static String emailPassword;
    private static String emailHost;
    private static String emailPort;
    private static String emailPortSSL;
    private static String emailPortTLS;
    private static String emailAuth;
    private static String emailStartTLSEnable;
    private static String emailSMTPSocketFactoryClass;

    public static String getEmailUsername() {
        return emailUsername;
    }

    @Value("${email.username}")
    private void setEmailUsername(String emailUsername) {
        SMTPConfig.emailUsername = emailUsername;
    }

    public static String getEmailPassword() {
        return emailPassword;
    }


    @Value("${email.password}")
    private void setEmailPassword(String emailPassword) {
        SMTPConfig.emailPassword = Crypto.performDecrypt(emailPassword);
    }

    public static String getEmailHost() {
        return emailHost;
    }

    @Value("${email.host}")
    private void setEmailHost(String emailHost) {
        SMTPConfig.emailHost = emailHost;
    }

    public static String getEmailPort() {
        return emailPort;
    }

    @Value("${email.port}")
    private void setEmailPort(String emailPort) {
        SMTPConfig.emailPort = emailPort;
    }

    public static String getEmailPortSSL() {
        return emailPortSSL;
    }

    @Value("${email.port.ssl}")
    private void setEmailPortSSL(String emailPortSSL) {
        SMTPConfig.emailPortSSL = emailPortSSL;
    }

    public static String getEmailPortTLS() {
        return emailPortTLS;
    }

    @Value("${email.port.tls}")
    private void setEmailPortTLS(String emailPortTLS) {
        SMTPConfig.emailPortTLS = emailPortTLS;
    }

    public static String getEmailAuth() {
        return emailAuth;
    }

    @Value("${email.auth}")
    private void setEmailAuth(String emailAuth) {
        SMTPConfig.emailAuth = emailAuth;
    }

    public static String getEmailStartTLSEnable() {
        return emailStartTLSEnable;
    }

    @Value("${email.starttls.enable}")
    private void setEmailStartTLSEnable(String emailStartTLSEnable) {
        SMTPConfig.emailStartTLSEnable = emailStartTLSEnable;
    }

    public static String getEmailSMTPSocketFactoryClass() {
        return emailSMTPSocketFactoryClass;
    }

    @Value("${email.smtp.socket.factory.class}")
    private void setEmailSMTPSocketFactoryClass(String emailSMTPSocketFactoryClass) {
        SMTPConfig.emailSMTPSocketFactoryClass = emailSMTPSocketFactoryClass;
    }
}

