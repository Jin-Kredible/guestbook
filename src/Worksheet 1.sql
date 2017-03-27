select*from guestbook;

create sequence seq_guestbook start with 1 increment by 1 maxvalue 9999999;
drop sequence seq_guestbook;

insert into guestbook values(seq_guestbook.nextval, '둘리', '1234', 'hoy', sysdate);

commit;

select no, name, password, content, to_char(sysdate, 'yyyy/dd/mm') from guestbook order by pub_date desc;
-- delete
delete;

delete from guestbook;
delete from guestbook where no=3 and password='1234';
rollback;