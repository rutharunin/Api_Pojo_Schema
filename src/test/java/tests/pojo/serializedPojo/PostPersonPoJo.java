package tests.pojo.serializedPojo;

import lombok.Getter;

import java.util.List;

@Getter
//@Setter

public class PostPersonPoJo {
    public PostPersonPoJo(){}

    public PostPersonPoJo(List<NamePojo> names, String gender, String birthdate, List<AddressPojo> addresses) {
        this.names = names;
        this.gender = gender;
        this.birthdate = birthdate;
        this.addresses = addresses;
    }

    private List<NamePojo> names;
    private String gender;
    private String birthdate;
    private List<AddressPojo> addresses;
}
