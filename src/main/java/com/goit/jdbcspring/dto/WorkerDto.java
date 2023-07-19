package com.goit.jdbcspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Pattern;
import java.sql.Date;
public class WorkerDto {
    private String name;
    @Pattern(regexp = "\\+380\\d{9}")
    private String phoneNumber;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
