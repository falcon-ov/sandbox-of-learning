# Задание 4. Комбинированное
#
# Таблицы:
# employees (id, name, department_id)
# departments (id, name)
# salaries (employee_id, amount, date)
#
# Задача:
# Посчитайте среднюю зарплату по каждому отделу за 2023 год.
# Отсортируйте отделы по убыванию средней зарплаты.
# Выведите топ-2 отдела с самой высокой средней зарплатой.

# CREATE TABLE departments(
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     name TEXT
# );
# CREATE TABLE employees(
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     name TEXT,
#     department_id INT,
#     FOREIGN KEY (department_id) REFERENCES departments(id)
# );
# CREATE TABLE salaries(
#   employee_id INT,
#   amount INT,
#   date DATE,
#   FOREIGN KEY (employee_id) REFERENCES employees(id)
# );

# INSERT INTO departments (name) VALUES
#                                        ( 'IT'),
#                                        ( 'HR'),
#                                        ( 'Finance');
# INSERT INTO employees (name, department_id) VALUES
#                                                     ('Alice', 1),
#                                                     ('Bob', 1),
#                                                     ('Clara', 2),
#                                                     ('David', 3),
#                                                     ('Eva', 3);
# INSERT INTO salaries (employee_id, amount, date) VALUES
#                                                      (1, 3000, '2023-01-10'),
#                                                      (1, 3100, '2023-02-10'),
#                                                      (2, 2900, '2023-01-12'),
#                                                      (2, 2950, '2023-03-12'),
#
#                                                      (3, 2000, '2023-01-15'),
#                                                      (3, 2100, '2023-02-15'),
#
#                                                      (4, 3500, '2023-01-20'),
#                                                      (4, 3600, '2023-02-20'),
#                                                      (5, 3400, '2023-01-25'),
#                                                      (5, 3450, '2023-03-25');

# Задача:
# Посчитайте среднюю зарплату по каждому отделу за 2023 год.
# Отсортируйте отделы по убыванию средней зарплаты.
# Выведите топ-2 отдела с самой высокой средней зарплатой.

SELECT AVG(amount), d.name FROM salaries s
JOIN employees e ON e.id = s.employee_id
JOIN departments d ON d.id = e.department_id
WHERE YEAR(s.date) = 2023
GROUP BY d.name
ORDER BY AVG(amount) DESC LIMIT 2;




