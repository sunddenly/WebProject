create table t_emp(
	id int(4) primary key auto_increment,
	name varchar(20),
	salary numeric(7,2),
	age numeric(3,0)
)
insert into t_emp
values(null,'Tomcat',10000.00,24);
select * from t_emp

