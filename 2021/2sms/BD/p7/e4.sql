SELECT
	S1.Name	AS	Supervisor,
	COUNT(S2.StaffId) AS N
FROM
	STAFF S2
	RIGHT	OUTER	JOIN STAFF S1
ON(S1.StaffId = S2.Supervisor)
GROUP BY S1.Name
ORDER BY N DESC, S1.Name ASC;
