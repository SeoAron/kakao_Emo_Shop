select * from cart;
select * from jumun;

select * from md_emolist;
select * from member;
select * from p_emo;
select * from p_emostyle;

select md.m_no from md_emolist;

/*select md.m_no 이번놈이가진이모티콘,p.p_name from md_emolist md
join p_emo p on p.p_no = md.p_no where md.m_no=2;*/

select (count(m_no)*2200) total from cart where m_no=3;

select md.m_no from p_emo md
join p_emo p on p.p_no = md.p_no where md.m_no = 3; 


INSERT INTO cart (cart_item_no,m_no,p_no,m_niname) 
VALUES (1, 2, 1, '홍진영');


INSERT INTO cart (cart_item_no,m_no,p_no,m_niname) 
VALUES (2, 3, 2, 'java3');


INSERT INTO cart (cart_item_no,m_no,p_no,m_niname)  
VALUES (3, 3, 3, 'java3');


INSERT INTO cart (cart_item_no,m_no,p_no,m_niname) 
VALUES (4, 3, 4, 'java3');

INSERT INTO cart (cart_item_no,m_no,p_no,m_niname) 
VALUES (5, 3, 5, 'java3');

INSERT INTO cart (cart_item_no,m_no,p_no,m_niname) 
VALUES (6, 3, 6, 'java3');


INSERT INTO member (m_no, m_niname, m_id, m_pass,m_phone) 
VALUES (999, '어드민', 'admin','admin','999-9999');

commit;
