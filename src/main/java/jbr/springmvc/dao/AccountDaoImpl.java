package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/*import jbr.springmvc.model.Login;*/
import jbr.springmvc.model.Account;

public class AccountDaoImpl implements AccountDao {

  @Autowired
  
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int record(Account account) {
    String sql = "insert into spring_mvc.accounts ( account_name, account_ad_ft1, account_ad_ft2, account_city, account_state) values(?,?,?,?,?)";

    return jdbcTemplate.update(sql, new Object[] { account.getAccount_name(), account.getAccount_ad_ft1(), account.getAccount_ad_ft2(),
    		account.getAccount_city(), account.getAccount_state() });
  }
  
 /**
 New code added to show users . This should ultimtely take us to jsp showUsers.jsp
 * @return
 */
  public List<Account> getAccountsList(){
	  
	    String sql = "select * from spring_mvc.accounts " ;
    List<Account> accounts = jdbcTemplate.query(sql, new AccountMapper());
  
	  return accounts; 
  }
  
  /**
  New code added to show accounts. This should ultimtely take us to jsp showAccounts.jsp
  * @return
  */
   public Account getAccountByName(String accName){
 	  
 	    String sql = "select * from spring_mvc.accounts where account_name =  '" + accName + "'" ;
     List<Account> accounts = jdbcTemplate.query(sql, new AccountMapper());
     
     Account retAccount = accounts.get(0);
   
 	  return retAccount; 
   }  
   
   /**
   New code added to update accounts. This should ultimtely take us to jsp updating the accounts, 
   we are only updating some variables in account and not name 
   */
   public int updateAccount(Account account) {
	    String sql = "update spring_mvc.accounts set  account_ad_ft1 =?, account_ad_ft2 =? , account_city =? , account_state =? where account_name = ? ";

	    return jdbcTemplate.update(sql, new Object[] {  account.getAccount_ad_ft1(), account.getAccount_ad_ft2(),
	    		account.getAccount_city(), account.getAccount_state() , account.getAccount_name() });
	  }   

 
  
class AccountMapper implements RowMapper<Account> {

  public Account mapRow(ResultSet rs, int arg1) throws SQLException {
    Account account = new Account();

    account.setAccount_name(rs.getString("account_name"));
    account.setAccount_ad_ft1(rs.getString("account_ad_ft1"));
    account.setAccount_ad_ft2(rs.getString("account_ad_ft2"));
    account.setAccount_city(rs.getString("account_city"));
    account.setAccount_state(rs.getString("account_state"));
    
    return account;
  }
}
}
