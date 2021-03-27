SELECT Name, MAX(Charge) AS MaxCharge
FROM CUSTOMER NATURAL JOIN STREAM
WHERE Country = 'United States'
AND YEAR(StreamDate) = 2018
GROUP BY Name
ORDER BY MaxCharge DESC, Name;