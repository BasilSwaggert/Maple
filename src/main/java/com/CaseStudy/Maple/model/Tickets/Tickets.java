package com.CaseStudy.Maple.model.Tickets;

public class Tickets {

    private int ticketID;
    private String subject;
    private String content;
    private String statusID;
    private String priorityID;
    private String userID;
    private String agentID;
    private String categoryID;
    private String createdAt;
    private String updatedAt;
    private String completedAt;
    private String settingID;
    private int login_loginID;

    @Override
    public String toString() {
        return "Tickets [ticketID = " + ticketID + ", subject = " + subject + ", content = " + content + ", statusID = " + statusID +
                ", priorityID = " + priorityID + ", userID = " + userID + ", agentID = " + agentID + ", categoryID = " + categoryID +
                ", createdAt = " + createdAt + ", updatedAt = " + updatedAt + ", completedAt = " + completedAt + ", settingID = " +
                settingID + ", login_loginID = " + login_loginID + "]";
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(String priorityID) {
        this.priorityID = priorityID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public String getSettingID() {
        return settingID;
    }

    public void setSettingID(String settingID) {
        this.settingID = settingID;
    }

    public int getLogin_loginID() {
        return login_loginID;
    }

    public void setLogin_loginID(int login_loginID) {
        this.login_loginID = login_loginID;
    }
}
