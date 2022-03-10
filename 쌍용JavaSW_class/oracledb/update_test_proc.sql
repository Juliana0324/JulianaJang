create or replace procedure update_test_proc(i_num number, i_age number, i_email varchar2,
row_cnt out number, err_msg out varchar2)

is

begin

-- �÷���� in parameter���� �٤Ѥ��� �����Ѵ�.
      update     test_procedure
      set        age = i_age, email = i_email
      where      num = i_num;

-- ����� ���� ���� �Ͻ��� Ŀ��(sql)�� ����Ͽ� ��´�.
      row_cnt := sql%rowcount;
      /*
      if row_cnt = 1 then
         commit;
      else
         rollback;
      end if;
      */
      if row_cnt != 0 then
         commit;

      end if;

      exception
      when others then
         err_msg := sqlerrm;
end;
/
