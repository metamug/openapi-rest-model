set database sql syntax mys true;
CREATE TABLE IF NOT EXISTS request_log (
    log_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ip varchar(512) NOT NULL,
    app_name varchar(30) NOT NULL,
    resource varchar(100) NOT NULL,
    version varchar(10) NOT NULL,
    user_agent VARCHAR(255) DEFAULT 'unknown' NOT NULL,
    device_type varchar(10) DEFAULT 'desktop' not null,
    os varchar(10) DEFAULT 'windows' not null,
    client_app_name varchar(128) default null,
    logged_on timestamp DEFAULT CURRENT_TIMESTAMP not null,
    status smallint(6) NOT NULL,
    size int(11) NOT NULL);
CREATE INDEX app_name_resource_index ON request_log(app_name,resource);
CREATE TABLE IF NOT EXISTS query_log (
    log_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    query longtext NOT NULL,
    app_name varchar(30) NOT NULL,
    status tinyint(4) NOT NULL DEFAULT '1' ,
    executed_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP);
COMMENT ON COLUMN QUERY_LOG.STATUS IS '1-Query executed successfully;0- query failed';
CREATE INDEX log_id_index ON query_log(log_id,app_name);

CREATE TABLE IF NOT EXISTS usr (
    user_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(100) NOT NULL UNIQUE,
    pass_word varchar(25) NOT NULL,
    created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE IF NOT EXISTS role (
    role_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS usr_role (
    id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role_id BIGINT NOT NULL,
    user_id bigint(20) NOT NULL,
    created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (role_id) REFERENCES role(role_id)
    ON UPDATE CASCADE ON DELETE RESTRICT
);
CREATE INDEX role_id_index ON usr_role(role_id);
CREATE INDEX user_id_index ON usr_role (user_id);
CREATE TABLE IF NOT EXISTS error_log (
    log_id BIGINT NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    error_id VARCHAR(25) NOT NULL,
    request_method VARCHAR(6) NOT NULL,
    message TEXT NULL,
    trace TEXT NULL,
    resource VARCHAR(100) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS client_app (
    app_id bigint not null AUTO_INCREMENT PRIMARY KEY,
    client_app_name varchar(128) not null,
    access_key varchar(128) not null,
    secret_key varchar(128) not null,
    created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS mtg_query_catalog (
    query_id bigint(20) NOT NULL AUTO_INCREMENT,
    query_name varchar(100) NOT NULL,
    query longtext NOT NULL,
    type ENUM('query','update') NOT NULL,
    created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (query_id)
);
CREATE TABLE IF NOT EXISTS mtg_query_test_data (
    query_id bigint(20) NOT NULL,
    variable_name varchar(100) NOT NULL,
    variable_test_value varchar(512) NOT NULL,
    created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (query_id)
    REFERENCES mtg_query_catalog(query_id)
    ON UPDATE CASCADE ON DELETE RESTRICT
);
CREATE TABLE IF NOT EXISTS mtg_query_tag (
    tag_id bigint(20) NOT NULL AUTO_INCREMENT,
    tag varchar(100) NOT NULL,
    resource_name varchar(100) NOT NULL,
    resource_version varchar(10) NOT NULL,
    created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (tag_id)
);
CREATE INDEX tag_index ON mtg_query_tag(tag);
CREATE TABLE IF NOT EXISTS mtg_query_reference (
    query_id bigint(20) NOT NULL,
    tag_id bigint(20) NOT NULL,
    created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (query_id)
    REFERENCES mtg_query_catalog(query_id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (tag_id)
    REFERENCES mtg_query_tag(tag_id)
    ON UPDATE CASCADE ON DELETE RESTRICT
);