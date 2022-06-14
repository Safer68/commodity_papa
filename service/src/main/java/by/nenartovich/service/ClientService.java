package by.nenartovich.service;

import by.nenartovich.service.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto findById(Integer clientId);

    List<ClientDto> findAllClientDto();

    void updateClient(ClientDto clientDto);
}
