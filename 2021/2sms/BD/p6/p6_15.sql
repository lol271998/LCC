SELECT Name, COUNT(*) AS N
FROM MOVIE NATURAL JOIN MOVIE_ACTOR
           NATURAL JOIN ACTOR
GROUP BY Name
ORDER BY N DESC, Name
LIMIT 20;