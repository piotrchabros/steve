package de.rwth.idsg.steve.repository.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<CompanyDto> companies;
}
