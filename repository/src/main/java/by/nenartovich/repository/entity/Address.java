package by.nenartovich.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class Address {
@Column(name = "city")
    private String city;
@Column(name = "street")
    private String street;
@Column(name = "postal_code")
    private Integer postalCode;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "city = " + city + ", " +
                "street = " + street + ", " +
                "postalCode = " + postalCode + ")";
    }
}