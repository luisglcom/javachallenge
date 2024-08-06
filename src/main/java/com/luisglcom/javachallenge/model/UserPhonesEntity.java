package com.luisglcom.javachallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type User phones entity.
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_PHONES")
public class UserPhonesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UsersEntity user;
    @Column
    private Long number;
    @Column
    private Integer cityCode;
    @Column
    private String countryCode;
}
