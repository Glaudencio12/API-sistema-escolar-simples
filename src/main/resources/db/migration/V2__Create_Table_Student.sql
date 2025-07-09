CREATE TABLE IF NOT EXISTS `student_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `class_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`class_id`) REFERENCES `class_entity` (`id`)
);

