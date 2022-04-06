CREATE TABLE `etapas` (
    `etapa_id` bigint       NOT NULL AUTO_INCREMENT,
    `nombre`   varchar(100) NOT NULL,
    `orden`    int          NOT NULL,
    PRIMARY KEY (`etapa_id`),
    UNIQUE KEY `UN_ORDERN` (`orden`)
);