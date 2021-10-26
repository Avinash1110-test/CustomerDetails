package com.untitled.pro.dto.request;

import com.untitled.pro.domain.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    String firstName;

    String lastName;

    AccountType accountType;

    Long balance;

    String address;

    String branch;
}
