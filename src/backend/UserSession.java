package backend;

public class UserSession {

    public static int userId;
    public static String username;
    public static int roleId;

    public UserSession(int userId, String username, int roleId) {
        this.userId = userId;
        this.username = username;
        this.roleId = roleId;
    }

    public UserSession() {
    }

    public void clearSession(){
        userId = -1;
        username = null;
        roleId = -1;
    }
}
