package com.foody.restaurantservice.model;

import com.foody.commonlib.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    private String name;
    private String addressLine;

    //regex yaz
    private String phone;

    @Email
    private String email;
    private Double avgRating = 0.0;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Menu menu;
}
