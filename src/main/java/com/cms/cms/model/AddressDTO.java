package com.cms.cms.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressDTO {
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
}
