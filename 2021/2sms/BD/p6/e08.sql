SELECT
	Title, Name
FROM
	ACTOR
	NATURAL JOIN MOVIE
	NATURAL JOIN MOVIE_ACTOR
WHERE Title LIKE '%Superman%';
