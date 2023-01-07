package org.example.enity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Bpi {
    @Id
    @Column
    String code;

    @Column
    String symbol;

    @Column
    String rate;

    @Column
    String description;
    @Column
    @JsonProperty("rate_float")
    double rateFloat;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime ;

    public String getCode() {
        return code;
    }

    public void setCode(String Code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    public double getRateFloat() {
        return rateFloat;
    }

    public void setDescription(double rateFloat) {
        this.rateFloat = rateFloat;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
