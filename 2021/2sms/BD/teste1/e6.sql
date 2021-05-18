SELECT
  Title, COUNT(StreamDate) AS Viewed
FROM
  MOVIE
  NATURAL JOIN STREAM
  GROUP BY Title
  HAVING Viewed <= 1;
