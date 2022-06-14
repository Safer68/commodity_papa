package by.nenartovich.service.converter.impl;

import by.nenartovich.repository.entity.Client;
import by.nenartovich.service.converter.ConverterDTO;
import by.nenartovich.service.dto.ClientDto;

public class ClientConverter implements ConverterDTO<ClientDto, Client> {
    @Override
    public ClientDto apply(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setSurname(client.getSurname());
        return clientDto;
    }

    @Override
    public Client apply(Client client, ClientDto clientDto) {
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setPatronymic(clientDto.getPatronymic());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        return client;
    }
}
