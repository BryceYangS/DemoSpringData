package me.whiteship.demospringdata;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    //@Column 생략되어 있음
    private String street;

    private String city;

    private String state;

    private String zipCode;

}
