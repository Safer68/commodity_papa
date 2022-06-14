package by.nenartovich.service.converter.impl;

import by.nenartovich.repository.entity.Manager;
import by.nenartovich.service.converter.ConverterDTO;
import by.nenartovich.service.dto.ManagerDto;

public class ManagerConverter implements ConverterDTO<ManagerDto, Manager> {
    @Override
    public ManagerDto apply(Manager manager) {
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(manager.getId());
        managerDto.setName(manager.getName());
        return managerDto;
    }

    @Override
    public Manager apply(Manager manager, ManagerDto managerDto) {
        manager.setName(managerDto.getName());
        return manager;
    }
}
