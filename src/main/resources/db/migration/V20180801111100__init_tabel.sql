create table tw_mall.commodity (
  id bigint(20) primary key AUTO_INCREMENT,
  name varchar(100) not null,
  price bigint(20),
  classification varchar(100) not null,

  brand varchar(100) not null,

  described varchar(100) not null,

  dates bigint(20),

  place varchar(100) not null

) charset utf8;