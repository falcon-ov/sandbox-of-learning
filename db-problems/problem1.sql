-- Задание 1. Сортировка и группировка по дате
-- Таблица: sales
-- Структура:
-- id (int)
-- amount (decimal)
-- sale_date (date)
-- Задача:
-- Посчитайте количество продаж по месяцам и годам.
-- Отсортируйте результат так, чтобы сначала шли месяцы с наибольшим количеством продаж.
-- Подсказка: использовать GROUP BY YEAR(sale_date), MONTH(sale_date) и ORDER BY COUNT(*) DESC.

-- Выполнение

-- CREATE TABLE sales(
-- id int AUTO_INCREMENT PRIMARY KEY,
-- amount decimal,
-- sale_date date
-- );

-- INSERT INTO sales(amount, sale_date) values(100, '2025-10-09'); -- October 2025
-- INSERT INTO sales(amount, sale_date) values(100, '2025-10-10'); -- October 2025
-- INSERT INTO sales(amount, sale_date) values(100, '2025-11-11'); -- November 2025
-- INSERT INTO sales(amount, sale_date) values(100, '2025-12-12'); -- December 2025
-- INSERT INTO sales(amount, sale_date) values(100, '2025-12-13'); -- December 2025
-- INSERT INTO sales(amount, sale_date) values(100, '2025-12-17'); -- December 2025
-- INSERT INTO sales(amount, sale_date) values(100, '2026-01-14'); -- January 2026
-- INSERT INTO sales(amount, sale_date) values(100, '2026-12-14'); -- December 2026


SELECT count(*), year(sale_date) ,month(sale_date) FROM sales
group by YEAR(sale_date), month(sale_date)
order by count(*) desc;
