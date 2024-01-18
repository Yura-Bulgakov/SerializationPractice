package org.example.person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdentityCard {
    @JsonProperty("IdType")
    private int idType;
    @JsonProperty("IdSeries")
    private int idSeries;
    @JsonProperty("IdNum")
    private int idNum;

    public IdentityCard() {
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(int idSeries) {
        this.idSeries = idSeries;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }
}
