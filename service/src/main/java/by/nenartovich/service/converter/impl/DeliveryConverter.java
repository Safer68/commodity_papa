package by.nenartovich.service.converter.impl;

import by.nenartovich.repository.entity.Delivery;
import by.nenartovich.service.converter.ConverterDTO;
import by.nenartovich.service.dto.DeliveryDto;

public class DeliveryConverter implements ConverterDTO<DeliveryDto, Delivery> {
    @Override
    public DeliveryDto apply(Delivery delivery) {
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setId(delivery.getId());
        deliveryDto.setName(delivery.getName());
        return deliveryDto;
    }

    @Override
    public Delivery apply(Delivery delivery, DeliveryDto deliveryDto) {
        delivery.setName(deliveryDto.getName());
        return delivery;
    }
}
