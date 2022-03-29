package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Customers {

    private int person;
    private final AtomicInteger customerNo = new AtomicInteger(1);
    private String first;
    private String last;
    private String email;
    private String gender;

  public Customers() {
    super();
  }

  public Customers(String first, String last, String email, String gender, String phone) {
    this.first = first;
    this.last = last;
    this.email = email;
    this.gender = gender;
    this.phone = phone;
  }

  public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String phone;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCustomerNo() {
        return customerNo.intValue();
    }

  @Override
  public String toString() {
    return "Customers{" +
      "person=" + person +
      ", customerNo=" + customerNo +
      ", first='" + first + '\'' +
      ", last='" + last + '\'' +
      ", email='" + email + '\'' +
      ", gender='" + gender + '\'' +
      ", phone='" + phone + '\'' +
      '}';
  }
}