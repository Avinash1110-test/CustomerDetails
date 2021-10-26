package com.untitled.pro.dto.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "error")
public class ResponseError {

    private String code;

    private List<String> message;


}
