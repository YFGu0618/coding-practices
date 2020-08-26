-- LeetCode Solution No.0626.
-- https://leetcode.com/problems/exchange-seats
-- Yifan Gu

Create table If Not Exists seat(id int, student varchar(255))
Truncate table seat
insert into seat (id, student) values ('1', 'Abbot')
insert into seat (id, student) values ('2', 'Doris')
insert into seat (id, student) values ('3', 'Emerson')
insert into seat (id, student) values ('4', 'Green')
insert into seat (id, student) values ('5', 'Jeames')

-- Write your MySQL query statement below
SELECT
  IF(id < COUNT(*), IF(id % 2 = 0, id - 1, id + 1), id) AS id, student
FROM
  seat
ORDER BY
  id DESC
