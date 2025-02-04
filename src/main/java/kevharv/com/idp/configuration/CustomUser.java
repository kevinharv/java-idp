package kevharv.com.idp.configuration;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
    
    private final String displayName;
    private final String email;
    private final String department;

    public CustomUser(String username, Collection<? extends GrantedAuthority> authorities, String displayName, String email, String department) {
        super(username, "", authorities);
        this.displayName = displayName;
        this.email = email;
        this.department = department;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    } 
}
