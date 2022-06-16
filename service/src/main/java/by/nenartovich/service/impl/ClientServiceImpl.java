package by.nenartovich.service.impl;

import by.nenartovich.repository.dao.ClientDao;
import by.nenartovich.repository.dao.impl.ClientDaoImpl;
import by.nenartovich.repository.dao.impl.ManagerDaoImp;
import by.nenartovich.repository.entity.Client;
import by.nenartovich.service.ClientService;
import by.nenartovich.service.converter.impl.ClientConverter;
import by.nenartovich.service.converter.impl.OrderConverter;
import by.nenartovich.service.dto.ClientDto;
import by.nenartovich.service.dto.OrderDto;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    @Override
    public ClientDto findById(Integer clientId) {
        return new ClientConverter().convert(new ClientDaoImpl().findById(clientId));
    }

    @Override
    public List<ClientDto> findAllClientDto() {
        return new ClientConverter().convert(new ClientDaoImpl().findAll());
    }

    @Override
    public void updateClient(ClientDto clientDto) {
        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.findById(clientDto.getId());
        client = new ClientConverter().convert(client, clientDto);
        clientDao.update(client);
    }

    @Override
    public List<OrderDto> getClientOrders(Integer clientId) {
        return new OrderConverter().convert(new ClientDaoImpl().getClientOrder(clientId));
    }
}
