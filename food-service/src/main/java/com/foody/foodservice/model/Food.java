package com.foody.foodservice.model;

import com.foody.commonlib.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food")
public class Food extends BaseEntity {
    private String name;
    private String description;
    private Double rating = 0.0;
    private String imageUrl;
    private BigDecimal price;
}
