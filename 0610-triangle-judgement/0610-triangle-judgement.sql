# Write your MySQL query statement below
SELECT *, if(x+y>z and y+z>x and x+z>y, "Yes","No") AS triangle FROM triangle