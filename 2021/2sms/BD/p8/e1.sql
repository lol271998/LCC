DROP FUNCTION IF EXISTS getChargeValue;
DELIMITER $

CREATE FUNCTION
getChargeValue(stream_time DATETIME, movie_id INT, customer_id INT)
RETURNS DECIMAL(4,2)
BEGIN
  DECLARE c DECIMAL(4,2);
  DECLARE movie_duration INT;
  DECLARE country_name VARCHAR(128);
  DECLARE region_name VARCHAR(128);

  SELECT Duration INTO movie_duration
  FROM MOVIE WHERE MovieId = movie_id;

  SELECT Country INTO country_name
  FROM CUSTOMER WHERE CustomerId = customer_id;

  SELECT REGION.Name INTO region_name
  FROM REGION JOIN COUNTRY USING (RegionId) WHERE COUNTRY.Name = country_name;

  SET c = 0.5 + 0.01 * movie_duration;

  IF HOUR(stream_time) >= 21 THEN
    SET c = c + 0.75;
    IF WEEKDAY(stream_time) >= 4 THEN
      SET c = c + 0.75;
    END IF;
  END IF;
  IF country_name = 'United States' OR region_name = 'Europe' THEN
  SET c = c + 1;
  END IF;

  RETURN c;
END $
DELIMITER ;

SELECT
   CustomerId, Name, Country,
   getChargeValue('2019-04-11 20:59:59', MovieId, CustomerId) AS V1,
   getChargeValue('2019-04-11 21:00:00', MovieId, CustomerId) AS V2,
   getChargeValue('2019-04-12 21:00:00', MovieId, CustomerId) AS V3
FROM MOVIE, CUSTOMER
WHERE Title='Pulp Fiction'
AND
(
   CustomerId = (SELECT CustomerId FROM CUSTOMER WHERE Country='Brazil' ORDER BY Name LIMIT 1)
OR
   CustomerId = (SELECT CustomerId FROM CUSTOMER WHERE Country='Germany' ORDER BY Name LIMIT 1)
OR
   CustomerId = (SELECT CustomerId FROM CUSTOMER WHERE Country='United States' ORDER BY Name LIMIT 1)
)
ORDER BY Country;
