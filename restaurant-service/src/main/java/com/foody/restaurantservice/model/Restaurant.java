package com.foody.restaurantservice.model;

import com.foody.commonlib.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    private String name;
    private String addressLine;

    @Pattern(regexp="^(\\+[0-9]{1,3}[- ]?)?\\(?[0-9]{3}\\)?[- ]?[0-9]{3}[- ]?[0-9]{4}$", message="Invalid phone number")
    private String phone;

    @Email
    private String email;
    private Double avgRating = 0.0;

    private Long menuId;
}
