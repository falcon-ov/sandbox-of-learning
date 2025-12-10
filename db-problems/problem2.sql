-- Задание 2. JOIN с простыми условиями
--
-- Таблицы:
-- orders (id, customer_id, order_date)
-- customers (id, name)
-- Задача:
-- Получите список всех заказов вместе с именами клиентов.
-- Отсортируйте по дате заказа.
-- Подсказка: использовать JOIN customers ON orders.customer_id = customers.id.

# CREATE TABLE customers(
# id INT AUTO_INCREMENT PRIMARY KEY ,
# name TEXT
# );

# CREATE TABLE orders(
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     customer_id INT,
#     order_date DATE,
#     FOREIGN KEY (customer_id) REFERENCES customers(id)
# );

# INSERT INTO customers(name) VALUES ('Oxana'),('Dan'),('Vasea');
# INSERT INTO orders(CUSTOMER_ID, ORDER_DATE) VALUES
#                                                 (1, '2025-10-01'),
#                                                 (1, '2025-10-02'),
#                                                 (1,'2025-10-03'),
#                                                 (2, '2026-11-14'),
#                                                 (2,'2026-11-20'),
#                                                 (3,'2027-12-01');

SELECT * FROM orders o
JOIN customers c ON c.id = o.customer_id
ORDER BY o.order_date DESC ;