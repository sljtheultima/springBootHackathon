package com.example.demo;

import java.util.List;

public class Earnings {

    private Finance finance;

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }
}
class Finance {
 private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}

class Result{
    private String ticker;
    private String companyShortName;
    private long startDateTime;
    private String startDateTimeType;
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

    public long getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(long startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getStartDateTimeType() {
        return startDateTimeType;
    }

    public void setStartDateTimeType(String startDateTimeType) {
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