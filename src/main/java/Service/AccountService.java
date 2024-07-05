package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    // register account
    public Account registerAccount(Account account) {
        if (account.getUsername().length() == 0 || account.getPassword().length() < 4 || accountDAO.getAccountByUsername(account.getUsername()) != null ) {
            return null;
        }
        return accountDAO.insertAccount(account);
    }

    // login account 
    public Account loginAccount(Account account) {
        return accountDAO.loginAccount(account);
    }
}
