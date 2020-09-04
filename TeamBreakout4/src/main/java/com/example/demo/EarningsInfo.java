package com.example.demo;

public class EarningsInfo {
    private String ticker;
    private String companyShortName;
    private int startDateTime;
    private int startDateTimeType;
    private double suprisePercent;
    private int rank;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public int getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(int startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getStartDateTimeType() {
        return startDateTimeType;
    }

    public void setStartDateTimeType(int startDateTimeType) {
        this.startDateTimeType = startDateTimeType;
    }

    public double getSuprisePercent() {
        return suprisePercent;
    }

    public void setSuprisePercent(double suprisePercent) {
        this.suprisePercent = suprisePercent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
