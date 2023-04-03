package tests.pojo.serializedPojo;

import lombok.Getter;
import lombok.Setter;

@Getter
//@Setter
public class NamePojo {
    public NamePojo(){}

    public NamePojo(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    private String givenName;
    private String familyName;
}
