package tests.pojo.serializedPojo;

import lombok.Getter;
import lombok.Setter;
@Getter
//@Setter
public class AddressPojo {
    public AddressPojo(){}

    public AddressPojo(String address1, String cityVillage, String country, String postalCode) {
        this.address1 = address1;
        this.cityVillage = cityVillage;
        this.country = country;
        this.postalCode = postalCode;
    }

    private String address1;
    private String cityVillage;
    private String country;
    private String postalCode;
}
