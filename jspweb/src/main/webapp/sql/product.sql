create table category(
	cg_num int primary key auto_increment,
    cg_name varchar(100)
);

create table product(
	pnum int primary key auto_increment,
	pname varchar(100),
    pprice int,
    pdiscount float,
    pactive int,
    pimg varchar(1000),
    cg_num int,
    foreign key(cg_num) references category(cg_num) on update cascade
    /* on update cascade : pk 레코드가 수정되면 fk 레코드도 같이 수정된다.*/
);

create table stock(
	snum int primary key auto_increment,
    scolor varchar(100),
    ssize varchar(100),
    samount int,
    sfirstdate datetime default now(),
    supdatedate datetime default now() on update now(),		/*레코드가 변경되면 자동으로 현재날짜를 부여*/
    pnum int,
    foreign key(pnum) references product(pnum) on delete cascade
	/* on delete cascade : pk 레코드가 삭제되면 fk 레코드도 같이 삭제된다.*/
);

/* 한 명령어(; 기준 = 커서위치) 씩 실행 단축키 = ctrl + enter */