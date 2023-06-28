package de.rwth.idsg.steve.repository.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CompanyDto {
    private Integer id;
    private String name;
}
