

create table city(
    id int primary key auto_increment,
    name varchar(20),
    country varchar(30),
    people int,
    province varchar(30)
);
select name,people from city;

select * from city where country='中国';

select * from city where people < 100;

select * from city where people > 500 and country='中国';

select * from city where country in ('中国','美国');

select * from city where people between 100 and 200;

select * from city where people > 500 and country in ('中国','美国');

select * from city where name like 'qing%';

select count(*) from city;

select country, count(*) from city group by country;

select country, sum(people) from city group by country;

select province, count(*), group_concat(name) from city where country='中国' group by province;

select country, count(*) as number from city group by country having number > 5;

select country, count(*) as number from city group by country having number > 5 order by number desc;

select country, count(*) as number from city group by country having number > 5 order by number desc limit 3 offset 0;





create table mentor(
    id int primary key auto_increment,
    name varchar(30),
    title varchar(30),
    direction varchar(40)
);

insert into mentor values (null,'乔峰','博士生导师','高分子');
insert into mentor values (null,'慕容复','硕士生导师','光电信息');
insert into mentor values (null,'鸠摩智','硕士生导师','大数据');


create table student(
    id int primary key auto_increment,
    name varchar(20),
    gender int comment '0代表女性;1代表男性',
    entry_date date
);
alter table student add mid int;

insert into student values (null,'张三',1,'2020-09-01',1);
insert into student values (null,'李四',0,'2019-09-01',1);
insert into student values (null,'王五',1,'2021-09-01',2);
insert into student values (null,'赵六',0,'2023-09-01',2);

insert into student values (null,'qiqi',0,'2020-09-01',3);


select m.name,group_concat(s.name) from mentor m,student s where m.id=s.mid group by m.name;

select s.name from mentor m, student s where m.id=s.mid and m.name='乔峰';

select m.name,count(*) as number from mentor m,student s where m.id=s.mid group by m.name;

select m.name,count(s.name) as number from mentor m left join student s on m.id=s.mid and s.gender=1 group by m.name;

select m.direction,count(*) from mentor m,student s where m.id=s.mid group by m.direction order by count(s.name) desc limit 1;

select title, count(name) from mentor group by title;