package com.foody.commentservice.model;

import com.foody.commonlib.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {
    private String title;

    @Size(min = 25, max = 250)
    private String comment;

    private Double rating;

    private Long foodId;
    private Long restaurantId;
    private Long userId;
}
