package by.nenartovich.service.impl;

import by.nenartovich.repository.dao.impl.ManagerDaoImp;
import by.nenartovich.service.ManagerService;
import by.nenartovich.service.dto.ManagerDto;
import by.nenartovich.service.dto.OrderDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ManagerServiceImpl implements ManagerService {

    @Override
    public ManagerDto findById(Integer managerId) {
        ManagerDaoImp managerDaoImp = new ManagerDaoImp();
        return new ManagerDto(managerDaoImp.findById(managerId));
    }

    @Override
    public List<ManagerDto> findAllManagerDto() {
        ManagerDaoImp managerDaoImp = new ManagerDaoImp();
        return Optional.ofNullable(new ManagerDaoImp().findAll())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(ManagerDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getManagerOrders(Integer managerId) {
        return Optional.ofNullable(new ManagerDaoImp().getManagerOrders(managerId))
                .orElseGet(Collections::emptyList)
                .stream()
                .map(OrderDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void updateManager(Integer managerId, String newName) {

    }

    @Override
    public void createManager(Integer managerId, String name) {

    }
}
