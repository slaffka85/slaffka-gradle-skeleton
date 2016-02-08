package com.slaffka.domain;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;*/
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;


public class Notify implements Serializable {

    @Id
    // главный ключ
    private Long callId = null;
    // номер телефона заявителя
    private String phoneNumber = null;
    // Second phone number
    private String secondPhoneNumber = null;
    // сообщение для воспроизведения
    private String message = null;
    // дата, выполнения звонка
    private Date scheduledTime = null;
    // выставляет когда звонок выполнен (для защиты от повторного выполнения,
    // если по каким либо причинам не удаляется из таблицы)
    private Boolean inProgress = null;

    private String callExtension;

    private Integer tryCount;

    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public String getCallExtension() {
        return callExtension;
    }

    public void setCallExtension(String callExtension) {
        this.callExtension = callExtension;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }

    @Override
    public String toString() {
        return "Notify{" +
                "callId=" + callId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", secondPhoneNumber='" + secondPhoneNumber + '\'' +
                ", message='" + message + '\'' +
                ", scheduledTime=" + scheduledTime +
                ", inProgress=" + inProgress +
                ", callContext='" + callExtension + '\'' +
                ", tryCount=" + tryCount +
                '}';
    }
}
