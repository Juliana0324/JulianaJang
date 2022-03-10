create or replace procedure update_test_proc(i_num number, i_age number, i_email varchar2,
row_cnt out number, err_msg out varchar2)

is

begin

-- 컬럼명과 in parameter명을 다ㅡㄹ게 설정한다.
      update     test_procedure
      set        age = i_age, email = i_email
      where      num = i_num;

-- 변경된 행의 수를 암시적 커서(sql)를 사용하여 얻는다.
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
