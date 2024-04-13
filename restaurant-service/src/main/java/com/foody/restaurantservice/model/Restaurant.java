package com.foody.restaurantservice.model;

import com.foody.commonlib.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    private String name;
    private String address;
    private Double avgRating;
}
