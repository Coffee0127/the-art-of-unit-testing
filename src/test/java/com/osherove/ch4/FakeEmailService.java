package com.osherove.ch4;

public class FakeEmailService implements IEmailService {

    EmailInfo emailInfo;

    @Override
    public void sendEmail(EmailInfo emailInfo) {
        this.emailInfo = emailInfo;
    }

}
