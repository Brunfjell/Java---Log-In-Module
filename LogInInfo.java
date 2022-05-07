import java.util.*;

public class LogInInfo {
    static HashMap<String, String> logininfo = new HashMap<String, String>();

    LogInInfo() {
        logininfo.put("Luis Troy", "Paraiso");

    }

    protected static HashMap getInfo() {
        return logininfo;
    }

}
