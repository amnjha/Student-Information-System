package com.example.sis.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Notice {

    @Id
    private String noticeId;
    private String noticeHeader;
    private String noticeContent;
    private Date noticeDate;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeHeader() {
        return noticeHeader;
    }

    public void setNoticeHeader(String noticeHeader) {
        this.noticeHeader = noticeHeader;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }
}
