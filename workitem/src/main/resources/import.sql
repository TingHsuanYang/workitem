

INSERT INTO pcc_developer (pk_pcc_developer,name,email,create_date,update_date) VALUES (pcc_developer_SEQ.nextval,'evan','evan@webcomm.com.tw',sysdate,sysdate ); 
INSERT INTO pcc_developer (pk_pcc_developer,name,email,create_date,update_date) VALUES (pcc_developer_SEQ.nextval,'mike.chen','mike.chen@webcomm.com.tw',sysdate,sysdate ); 
INSERT INTO category (pk_category,description,create_date,update_date,FK_PCC_DEVELOPER) VALUES (category_SEQ.nextval,'休假事項',sysdate,sysdate,1 );
INSERT INTO category (pk_category,description,create_date,update_date,FK_PCC_DEVELOPER) VALUES (category_SEQ.nextval,'待辦事項',sysdate,sysdate,1 ); 
INSERT INTO category (pk_category,description,create_date,update_date,FK_PCC_DEVELOPER) VALUES (category_SEQ.nextval,'三代會議',sysdate,sysdate,1 ); 
INSERT INTO category (pk_category,description,create_date,update_date,FK_PCC_DEVELOPER) VALUES (category_SEQ.nextval,'申訴系統',sysdate,sysdate,1 );  
INSERT INTO category_detail (PK_CATEGORY_DETAIL,fk_category,DESCRIPTION,create_date,update_date, fk_Pcc_Developer) VALUES (CATEGORY_DETAIL_SEQ.nextval,1,'休假事項',to_date('2018-10-01','yyyy-mm-dd'),to_date('2018-10-01','yyyy-mm-dd'),1 ); 
INSERT INTO category_detail (PK_CATEGORY_DETAIL,fk_category,DESCRIPTION,create_date,update_date, fk_Pcc_Developer) VALUES (CATEGORY_DETAIL_SEQ.nextval,51,'無障礙網頁修改',to_date('2018-10-01','yyyy-mm-dd'),to_date('2018-10-01','yyyy-mm-dd'),1 ); 
INSERT INTO category_detail (PK_CATEGORY_DETAIL,fk_category,DESCRIPTION,create_date,update_date, fk_Pcc_Developer) VALUES (CATEGORY_DETAIL_SEQ.nextval,51,'新版申訴系統介接',to_date('2018-10-02','yyyy-mm-dd'),to_date('2018-10-02','yyyy-mm-dd'),1 ); 
INSERT INTO category_detail (PK_CATEGORY_DETAIL,fk_category,DESCRIPTION,create_date,update_date, fk_Pcc_Developer) VALUES (CATEGORY_DETAIL_SEQ.nextval,51,'新版申訴系統介接2',to_date('2018-10-02','yyyy-mm-dd'),to_date('2018-10-02','yyyy-mm-dd'),1 ); 
INSERT INTO item (pk_item,fk_category_detail,fk_pcc_developer,content,work_time,create_date,update_date) VALUES (item_SEQ.nextval,1,1,'測試代辦事項',8,to_date('2018-10-01','yyyy-mm-dd'),to_date('2018-10-01','yyyy-mm-dd') ); 
INSERT INTO item (pk_item,fk_category_detail,fk_pcc_developer,content,work_time,create_date,update_date) VALUES (item_SEQ.nextval,51,1,'測試申訴系統內容內容1',4,to_date('2018-10-02','yyyy-mm-dd'),to_date('2018-10-02','yyyy-mm-dd') ); 
INSERT INTO item (pk_item,fk_category_detail,fk_pcc_developer,content,work_time,create_date,update_date) VALUES (item_SEQ.nextval,51,1,'測試申訴系統內容內容2',4,to_date('2018-10-02','yyyy-mm-dd'),to_date('2018-10-02','yyyy-mm-dd') ); 
INSERT INTO item (pk_item,fk_category_detail,fk_pcc_developer,content,work_time,create_date,update_date) VALUES (item_SEQ.nextval,101,1,'測試申訴系統2內容內容',8,to_date('2018-10-03','yyyy-mm-dd'),to_date('2018-10-03','yyyy-mm-dd') );

