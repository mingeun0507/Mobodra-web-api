package com.web.dto;

import com.web.domain.enums.ContentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {
    private String contentType;

    private String title;

    private String year;
}
