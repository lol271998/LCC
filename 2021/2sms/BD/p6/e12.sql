SELECT
  REGION.Name, COUNT(*) AS N
FROM
  COUNTRY JOIN REGION USING (RegionId)
GROUP BY REGION.Name
ORDER BY N ASC;
