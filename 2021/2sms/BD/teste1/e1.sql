SELECT
  Name,
  COUNT(StreamId) AS N,
  SUM(Charge)
FROM CUSTOMER
  LEFT OUTER JOIN STREAM
  ON(CUSTOMER.CustomerId = STREAM.CustomerId)
WHERE
  Country = 'India'
GROUP BY Name
HAVING N<=5;
