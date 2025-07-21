package com.cms.cms.mapper;

import com.cms.cms.entity.Address;
import com.cms.cms.model.AddressDTO;

public class AddressMapper {

    public AddressDTO toAddressDto(Address address) {
        if(address == null) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressLine1(address.getAddressLine1());
        addressDTO.setAddressLine2(address.getAddressLine2());
        addressDTO.setCity(address.getCity());
        addressDTO.setCountry(address.getCountry());
        return addressDTO;
    }

}
