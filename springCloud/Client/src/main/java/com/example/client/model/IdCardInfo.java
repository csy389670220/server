package com.example.client.model;

import java.io.Serializable;
import java.util.Objects;

public class IdCardInfo  implements Serializable {
    //姓名
    private String cardName;
    //身份证号码
    private String cardID;
    //开始时间
    private String startDate;
    //结束时间
    private String endDate;

    public IdCardInfo() {
    }

    public IdCardInfo(String cardName, String cardID, String startDate, String endDate) {
        this.cardName = cardName;
        this.cardID = cardID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "IdCardInfo{" +
                "cardName='" + cardName + '\'' +
                ", cardID='" + cardID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdCardInfo that = (IdCardInfo) o;
        return Objects.equals(cardName, that.cardName) &&
                Objects.equals(cardID, that.cardID) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    public static void main(String[] args) {
        IdCardInfo c1=new IdCardInfo("程思雨","340711199211082533","20001010","20201010");
        IdCardInfo c2=new IdCardInfo("程思雨","340711199211082535","20001010","20201010");
        System.out.println("比对结果："+c1.equals(c2));
    }

}
