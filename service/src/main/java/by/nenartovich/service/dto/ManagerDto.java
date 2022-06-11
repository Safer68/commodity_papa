package by.nenartovich.service.dto;

import by.nenartovich.repository.entity.Manager;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class ManagerDto {
    private final Integer id;
    private String name;

    public ManagerDto(Manager manager) {
        this.id = manager.getId();
        this.name = manager.getName();
    }
}
