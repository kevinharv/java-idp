package kevharv.com.idp.configuration;

import java.util.Collection;

import javax.naming.directory.Attributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

public class CustomUserMapper extends LdapUserDetailsMapper {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomUserMapper.class);

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
            Collection<? extends GrantedAuthority> authorities) {
        String displayName = ctx.getStringAttribute("displayName");
        String email = ctx.getStringAttribute("mail");
        String department = ctx.getStringAttribute("department");

        // Attributes attrs = ctx.getAttributes();
        // logger.info(attrs.toString());

        CustomUser user = new CustomUser(username, authorities, displayName, email, department);

        return user;
    }
}
