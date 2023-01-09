
package pbb.express;

import pbb.express.model.account.Akun;
import pbb.express.views.LoginFrame;
import pbb.express.views.ViewHelper;

public class Driver {
    
    private static Akun loggedAccount = null;
    
    public static void main(String args[]) {
        ViewHelper.openFrame(new LoginFrame());
    }
    
    public static void setAccount(Akun account) {
        loggedAccount = account;
    }
    
    public static Akun getLoggedAccount() {
        return loggedAccount;
        
    }
    
}
