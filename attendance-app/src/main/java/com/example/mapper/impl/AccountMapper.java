package mapper.impl;

import mapper.RowMapper;
import model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    private static AccountMapper accountMapper = null;

    @Override
    public Account mapRow(ResultSet rs) throws SQLException {
        Account account = new Account();

        try {
            account.set_id(rs.getInt("id"));
            account.setUsername(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setRole(rs.getString("role"));
            account.SetEmployeeId(rs.getInt("employee_id"));

            return account;
        } catch (SQLException e) {
            e.printStackTrace();;
        }

        return null;
    }

    public static AccountMapper getInstance() {
        if(accountMapper == null) accountMapper = new AccountMapper();

        return accountMapper;
    }
}
