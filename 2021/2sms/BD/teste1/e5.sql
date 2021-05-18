UPDATE STREAM
SET Charge = 0
WHERE
  CustomerId <> ALL (
    SELECT
      CustomerId
    FROM
      CUSTOMER
      JOIN COUNTRY ON (CUSTOMER.Country = COUNTRY.Name)
      JOIN REGION USING (RegionId)
    WHERE
      REGION.Name = 'America'
    )
  AND
  MovieId = ANY (
    SELECT MovieId
    FROM MOVIE
    NATURAL JOIN MOVIE_GENRE
    NATURAL JOIN GENRE
    WHERE Label = 'Biography' AND Duration <= 120
  );
