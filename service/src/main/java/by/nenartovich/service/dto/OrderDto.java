package by.nenartovich.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class OrderDto {
    private Integer id;
    private String dataCreate;
    private String dataChange;
    private ClientDto client;
    private String status;
    private List<ProductDto> products;
    private Double price;
    private DeliveryDto delivery;

}
