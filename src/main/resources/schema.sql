--
-- Table structure for table `article`
--

CREATE TABLE IF NOT EXISTS `article` (
    `id` INT NOT NULL PRIMARY KEY,
    `text` VARCHAR(1000) NOT NULL,
    `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `title` VARCHAR(255) NOT NULL
);
