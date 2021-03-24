CREATE TABLE ITEM (
    ID NUMBER,
    CONSTRAINT ITEM_ID_PK PRIMARY KEY (ID),
    ITEM_NAME NVARCHAR2(20),
    DATE_CREATED DATE,
    LAST_UPDATE_DATE DATE,
    DESCRIPTION NVARCHAR2(20)
);

CREATE SEQUENCE ITEM_SEQ MINVALUE 1 MAXVALUE 100  START WITH 1 INCREMENT BY 1;