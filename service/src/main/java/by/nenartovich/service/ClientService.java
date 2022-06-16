package by.nenartovich.service;

import by.nenartovich.service.dto.ClientDto;
import by.nenartovich.service.dto.OrderDto;

import java.util.List;

public interface ClientService {
    ClientDto findById(Integer clientId);

    List<ClientDto> findAllClientDto();

    void updateClient(ClientDto clientDto);

    List<OrderDto> getClientOrders(Integer clientId);
}
