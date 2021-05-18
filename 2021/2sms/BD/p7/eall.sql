--1
SELECT Name
FROM
	CUSTOMER LEFT JOIN STREAM USING(CustomerId)
WHERE
	StreamId IS NULL
AND
	Country = 'China'
;

--2

SELECT Country, COUNT(CustomerId)
FROM
	STREAM RIGHT JOIN CUSTOMER USING(CustomerId)
WHERE
	StreamId is NULL
GROUP BY Country;

--2a

SELECT Country, COUNT(CustomerId)
FROM
	CUSTOMER LEFT JOIN STREAM
USING(CustomerId)
WHERE
	StreamId IS NULL
GROUP BY Country
;

--3a

SELECT Title, COUNT(StreamId) AS N
FROM
	MOVIE LEFT JOIN STREAM USING (MovieId)
WHERE
	Year = 2015
GROUP BY Title
HAVING N<=5
;

--5
DELETE FROM STREAM
WHERE
	Charge <= 5.5
AND
	CustomerID IN
	(
		SELECT CustomerId
		FROM CUSTOMER
		WHERE Country = 'China'
	)
;

--ver quantas streams foram afetadas
SELECT *
FROM STREAM NATURAL JOIN CUSTOMER
WHERE Charge <= 5.5 AND Country = 'China';

DELETE FROM MOVIE_ACTOR
WHERE
	ActorId = (SELECT ActorId FROM ActorId
			   WHERE Name = 'Tom Cruise')
AND
	MovieId IN (SELECT MovieId
				FROM MOVIE_GENRE NATURAL JOIN GENRE
				WHERE Label = 'Action')
;

--6
SELECT MovieId, Title, Label

--9
SELECT Name, COUNT(*) AS N
FROM MOVIE
NATURAL JOIN MOVIE_ACTOR
NATURAL JOIN ACTOR
GROUP BY Name
HAVING N >= 15
ORDER BY N DESC, Name;

--10
SELECT Title
FROM MOVIE
NATURAL JOIN MOVIE_ACTOR
NATURAL JOIN ACTOR
WHERE Name = 'Johnny Depp';

--10
SELECT Title,A1.Name, A2.Name
FROM
	MOVIE
NATURAL JOIN
	(ACTOR A1 NATURAL JOIN MOVIE_ACTOR MA1)
JOIN
	(ACTOR A2
	 NATURAL JOIN MOVIE_ACTOR MA2)
USING(MovieId)
WHERE
A1.Name = 'Johnny Depp' AND
A1.Name <> A2.Name
ORDER BY Title, A2.Name;

--11
SELECT A1.Name, A2.Name, COUNT(*) AS N
FROM
	(ACTOR A1
	 NATURAL JOIN MOVIE_ACTOR MA1)
JOIN
	(ACTOR A2 NATURAL JOIN MOVIE_ACTOR MA2)
USING(MovieId)
WHERE A1.Name < A2.Name
GROUP BY A1.Name, A2.Name
HAVING N>=4
ORDER BY N DESC, A1.Name,A2.Name;
--ou ORDERBY 3 DESC,1,2;

--12
--O AVALIADOR NÃO ACEITA COMENTÁRIOS
UPDATE STREAM
SET Charge = 4.5
WHERE
	CustomerId <> ALL ( -- diferente de qualquer
		--Cliente não é da região africa
		SELECT CustomerId
		FROM CUSTOMER
		JOIN COUNTRY ON (CUSTOMER.Country = COUNTRY.Name)
		JOIN REGION USING(Region.id)
		WHERE REGION.Name = 'Africa'
	)
AND
	MovieId = ANY ( --igual a algum que obedeça
		--Filme é de ano anterior a 1985
		--e está classificado com o género Sci-Fi
		SELECT MovieId
		FROM MOVIE
		NATURAL JOIN MOVIE_GENRE
		NATURAL JOIN GENRE
		WHERE Year < 1985 AND Label = 'Sci-Fi'
	)
;

--13
SELECT StreamDate, Title, Name, Country
FROM STREAM
NATURAL JOIN MOVIE
NATURAL JOIN CUSTOMER
WHERE Country <> 'China'
AND MovieId IN(
	--ids de filmes onde participa o johnny depp
)
AND MovieId NOT IN(
	--Ids de filmes onde participa Helena Bonham Carter
)

ORDER BY StreamDate DESC
LIMIT 15;

--14
SELECT Title, REGION.Name, StreamId
FROM
	MOVIE JOIN REGION --todas as combinações
	LEFT JOIN
	(STREAM NATURAL JOIN CUSTOMER
	 JOIN COUNTRY ON (CUSTOMER.Country = COUNTRY.Name)
	)
	USING (RegionId,MovieId)
WHERE Title LIKE '%war'
ORDER BY Title, REGION.Name;

SELECT Title, REGION.Name, COUNT(StreamId) AS N
FROM
	MOVIE JOIN REGION --todas as combinações
	LEFT JOIN
	(STREAM NATURAL JOIN CUSTOMER
	 JOIN COUNTRY ON (CUSTOMER.Country = COUNTRY.Name)
	)
	USING (RegionId,MovieId)
WHERE Title LIKE '%war'
GROUP BY Title, REGION.Name
ORDER BY Title, REGION.Name;
