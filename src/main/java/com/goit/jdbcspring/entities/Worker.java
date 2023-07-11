package com.goit.jdbcspring.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "worker")
public class Worker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long workerId;
  private String name;
  private Date birthday;
  private String level;
  private BigDecimal salary;

  public Worker() {
  }

  public Worker(String name, Date birthday, String level, BigDecimal salary) {
    this.name = name;
    this.birthday = birthday;
    this.level = level;
    this.salary = salary;
  }

  public Long getWorkerId() {
    return workerId;
  }

  public void setWorkerId(Long workerId) {
    this.workerId = workerId;
  }


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


  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }


  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Worker{" +
            "workerId=" + workerId +
            ", name='" + name + '\'' +
            ", birthday=" + birthday +
            ", level='" + level + '\'' +
            ", salary=" + salary +
            '}';
  }
}
