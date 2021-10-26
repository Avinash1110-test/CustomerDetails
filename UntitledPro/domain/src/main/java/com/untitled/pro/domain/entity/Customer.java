package com.untitled.pro.domain.entity;


import com.untitled.pro.domain.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "public_atm", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name"}, name = "UNI_NAME"),
        @UniqueConstraint(columnNames = {"last_name"}, name = "UNI_LAST_NAME"),
        @UniqueConstraint(columnNames = {"account_number"}, name = "UNI_ACC_NUM")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(name = "account_number", nullable = false, length = 100)
    String accountNumber;

    @NotNull
    @Column(name = "first_name", nullable = false, length = 100)
    String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false, length = 100)
    String lastName;

    @NotNull
    @Column(name = "password", nullable = false, length = 10)
    String password;

    @NotNull(message = "Accepted values are (CURRENT,SAVINGS)")
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    AccountType accountType;

    @NotNull
    @Column(name = "balance", nullable = false, length = 100)
    Long balance;

    @NotNull
    @Column(name = "address", nullable = false, length = 500)
    String address;

    @NotNull
    @Column(name = "branch", nullable = false, length = 500)
    String branch;
}
