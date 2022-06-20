package by.nenartovich.service.converter.impl;

import by.nenartovich.repository.entity.Address;
import by.nenartovich.service.converter.ConverterDTO;
import by.nenartovich.service.dto.AddressDto;

public class AddressConverter implements ConverterDTO<AddressDto, Address> {
    @Override
    public AddressDto apply(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setPostalCode(address.getPostalCode());
        return addressDto;
    }

    @Override
    public Address apply(Address address, AddressDto addressDto) {
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setPostalCode(addressDto.getPostalCode());
        return address;
    }

}
