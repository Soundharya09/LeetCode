# Write your MySQL query statement below
SELECT name
FROM Employee
WHERE Id IN (
    SELECT managerId
    From Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
);
