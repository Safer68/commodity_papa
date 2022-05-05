package by.nenartovich.service;

import by.nenartovich.repository.Section;
import by.nenartovich.repository.dao.*;
import by.nenartovich.repository.dao.impl.*;
import by.nenartovich.repository.entity.*;

import java.util.Date;
import java.util.LinkedHashSet;

public class App {

    public static final String DESCRIPTION_PRODUCT = "велосипед";
    public static final String CLIENT_NAME = "Петя";
    public static final String CLIENT_SURNAME = "Иванов";
    public static final String CLIENT_PATRONYMIC = "Иванович";
    public static final String CITY = "Минск";
    public static final String STREET = "Варвашшени";
    public static final int POSTAL_CODE = 220102;
    public static final String PHONE_NUMBER = "+375257056517";
    public static final String DELIVERY_NAME = "Европочта";
    public static final String MANAGER_NAME = "Николай";
    public static final double PRICE = 1000.0;

    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImp();
        ClientDao clientDao = new ClientDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();

        Product product = Product.builder()
                .section(Section.SPORT)
                .description(DESCRIPTION_PRODUCT)
                .price(PRICE).build();
        productDao.save(product);

        Client client = Client.builder()
                .name(CLIENT_NAME)
                .surname(CLIENT_SURNAME)
                .patronymic(CLIENT_PATRONYMIC)
                .address(new Address(CITY, STREET, POSTAL_CODE))
                .phoneNumber(PHONE_NUMBER).build();
        clientDao.save(client);

        Delivery delivery = Delivery.builder()
                .name(DELIVERY_NAME).build();

        Manager manager = Manager.builder()
                .name(MANAGER_NAME).build();

        Order order = Order.builder()
                .date(new Date())
                .client(client)
                .manager(manager)
                .delivery(delivery)
                .products(new LinkedHashSet<>()).build();
        order.getProducts().add(product);
        orderDao.save(order);

    }
}
