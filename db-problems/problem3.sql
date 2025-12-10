-- Задание 3. Топ-N записи за конкретный месяц
-- Таблица: products_sales
-- Структура:
-- id (int)
-- product_name (varchar)
-- quantity (int)
-- sale_date (date)
-- Задача:
-- Найдите топ-3 продуктов по количеству продаж за июль 2022 года.
-- Отсортируйте по убыванию количества.
-- Подсказка: использовать WHERE MONTH(sale_date)=7 AND YEAR(sale_date)=2022 ORDER BY quantity DESC LIMIT 3.

# CREATE TABLE products_sales(
#   id INT AUTO_INCREMENT PRIMARY KEY,
#   product_name VARCHAR(100),
#   quantity INT,
#   sale_date DATE
# );

# INSERT INTO products_sales(PRODUCT_NAME, QUANTITY, SALE_DATE) VALUES
#                                                                   ('MacBook', 123, '2022-07-01'),
#                                                                   ('Iphone', 456, '2022-07-05'),
#                                                                   ('Ipad', 67, '2022-07-07'),
#                                                                   ('Xiaomi', 1506, '2023-09-10'),
#                                                                   ('Samsung', 1235, '2020-01-05');

SELECT * FROM products_sales
WHERE MONTH(sale_date) = 7 AND YEAR(sale_date) = 2022 ORDER BY quantity DESC LIMIT 3;