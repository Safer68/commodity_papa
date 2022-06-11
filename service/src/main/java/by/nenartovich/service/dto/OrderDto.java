package by.nenartovich.service.dto;

import by.nenartovich.repository.dao.impl.ClientDaoImpl;
import by.nenartovich.repository.dao.impl.ManagerDaoImp;
import by.nenartovich.repository.dao.impl.OrderDaoImpl;
import by.nenartovich.repository.entity.Order;
import by.nenartovich.repository.entity.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class OrderDto {
    private final Integer id;
    private String dataCreate;
    private String dataChange;

    private ClientDto client;

    private String status;
    private List<ProductDto> products;


    public OrderDto(Order order) {
        this.id = order.getId();
        this.dataCreate = new SimpleDateFormat("dd-MM-yy HH:mm").format(order.getDateCreate());
        this.dataChange = new SimpleDateFormat("dd-MM-yy HH:mm").format(order.getDateChange());
        this.status = order.isStatus() ? "Активен" : "Выполнен";
        this.products = Optional.ofNullable(new OrderDaoImpl().getProductList(id))
                .orElseGet(Collections::emptyList)
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
        this.client = new ClientDto(new ClientDaoImpl().findById(order.getClient().getId()));
    }

    public static void main(String[] args) {
        new OrderDto(new OrderDaoImpl().findById(1)).products.get(1).getPrice();
    }
}
