# Write your MySQL query statement below
select max(Salary) SecondHighestSalary
from Employee
where Salary < (select max(Salary) from Employee)