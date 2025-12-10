Практическое задание: “Covid REST API + JPA”
Описание

Нужно разработать простой REST-сервис на Spring Boot для работы с сущностью CovidCase, который позволит хранить статистику по заражениям COVID-19 в разных регионах.
Данные должны храниться в базе (H2/PostgreSQL — на выбор) с использованием Spring Data JPA.

1. Сущность

Создать класс:

@Entity
public class CovidCase {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String region;
    private Integer infected;
    private Integer recovered;
    private Integer deaths;
}

2. CRUD API

Реализовать контроллер CovidController со следующими эндпоинтами:

Метод	URL	Описание
POST	/covid	Создать новую запись
GET	/covid/{id}	Получить запись по ID
GET	/covid	Получить список всех записей
PUT	/covid/{id}	Обновить запись
DELETE	/covid/{id}	Удалить запись

Использовать:

@RestController

@RequestMapping

@PathVariable

@RequestParam

@RequestBody

JpaRepository<CovidCase, Long>

3. REST-задачи

Добавить отдельный контроллер CovidStatsController с тремя дополнительными запросами:

1. GET /covid/search?id=...

Найти запись по id (аналог базового, но по параметру, а не path-variable)

2. GET /covid/top5?by=field

Вернуть топ 5 записей по любому из полей:

infected

recovered

deaths

Сортировка — по убыванию.

Пример:
/covid/top5?by=infected

3. GET /covid/total?by=field

Вернуть сумму значений указанного поля по всем записям:

total infected

total recovered

total deaths

Пример:
/covid/total?by=deaths

4. Требования

Валидация параметров by → если поле не существует, вернуть ошибку 400.

Использовать @Service для бизнес-логики.

Код должен быть структурирован:

entity

repository

service

controller

5. Дополнительное задание (по желанию)

Добавить фильтрацию /covid/filter?minInfected=1000&region=Europe

Добавить пагинацию /covid/page?page=0&size=10

Написать unit-тесты для сервиса.