package by.nenartovich.service.impl;

import by.nenartovich.repository.dao.ManagerDao;
import by.nenartovich.repository.dao.impl.ManagerDaoImp;
import by.nenartovich.repository.entity.Manager;
import by.nenartovich.service.ManagerService;
import by.nenartovich.service.converter.impl.ManagerConverter;
import by.nenartovich.service.converter.impl.OrderConverter;
import by.nenartovich.service.dto.ManagerDto;
import by.nenartovich.service.dto.OrderDto;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    ManagerConverter managerConverter = new ManagerConverter();

    @Override
    public ManagerDto findById(Integer managerId) {
        ManagerDao managerDaoImp = new ManagerDaoImp();
        return managerConverter.convert(managerDaoImp.findById(managerId));
    }

    @Override
    public List<ManagerDto> findAllManagerDto() {
        return managerConverter.convert(new ManagerDaoImp().findAll());
    }

    @Override
    public List<OrderDto> getManagerOrders(Integer managerId) {
        return new OrderConverter().convert(new ManagerDaoImp().getManagerOrders(managerId));
    }

    @Override
    public void updateManager(ManagerDto managerDto) {
        ManagerDao managerDao = new ManagerDaoImp();
        Manager manager = managerDao.findById(managerDto.getId());
        manager = new ManagerConverter().convert(manager, managerDto);
        managerDao.update(manager);
    }

    @Override
    public void createManager(Integer managerId, String name) {

    }
}
