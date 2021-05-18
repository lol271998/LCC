SELECT
  Title, StreamDate, Charge
FROM
  MOVIE
  NATURAL JOIN MOVIE_GENRE
  JOIN GENRE USING (GenreId)
  JOIN STREAM USING (MovieId)
WHERE
  Label = 'Thriller'
  AND YEAR(StreamDate) = '2017'
  AND MONTH(StreamDate) = '12'
ORDER BY
  Title,
  StreamDate DESC;
