package com.untitled.pro.dto.response;

import com.untitled.pro.domain.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    Long id;

    Long accountNumber;

    String firstName;

    String lastName;

    AccountType accountType;

    Long balance;

    String address;

    String branch;

    String createdBy;

    Date createdDate;

    String lastModifiedBy;

    Date lastModifiedDate;
}
