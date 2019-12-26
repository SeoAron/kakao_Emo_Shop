DROP TABLE jumun_detail CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE jumun CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE md_emolist CASCADE CONSTRAINTS;
DROP TABLE p_emo CASCADE CONSTRAINTS;
DROP TABLE p_emostyle CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE member(
		m_no                          		NUMBER(10)		 NULL ,
		m_niname                      		VARCHAR2(50)		 NOT NULL,
		m_id                          		VARCHAR2(50)		 NOT NULL,
		m_pass                        		VARCHAR2(50)		 NOT NULL,
		m_phone                       		VARCHAR2(30)		 NULL 
);

DROP SEQUENCE member_m_no_SEQ;

CREATE SEQUENCE member_m_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE member is '회원';
COMMENT ON COLUMN member.m_no is '회원번호';
COMMENT ON COLUMN member.m_niname is '회원닉네임';
COMMENT ON COLUMN member.m_id is '회원아이디';
COMMENT ON COLUMN member.m_pass is '회원비밀번호';
COMMENT ON COLUMN member.m_phone is '회원전화번호';


/**********************************/
/* Table Name: 이모티콘스타일 */
/**********************************/
CREATE TABLE p_emostyle(
		p_emostyleno                  		NUMBER(10)		 NULL ,
		p_emostyle                    		VARCHAR2(60)		 NOT NULL
);

COMMENT ON TABLE p_emostyle is '이모티콘스타일';
COMMENT ON COLUMN p_emostyle.p_emostyleno is '이모티콘그룹넘버';
COMMENT ON COLUMN p_emostyle.p_emostyle is '이모티콘스타일';


/**********************************/
/* Table Name: 이모티콘 */
/**********************************/
CREATE TABLE p_emo(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(100)		 NOT NULL,
		p_price                       		NUMBER(10)		 DEFAULT 0		 NULL ,
		p_desc                        		VARCHAR2(255)		 NULL ,
		p_emostyleno                  		NUMBER(10)		 NULL ,
		p_click                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE p_emo_p_no_SEQ;

CREATE SEQUENCE p_emo_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE p_emo is '이모티콘';
COMMENT ON COLUMN p_emo.p_no is '이모티콘번호';
COMMENT ON COLUMN p_emo.p_name is '이모티콘이름';
COMMENT ON COLUMN p_emo.p_price is '이모티콘가격';
COMMENT ON COLUMN p_emo.p_desc is '이모티콘설명';
COMMENT ON COLUMN p_emo.p_emostyleno is '이모티콘그룹넘버';
COMMENT ON COLUMN p_emo.p_click is '아이템조회수';


/**********************************/
/* Table Name: 회원보유이모티콘리스트 */
/**********************************/
CREATE TABLE md_emolist(
		m_ownemo                      		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		m_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE md_emolist_m_ownemo_SEQ;

CREATE SEQUENCE md_emolist_m_ownemo_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE md_emolist is '회원보유이모티콘리스트';
COMMENT ON COLUMN md_emolist.m_ownemo is '회원이모티콘목록번호';
COMMENT ON COLUMN md_emolist.p_no is '이모티콘번호';
COMMENT ON COLUMN md_emolist.m_no is '회원번호';


/**********************************/
/* Table Name: 장바구니 */
/**********************************/
CREATE TABLE cart(
		cart_item_no                  		NUMBER(10)		 NULL ,
		m_no                          		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		m_niname                      		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE cart_cart_item_no_SEQ;

CREATE SEQUENCE cart_cart_item_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE cart is '장바구니';
COMMENT ON COLUMN cart.cart_item_no is '장바구니아이템번호';
COMMENT ON COLUMN cart.m_no is '회원번호';
COMMENT ON COLUMN cart.p_no is '상품번호';
COMMENT ON COLUMN cart.m_niname is '회원닉네임';


/**********************************/
/* Table Name: 주문 */
/**********************************/
CREATE TABLE jumun(
		j_no                          		NUMBER(10)		 NULL ,
		j_date                        		DATE		 DEFAULT sysdate		 NULL ,
		j_desc                        		VARCHAR2(255)		 NULL ,
		j_price                       		NUMBER(10)		 NULL ,
		m_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE jumun_j_no_SEQ;

CREATE SEQUENCE jumun_j_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE jumun is '주문';
COMMENT ON COLUMN jumun.j_no is '주문번호';
COMMENT ON COLUMN jumun.j_date is '주문날짜';
COMMENT ON COLUMN jumun.j_desc is '주문설명';
COMMENT ON COLUMN jumun.j_price is '주문총가격';
COMMENT ON COLUMN jumun.m_no is '회원번호';


/**********************************/
/* Table Name: 게시판 */
/**********************************/
CREATE TABLE board(
		board_no                      		NUMBER(10)		 NOT NULL,
		board_title                   		VARCHAR2(255)		 NULL ,
		board_writer                  		VARCHAR2(30)		 NULL ,
		board_content                 		VARCHAR2(255)		 NULL 
);

DROP SEQUENCE board_board_no_SEQ;

CREATE SEQUENCE board_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE board is '게시판';
COMMENT ON COLUMN board.board_no is '게시물번호';
COMMENT ON COLUMN board.board_title is '게시물제목';
COMMENT ON COLUMN board.board_writer is '게시물작성자';
COMMENT ON COLUMN board.board_content is '게시물내용';


/**********************************/
/* Table Name: 주문디테일 */
/**********************************/
CREATE TABLE jumun_detail(
		jd_no                         		NUMBER(10)		 NULL ,
		j_no                          		NUMBER(10)		 NULL ,
		jd_emoname                    		VARCHAR2(255)		 NULL ,
		jd_emoprice                   		NUMBER(10)		 NULL 
);

DROP SEQUENCE jumun_detail_jd_no_SEQ;

CREATE SEQUENCE jumun_detail_jd_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE jumun_detail is '주문디테일';
COMMENT ON COLUMN jumun_detail.jd_no is '주문디테일넘버';
COMMENT ON COLUMN jumun_detail.j_no is '주문디테일번호';
COMMENT ON COLUMN jumun_detail.jd_emoname is '주문이모티콘이름';
COMMENT ON COLUMN jumun_detail.jd_emoprice is '주문이모티콘가격';



ALTER TABLE member ADD CONSTRAINT IDX_member_PK PRIMARY KEY (m_no);

ALTER TABLE p_emostyle ADD CONSTRAINT IDX_p_emostyle_PK PRIMARY KEY (p_emostyleno);

ALTER TABLE p_emo ADD CONSTRAINT IDX_p_emo_PK PRIMARY KEY (p_no);
ALTER TABLE p_emo ADD CONSTRAINT IDX_p_emo_FK0 FOREIGN KEY (p_emostyleno) REFERENCES p_emostyle (p_emostyleno);

ALTER TABLE md_emolist ADD CONSTRAINT IDX_md_emolist_PK PRIMARY KEY (m_ownemo);
ALTER TABLE md_emolist ADD CONSTRAINT IDX_md_emolist_FK0 FOREIGN KEY (p_no) REFERENCES p_emo (p_no);
ALTER TABLE md_emolist ADD CONSTRAINT IDX_md_emolist_FK1 FOREIGN KEY (m_no) REFERENCES member (m_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_item_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (m_no) REFERENCES member (m_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES p_emo (p_no);

ALTER TABLE jumun ADD CONSTRAINT IDX_jumun_PK PRIMARY KEY (j_no);
ALTER TABLE jumun ADD CONSTRAINT IDX_jumun_FK0 FOREIGN KEY (m_no) REFERENCES member (m_no);

ALTER TABLE board ADD CONSTRAINT IDX_board_PK PRIMARY KEY (board_no);

ALTER TABLE jumun_detail ADD CONSTRAINT IDX_jumun_detail_PK PRIMARY KEY (jd_no);
ALTER TABLE jumun_detail ADD CONSTRAINT IDX_jumun_detail_FK0 FOREIGN KEY (j_no) REFERENCES jumun (j_no);

