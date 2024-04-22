package com.cskaoyan.th58.bean;

public class Log {

    private Integer id;

    private String fromName;

    private String toName;

    private Double money;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", fromName='" + fromName + '\'' +
                ", toName='" + toName + '\'' +
                ", money=" + money +
                ", message='" + message + '\'' +
                '}';
    }
}
