package com.osherove.ch4;

import java.util.Objects;

public class EmailInfo {
    private final String to;
    private final String subject;
    private final String body;

    public EmailInfo(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailInfo emailInfo = (EmailInfo) o;
        return Objects.equals(to, emailInfo.to) &&
            Objects.equals(subject, emailInfo.subject) &&
            Objects.equals(body, emailInfo.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, subject, body);
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
