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
package de.rwth.idsg.steve.repository.impl;

import de.rwth.idsg.steve.repository.CompanyRepository;
import de.rwth.idsg.steve.repository.dto.CompanyDto;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static jooq.steve.db.Tables.USERS_COMPANIES;
import static jooq.steve.db.tables.Company.COMPANY;


@Slf4j
@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    @Autowired
    private DSLContext ctx;

    @Override
    public List<CompanyDto> getCompaniesByUserId(int userId) {
        return new ArrayList<>(ctx.select(COMPANY.COMPANY_PK, COMPANY.NAME).from(COMPANY)
                .join(USERS_COMPANIES)
                .on(USERS_COMPANIES.COMPANY_ID.eq(COMPANY.COMPANY_PK))
                .where(USERS_COMPANIES.USER_ID.eq(userId))
                .fetch()
                .map(company -> CompanyDto.builder()
                        .id(company.value1())
                        .name(company.value2())
                        .build()));
    }
}
