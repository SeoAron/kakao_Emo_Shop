select * from cart;
select * from jumun;
select * from jumun_detail;
select * from md_emolist;
select * from member;
select * from p_emo;
select * from p_emostyle;

select md.m_no 이번놈이가진이모티콘 ,p.p_name from md_emolist md
join p_emo p on p.p_no = md.p_no where md.m_no= 2 ;

select ?대쾲?덉씠媛吏꾩씠紐⑦떚肄?媛吏꾩씠紐⑦떚肄섏씠由?
from (select rownum r, md.m_no ?대쾲?덉씠媛吏꾩씠紐⑦떚肄?,p.p_name 媛吏꾩씠紐⑦떚肄섏씠由?from md_emolist md
join p_emo p on p.p_no = md.p_no where md.m_no= 2) x where r=3;

INSERT INTO md_emolist (M_OWNEMO, P_NO, M_NO) VALUES (1, 1 , 2);
INSERT INTO md_emolist (M_OWNEMO, P_NO, M_NO) VALUES (2, 2 , 2);
INSERT INTO md_emolist (M_OWNEMO, P_NO, M_NO) VALUES (3, 3 , 2);
INSERT INTO md_emolist (M_OWNEMO, P_NO, M_NO) VALUES (4, 4 , 2);
INSERT INTO md_emolist (M_OWNEMO, P_NO, M_NO) VALUES (5, 5 , 2);
commit;

--총 주문건수
select p.p_name||'외 '||(select count(m_no)-1 from cart where m_no =3)||'건'  
from cart c join p_emo p on p.p_no = c.p_no 
where m_no = 3 and rownum =1;


--총구매액
select sum(p.p_price) 총구매액 from cart c join p_emo p on c.p_no = p.p_no where m_no=3;

INSERT INTO jumun VALUES (7, sysdate, 
(select p.p_name||'외 '||(select count(m_no)-1 from cart where m_no =3)||'건'  
from cart c join p_emo p on p.p_no = c.p_no where m_no = 3 and rownum =1), 
(select sum(p.p_price) from cart c join p_emo p on c.p_no = p.p_no where m_no=3),1);

INSERT INTO jumun VALUES (?, sysdate, 
(select p.p_name||'외 '||(select count(m_no)-1 from cart where m_no =?)||'건'  
from cart c join p_emo p on p.p_no = c.p_no where m_no = ? and rownum =1), 
(select sum(p.p_price) from cart c join p_emo p on c.p_no = p.p_no where m_no=?),?);

select c.m_no ?쇰쾲?덉씠媛吏꾩씠紐⑦떚肄?,p.p_name,p.p_price from cart c
join p_emo p on p.p_no = c.p_no where c.m_no= 3;

select emoname from (select rownum r ,p.p_name emoname from cart c
join p_emo p on p.p_no = c.p_no where c.m_no= 3) x where r=2;

select p.p_name ,p.p_price from cart c
join p_emo p on p.p_no = c.p_no where c.m_no= 3;

select emoprice from (select rownum r, p.p_price emoprice from cart c
join p_emo p on p.p_no = c.p_no where c.m_no= 3) x where r=2;

select ?대쾲?덉씠媛吏꾩씠紐⑦떚肄?媛吏꾩씠紐⑦떚肄섏씠由?
from (select rownum r, md.m_no ?대쾲?덉씠媛吏꾩씠紐⑦떚肄?,p.p_name 媛吏꾩씠紐⑦떚肄섏씠由?from md_emolist md
join p_emo p on p.p_no = md.p_no where md.m_no= 2) x where r=3;

select jnom from (select rownum r, j_no jnom from jumun where m_no=2 order by j_no desc) x where r=1;




INSERT INTO jumun_detail VALUES (JUMUN_DETAIL_JD_NO_SEQ.nextval,
(select jnom from (select rownum r, j_no jnom from jumun where m_no=2 order by j_no desc) x where r=1),
(select emoname from (select rownum r ,p.p_name emoname from cart c
join p_emo p on p.p_no = c.p_no where c.m_no= 3) x where r=2),
(select emoprice from (select rownum r, p.p_price emoprice from cart c
join p_emo p on p.p_no = c.p_no where c.m_no= 3) x where r=2));

DELETE FROM jumun_detail where jd_no=3; 
commit;

