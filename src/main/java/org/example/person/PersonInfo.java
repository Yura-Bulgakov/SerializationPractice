package org.example.person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonInfo {
    @JsonProperty("FindPersonInfo")
    private FindPersonInfo findPersonInfo;

    public PersonInfo() {
    }

    public FindPersonInfo getFindPersonInfo() {
        return findPersonInfo;
    }

    public void setFindPersonInfo(FindPersonInfo findPersonInfo) {
        this.findPersonInfo = findPersonInfo;
    }
}
