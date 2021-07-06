package com.db.client;

import com.db.client.domain.Account;
import com.db.client.service.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Application {
    private static final Map<Integer, Account> accounts = new HashMap<>();

    public static void main(String... args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        OperationService operationService = context.getBean(OperationService.class);
        operationService.createClient(1, "Ilya Titov");
        operationService.createAccountForClient(1, new Account(1, BigDecimal.valueOf(1111111.1111), true));
        operationService.createAccountForClient(1, new Account(3, BigDecimal.valueOf(222222.222), false));
        operationService.createAccountForClient(1, new Account(2, BigDecimal.valueOf(33333.3333), false));
        operationService.findAllAccount(1);
        operationService.findAccountState(1, 3);
        operationService.findAccountState(2, 3);
        operationService.findAccountState(1, 4);
    }
}
