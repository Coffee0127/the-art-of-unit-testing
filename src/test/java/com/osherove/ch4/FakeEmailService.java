package com.osherove.ch4;

public class FakeEmailService implements IEmailService {

    String to;
    String subject;
    String body;

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

}
