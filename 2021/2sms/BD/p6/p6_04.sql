SELECT COUNT(*), SUM(Charge) FROM STREAM WHERE Year(StreamDate) = 2018;
SELECT YEAR(StreamDate) AS Y, COUNT(*) AS Num,SUM(Charge) AS Soma