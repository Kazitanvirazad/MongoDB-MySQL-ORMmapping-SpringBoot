-- Oracle Employee Database

create database oracleemployee;

use oracleemployee;

create table dept(   
  deptno     int,   
  dname      varchar(14),   
  loc        varchar(13),   
  constraint pk_dept primary key (deptno)   
);

create table emp(   
  empno    int,  
  ename    varchar(10),   
  job      varchar(9),   
  mgr      int, 
  hiredate date,   
  sal      int,  
  comm     int,   
  deptno   int,   
  constraint pk_emp primary key (empno),   
  constraint fk_deptno foreign key (deptno) references dept (deptno)   
);