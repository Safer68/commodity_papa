package by.nenartovich.service;

import by.nenartovich.service.dto.ManagerDto;
import by.nenartovich.service.dto.OrderDto;

import java.util.List;

public interface ManagerService {

    ManagerDto findById(Integer ManagerId);

    List<ManagerDto> findAllManagerDto();

    void updateManager(Integer managerId, String newName);

    void createManager(Integer managerId, String name);

    List<OrderDto> getManagerOrders(Integer managerId);
}
