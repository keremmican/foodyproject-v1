package com.foody.restaurantservice.model;

import com.foody.commonlib.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "menu_category")
public class MenuCategory extends BaseEntity {
    private String name;
    private String description;
    private List<Long> foodList;
}
