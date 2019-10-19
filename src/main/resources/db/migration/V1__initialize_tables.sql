CREATE TABLE IF NOT EXISTS tbl_product(
	product_id INT AUTO_INCREMENT,
	product_nm VARCHAR(100) NOT NULL,
	product_vl DECIMAL(10,2) NOT NULL,
	create_user_id VARCHAR(35) NOT NULL,
	create_ts TIMESTAMP NOT NULL,
	last_updt_user_id VARCHAR(35) NULL,
	last_updt_ts TIMESTAMP NULL,
	PRIMARY KEY (product_id),
);


INSERT INTO tbl_product (product_nm,product_vl,create_user_id,create_ts) VALUES('Fifa2019 game',50.00,'abdesousa',CURRENT_TIMESTAMP());
INSERT INTO tbl_product (product_nm,product_vl,create_user_id,create_ts) VALUES('BattleField 5 game',45.00,'rocruz',CURRENT_TIMESTAMP());
INSERT INTO tbl_product (product_nm,product_vl,create_user_id,create_ts,last_updt_user_id,last_updt_ts) VALUES('Minecraft game',60.00,'clarasousa',CURRENT_TIMESTAMP(),'abdesousa',CURRENT_TIMESTAMP());
