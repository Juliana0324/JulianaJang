select * from user_procedures;

drop procedure test_proc;


--bind���� ����
var a number;
var b varchar2(50);

--���ν��� ����
exec test_proc('test', 20, 'test@test.com', :a, :b
);

--bind������ �� ���
print a
print b
, TEST_PROCEDURE, TEST_PROC;

alter table test_procedure add constraint pk_test_procedure primary key(num);

---------------------insert-test-proc---------------------------------------
select * from user_procedures;
var row_count number;
var err_msg varchar2(300);



exec insert_test_proc(1,'������','kang@naver.com',20,:row_count, :err_msg);

print row_count;

--------------------update-test-prc------------------------------------------
--pk���� ����
alter table test_procedure disable constraint pk_test_procedure;

select * from user_constraints;
select * from test_procedure;

var a number;
var b varchar2(500);

exec update_test_proc(1,30,'test@test.com', :a, :b);

print a;
