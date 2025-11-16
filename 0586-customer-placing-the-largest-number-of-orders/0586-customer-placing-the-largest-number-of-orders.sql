# Write your MySQL query statement below
WITH cnt AS (
    SELECT customer_number, COUNT(*) AS order_cnt
    FROM Orders
    GROUP BY customer_number
)
SELECT customer_number
FROM cnt
WHERE order_cnt = (SELECT MAX(order_cnt) FROM cnt);