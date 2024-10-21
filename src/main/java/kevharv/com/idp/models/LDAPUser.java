package kevharv.com.idp.models;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import javax.naming.Name;

@Entry(objectClasses = { "person", "top" })
public class LDAPUser {

    @Id
    private Name distinguishedName;
    
    @Attribute(name="cn")
    String cn;

    @Attribute(name = "sn")
    String sn;


    public String getCN() {
        return this.cn;
    }

    public String getSN() {
        return this.sn;
    }
}