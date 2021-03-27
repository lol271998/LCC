SELECT REGION.Name, COUNT(*) AS N 
FROM REGION JOIN COUNTRY Using(RegionId)
JOIN CUSTOMER ON(CUSTOMER.Country = COUNTRY.Name)
GROUP BY REGION.Name;