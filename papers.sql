

CREATE TABLE `papers` (
  `id` int(11) NOT NULL auto_increment,
  `startdate` datetime default NULL,
  `title` varchar(100) default NULL,
  `description` varchar(250) default NULL,
  `text` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- Dumping data for table `papers`
-- 

INSERT INTO `papers` (`id`,`startdate`, `title`, `description`,  `text`) VALUES 
(1, '2018-05-02 05:26:29', 'Ibrahim', 'Senior Java Developer', 'Software Developement Department'),
(2, '2018-05-02 12:26:29', 'Ahmed', 'Senior Java Developer', 'Software Developement Department')
