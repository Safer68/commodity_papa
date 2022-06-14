package by.nenartovich.service;

import by.nenartovich.service.dto.ManagerDto;
import by.nenartovich.service.dto.OrderDto;

import java.util.List;

public interface ManagerService {

    ManagerDto findById(Integer managerId);

    List<ManagerDto> findAllManagerDto();

    void updateManager(ManagerDto managerDto);

    void createManager(Integer managerId, String name);

    List<OrderDto> getManagerOrders(Integer managerId);
}
