-- Oracle Employee Database data

insert into dept (DEPTNO, DNAME, LOC)  
values 
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');


insert into emp  
values 
(   
 7839, 'KING', 'PRESIDENT', null,   
 '1981-11-17',   
 5000, null, 10   
),
(  
 7521, 'WARD', 'SALESMAN', 7698,  
 '1981-2-22',  
 1250, 500, 30  
),
(  
 7698, 'BLAKE', 'MANAGER', 7839,  
 '1981-5-1',  
 2850, null, 30  
),
(  
 7782, 'CLARK', 'MANAGER', 7839,  
 '1981-6-9',  
 2450, null, 10  
),
(  
 7566, 'JONES', 'MANAGER', 7839,  
 '1981-4-2',  
 2975, null, 20  
),
(  
 7788, 'SCOTT', 'ANALYST', 7566,  
 '1987-04-19',  
 3000, null, 20  
),
(  
 7902, 'FORD', 'ANALYST', 7566,  
 '1981-12-3',  
 3000, null, 20  
),
(  
 7369, 'SMITH', 'CLERK', 7902,  
 '1980-12-17',  
 800, null, 20  
),
(  
 7499, 'ALLEN', 'SALESMAN', 7698,  
 '1981-2-20',  
 1600, 300, 30  
),
(  
 7654, 'MARTIN', 'SALESMAN', 7698,  
 '1981-9-28',  
 1250, 1400, 30  
),
(  
 7844, 'TURNER', 'SALESMAN', 7698,  
 '1981-9-8',  
 1500, 0, 30  
),
(  
 7876, 'ADAMS', 'CLERK', 7788,  
 '1987-5-23',  
 1100, null, 20  
),
(  
 7900, 'JAMES', 'CLERK', 7698,  
 '1981-12-3',  
 950, null, 30  
),
(  
 7934, 'MILLER', 'CLERK', 7782,  
 '1982-1-23',  
 1300, null, 10  
);