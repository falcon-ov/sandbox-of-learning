🧩 Задача 1 — Простая циклическая зависимость
Ситуация
@Service
public class AService {
private final BService b;

    public AService(BService b) {
        this.b = b;
    }
}

@Service
public class BService {
private final AService a;

    public BService(AService a) {
        this.a = a;
    }
}

❓ Что произойдет?

Spring выбросит ошибку:

```java
Requested bean is currently in creation: Is there an unresolvable circular reference?
```

---
✅ Решение (вариант 1): @Lazy
@Service
public class AService {
private final BService b;

    public AService(@Lazy BService b) {
        this.b = b;
    }
}


👉 Теперь Spring создаёт A без создания B сразу, подставляя proxy.

---

🧩 Задача 2 — Через сеттер
Ситуация
@Component
public class UserManager {
private OrderManager orderManager;

    public UserManager(OrderManager orderManager) {  
        this.orderManager = orderManager;
    }
}

@Component
public class OrderManager {
private UserManager userManager;

    public OrderManager(UserManager userManager) {
        this.userManager = userManager;
    }
}

❓ Как исправить без @Lazy?

---
