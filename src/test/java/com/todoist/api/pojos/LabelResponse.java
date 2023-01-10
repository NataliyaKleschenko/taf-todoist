package com.todoist.api.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;
@Data
@Setter
public class LabelResponse {
    private String id;
    private String name;
    private Integer order;
    private String color;
    @JsonProperty("is_favorite")
    private Boolean isFavorite;
}
