package DAO;

public class ScriptPostgre {
//	CREATE TABLE GAME_1 (
//			ID SERIAL NOT NULL,
//			COL_1 INT NOT NULL,
//			COL_2 INT NOT NULL,
//			COL_3 INT NOT NULL,
//			COL_4 INT NOT NULL,
//			COL_5 INT NOT NULL,
//			COL_6 INT NOT NULL,
//			COL_7 INT NOT NULL,
//			COL_8 INT NOT NULL,
//			COL_9 INT NOT NULL,
//			PRIMARY KEY(ID)
//		);
//
//		INSERT INTO GAME_1 (ID, COL_1, COL_2, COL_3, COL_4, COL_5, COL_6, COL_7, COL_8, COL_9)
//		VALUES
//		(1, 4, 2, 3, 9, 7, 1, 5, 6, 8),
//		(2, 8, 5, 1, 3, 4, 6, 9, 7, 2),
//		(3, 6, 7, 9, 5, 8, 2, 4, 3, 1),
//		(4, 1, 4, 6, 2, 3, 5, 7, 8, 9),
//		(5, 3, 9, 5, 7, 8, 4, 1, 2, 6),
//		(6, 7, 8, 2, 7, 6, 9, 3, 5, 4),
//		(7, 9, 6, 7, 5, 1, 8, 2, 4, 3),
//		(8, 2, 3, 4, 6, 9, 7, 8, 1, 5),
//		(9, 5, 1, 8, 4, 2, 3, 6, 9, 7);
//
//
//
//		SELECT
//			COL_1,
//			COL_2,
//			COL_3,
//			COL_4,
//			COL_5,
//			COL_6,
//			COL_7,
//			COL_8,
//			COL_9
//			FROM GAME_1;
//
//
//		CREATE TABLE GAME_2 (
//			ID SERIAL NOT NULL,
//			COL_1 INT NOT NULL,
//			COL_2 INT NOT NULL,
//			COL_3 INT NOT NULL,
//			COL_4 INT NOT NULL,
//			COL_5 INT NOT NULL,
//			COL_6 INT NOT NULL,
//			COL_7 INT NOT NULL,
//			COL_8 INT NOT NULL,
//			COL_9 INT NOT NULL,
//			PRIMARY KEY(ID)
//		);
//		    
//		INSERT INTO GAME_2 (ID, COL_1, COL_2, COL_3, COL_4, COL_5, COL_6, COL_7, COL_8, COL_9) VALUES
//		(1, 1, 4, 5, 3, 7, 8, 9, 2, 6),
//		(2, 3, 9, 7, 4, 2, 6, 8, 4, 1),
//		(3, 6, 2, 8, 9, 5, 1, 3, 7, 4),
//		(4, 4, 7, 9, 5, 1, 3, 2, 6, 8),
//		(5, 8, 3, 2, 7, 6, 4, 1, 9, 5),
//		(6, 5, 1, 6, 2, 8, 9, 4, 3, 7),
//		(7, 9, 5, 1, 8, 3, 7, 6, 4, 2),
//		(8, 7, 8, 4, 6, 9, 2, 5, 1, 3),
//		(9, 2, 6, 3, 1, 4, 5, 7, 8, 9);
//
//		SELECT
//			COL_1,
//			COL_2,
//			COL_3,
//			COL_4,
//			COL_5,
//			COL_6,
//			COL_7,
//			COL_8,
//			COL_9
//			FROM GAME_2;
//
//		CREATE TABLE GAME_3 (
//			ID SERIAL NOT NULL,
//			COL_1 INT NOT NULL,
//			COL_2 INT NOT NULL,
//			COL_3 INT NOT NULL,
//			COL_4 INT NOT NULL,
//			COL_5 INT NOT NULL,
//			COL_6 INT NOT NULL,
//			COL_7 INT NOT NULL,
//			COL_8 INT NOT NULL,
//			COL_9 INT NOT NULL,
//			PRIMARY KEY(ID)
//		);
//
//
//		INSERT INTO GAME_3 (ID, COL_1, COL_2, COL_3, COL_4, COL_5, COL_6, COL_7, COL_8, COL_9)
//		VALUES
//		  (1, 5, 1, 9, 8, 7, 2, 4, 3, 6),
//		  (2, 7, 6, 2, 4, 9, 3, 8, 1, 5),
//		  (3, 4, 3, 8, 6, 5, 1, 7, 9, 2),
//		  (4, 6, 9, 7, 3, 8, 4, 5, 2, 1),
//		  (5, 1, 2, 5, 7, 6, 9, 3, 4, 8),
//		  (6, 3, 8, 4, 2, 1, 5, 6, 7, 9),
//		  (7, 2, 5, 3, 9, 4, 6, 1, 8, 7),
//		  (8, 9, 7, 6, 1, 3, 8, 2, 5, 4),
//		  (9, 8, 4, 1, 5, 2, 7, 9, 6, 3);
//
//
//
//		SELECT
//			COL_1,
//			COL_2,
//			COL_3,
//			COL_4,
//			COL_5,
//			COL_6,
//			COL_7,
//			COL_8,
//			COL_9
//			FROM GAME_3;
//
//
//		CREATE TABLE GAME_4 (
//			ID SERIAL NOT NULL,
//			COL_1 INT NOT NULL,
//			COL_2 INT NOT NULL,
//			COL_3 INT NOT NULL,
//			COL_4 INT NOT NULL,
//			COL_5 INT NOT NULL,
//			COL_6 INT NOT NULL,
//			COL_7 INT NOT NULL,
//			COL_8 INT NOT NULL,
//			COL_9 INT NOT NULL,
//			PRIMARY KEY(ID)
//		);
//
//		INSERT INTO GAME_4 (ID, COL_1, COL_2, COL_3, COL_4, COL_5, COL_6, COL_7, COL_8, COL_9)
//		VALUES
//		(1, 8, 1, 3, 2, 4, 7, 6, 9, 5),
//		(2, 5, 6, 2, 9, 3, 8, 4, 7, 1),
//		(3, 4, 9, 7, 6, 5, 1, 8, 2, 3),
//		(4, 1, 4, 5, 3, 8, 9, 2, 6, 7),
//		(5, 2, 8, 9, 7, 6, 5, 1, 3, 4),
//		(6, 7, 3, 6, 1, 2, 4, 9, 5, 8),
//		(7, 3, 5, 1, 4, 9, 6, 7, 8, 2),
//		(8, 6, 2, 4, 8, 7, 3, 5, 1, 9),
//		(9, 9, 7, 8, 5, 1, 2, 3, 4, 6);
//
//
//
//		SELECT
//			COL_1,
//			COL_2,
//			COL_3,
//			COL_4,
//			COL_5,
//			COL_6,
//			COL_7,
//			COL_8,
//			COL_9
//			FROM GAME_4;
//
//

}
