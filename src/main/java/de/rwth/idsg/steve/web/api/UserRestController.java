/*
 * SteVe - SteckdosenVerwaltung - https://github.com/steve-community/steve
 * Copyright (C) 2013-2023 SteVe Community Team
 * All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package de.rwth.idsg.steve.web.api;

import de.rwth.idsg.steve.repository.UserRepository;
import de.rwth.idsg.steve.repository.dto.User;
import de.rwth.idsg.steve.repository.dto.UserDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserRestController {
    private final UserRepository userRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request", response = ApiControllerAdvice.ApiErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ApiControllerAdvice.ApiErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiControllerAdvice.ApiErrorResponse.class)}
    )
    @GetMapping(value = "")
    @ResponseBody
    List<UserDto> getUsersCompanies() {
        return userRepository.getUserCompanies();
    }
}
