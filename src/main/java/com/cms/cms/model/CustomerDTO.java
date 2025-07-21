package com.cms.cms.model;


import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {

    private Long id;
    private String name;
    private Date dateOfBirth;
    private String nicNumber;
    private List<String> mobileNumbers;

}
