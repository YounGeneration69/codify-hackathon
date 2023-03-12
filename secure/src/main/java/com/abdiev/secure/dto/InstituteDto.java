package com.abdiev.secure.dto;


import com.abdiev.secure.model.BiasType;
import com.abdiev.secure.model.Comment;
import com.abdiev.secure.model.InstituteType;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstituteDto {
    private Long id;
    private String name;
    private String imageUrl;
    private String webUrl;
    private BiasType biasType;
    private InstituteType instituteType;
    private List<Comment> comments;
    private Integer likesCount;
}
