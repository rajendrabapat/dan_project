/* Class of Account */
package jbr.springmvc.model;

public class Account {

  private String account_name;
  private String account_ad_ft1;
  private String account_ad_ft2;
  private String account_city;
  private String account_state;

  public String getAccount_name() {
    return account_name;
  }

  public void setAccount_name(String account_name) {
   /* System.out.println("account_name: " + account_name);*/
    this.account_name = account_name;
  }

  public String getAccount_ad_ft1() {
    return account_ad_ft1;
  }

  public void setAccount_ad_ft1(String account_ad_ft1) {
    this.account_ad_ft1 = account_ad_ft1;
  }

  public String getAccount_ad_ft2() {
    return account_ad_ft2;
  }

  public void setAccount_ad_ft2(String account_ad_ft2) {
   /* System.out.println("account_ad_ft2: " + account_ad_ft2);*/
    this.account_ad_ft2 = account_ad_ft2;
  }

  public String getAccount_city() {
    return account_city;
  }

  public void setAccount_city(String account_city) {
   /* System.out.println("account_city: " + account_city);*/
    this.account_city = account_city;
  }

  public String getAccount_state() {
    return account_state;
  }

  public void setAccount_state(String account_state) {
    this.account_state = account_state;
  }
}
