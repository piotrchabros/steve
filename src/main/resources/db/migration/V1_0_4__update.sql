CREATE TABLE IF NOT EXISTS company (
    company_pk INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (company_pk)
);

CREATE TABLE IF NOT EXISTS users_companies (
    users_companies_pk INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    company_id INT NOT NULL,
    CONSTRAINT `fk_users_companies_user_id`
       FOREIGN KEY (user_id) REFERENCES user (user_pk)
           ON DELETE CASCADE
           ON UPDATE RESTRICT,
    CONSTRAINT `fk_users_companies_company_id`
       FOREIGN KEY (company_id) REFERENCES company (company_pk)
           ON DELETE CASCADE
           ON UPDATE RESTRICT,
    PRIMARY KEY (users_companies_pk)
);