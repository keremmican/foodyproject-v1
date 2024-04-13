package com.foody.guideservice.model;


import com.foody.commonlib.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "guide")
public class Guide extends BaseEntity {
    private String guideTitle;
    @Column(columnDefinition = "TEXT")
    private String guideContent;
    @Max(5)
    private Double rating;
}
