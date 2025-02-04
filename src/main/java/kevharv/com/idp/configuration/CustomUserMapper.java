package kevharv.com.idp.configuration;

import java.util.Collection;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

public class CustomUserMapper extends LdapUserDetailsMapper {

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
            Collection<? extends GrantedAuthority> authorities) {
        String displayName = ctx.getStringAttribute("displayName");
        String email = ctx.getStringAttribute("mail");
        String department = ctx.getStringAttribute("department");

        return new CustomUser(username, authorities, displayName, email, department);
    }
}
