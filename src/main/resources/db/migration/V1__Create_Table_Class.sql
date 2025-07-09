CREATE TABLE IF NOT EXISTS `class_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `shift` enum('MANHA','NOITE','TARDE') NOT NULL,
  PRIMARY KEY (`id`)
);
