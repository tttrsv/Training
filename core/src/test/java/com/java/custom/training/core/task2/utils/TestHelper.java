package com.java.custom.training.core.task2.utils;

import com.java.custom.training.core.task2.domain.dto.*;
import lombok.experimental.UtilityClass;
import org.junit.runners.Parameterized.Parameters;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class TestHelper {

    private Service createService(String serviceName, ServiceType serviceType) {
        Service service = new Service();
        service.setName(serviceName);
        service.setServiceType(serviceType);
        return service;
    }

    private Account createAccount(String accountName, String registrationTime, String expireTime, List<Service> services) {
        LocalDate registrationDate = LocalDate.parse(registrationTime);
        LocalDate expireDate = LocalDate.parse(expireTime);

        Account account = new Account();
        account.setName(accountName);
        account.setRegistrationTime(registrationDate);
        account.setExpireTime(expireDate);
        account.setServices(services);
        return account;
    }

    private User createUser(String userName, int id, int age, List<Account> account) {
        User user = new User();
        user.setName(userName);
        user.setId(id);
        user.setAge(age);
        user.setAccounts(account);
        return user;
    }

    public Users createUsers() {
        Users users = new Users();
        users.setUsers(Arrays.asList(
                createUser("John", 123, 12, Arrays.asList(
                        createAccount("Apple ID", "2015-10-10", "2025-10-10", Arrays.asList(
                                createService("Apple Music", ServiceType.COMMON),
                                createService("iCloud", ServiceType.PREMIUM))))),
                createUser("Steve", 124, 15, Arrays.asList(
                        createAccount("Google", "2013-10-10", "2023-10-10", Arrays.asList(
                                createService("Google Drive", ServiceType.TRIAL),
                                createService("Google Docs", ServiceType.PREMIUM))))),
                createUser("Patrick", 125, 25, Arrays.asList(
                        createAccount("Google", "2011-10-10", "2021-10-10", Arrays.asList(
                                createService("Gmail", ServiceType.TRIAL),
                                createService("Google Sheets", ServiceType.COMMON)))))));
        return users;
    }


}
