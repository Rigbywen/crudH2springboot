package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinDataRs {

    Time time;
    private String disclaimer;
    private String chartName;
    Bpi bpi;


    // Getter Methods

    public Time getTime() {
        return time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public Bpi getBpi() {
        return bpi;
    }

    // Setter Methods

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }


    public class Bpi {
        @JsonProperty("USD")
        USD USD;
        @JsonProperty("GBP")
        GBP GBP;
        @JsonProperty("EUR")
        EUR EUR;


        // Getter Methods

        public USD getUSD() {
            return USD;
        }

        public GBP getGBP() {
            return GBP;
        }

        public EUR getEUR() {
            return EUR;
        }

        // Setter Methods

        public void setUSD(USD USD) {
            this.USD = USD;
        }

        public void setGBP(GBP GBP) {
            this.GBP = GBP;
        }

        public void setEUR(EUR EUR) {
            this.EUR = EUR;
        }
        @Override
        public String toString() {
            return "Bpi = {" +
                    USD.toString() + '\n' +
                    GBP.toString() + '\n' +
                    EUR.toString() + '\n' +
                    '}';
        }

    }


    public class EUR {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        private float rate_float;


        // Getter Methods

        public String getCode() {
            return code;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getRate() {
            return rate;
        }

        public String getDescription() {
            return description;
        }

        public float getRate_float() {
            return rate_float;
        }

        // Setter Methods

        public void setCode(String code) {
            this.code = code;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setRate_float(float rate_float) {
            this.rate_float = rate_float;
        }
        @Override
        public String toString() {
            return "EUR = {" +
                    "code=" + code +
                    "symbol=" + symbol +
                    "rate=" + rate +
                    "description=" + description  +
                    "rate_float=" + rate_float +
                    '}';
        }
    }


    public class GBP {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        private float rate_float;


        // Getter Methods

        public String getCode() {
            return code;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getRate() {
            return rate;
        }

        public String getDescription() {
            return description;
        }

        public float getRate_float() {
            return rate_float;
        }

        // Setter Methods

        public void setCode(String code) {
            this.code = code;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setRate_float(float rate_float) {
            this.rate_float = rate_float;
        }

        @Override
        public String toString() {
            return "GBP = {" +
                    "code=" + code +
                    "symbol=" + symbol +
                    "rate=" + rate +
                    "description=" + description  +
                    "rate_float=" + rate_float +
                    '}';
        }
    }


    public class USD {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        private float rate_float;


        // Getter Methods

        public String getCode() {
            return code;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getRate() {
            return rate;
        }

        public String getDescription() {
            return description;
        }

        public float getRate_float() {
            return rate_float;
        }

        // Setter Methods

        public void setCode(String code) {
            this.code = code;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setRate_float(float rate_float) {
            this.rate_float = rate_float;
        }

        @Override
        public String toString() {
            return "USD = {" +
                    "code=" + code +
                    "symbol=" + symbol +
                    "rate=" + rate +
                    "description=" + description  +
                    "rate_float=" + rate_float +
                    '}';
        }
    }


    public class Time {
        private String updated;
        private String updatedISO;
        private String updateduk;


        // Getter Methods

        public String getUpdated() {
            return updated;
        }

        public String getUpdatedISO() {
            return updatedISO;
        }

        public String getUpdateduk() {
            return updateduk;
        }

        // Setter Methods

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public void setUpdatedISO(String updatedISO) {
            this.updatedISO = updatedISO;
        }

        public void setUpdateduk(String updateduk) {
            this.updateduk = updateduk;
        }
    }
}
