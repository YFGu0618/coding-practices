-- LeetCode Solution No.0176.
-- https://leetcode.com/problems/second-highest-salary
-- Yifan Gu

Create table If Not Exists Employee (Id int, Salary int)
Truncate table Employee
insert into Employee (Id, Salary) values ('1', '100')
insert into Employee (Id, Salary) values ('2', '200')
insert into Employee (Id, Salary) values ('3', '300')

-- Write your MySQL query statement below
SELECT
  MAX(Salary) AS SecondHighestSalary
FROM
  Employee
WHERE
  Salary < (SELECT MAX(Salary) FROM Employee)
