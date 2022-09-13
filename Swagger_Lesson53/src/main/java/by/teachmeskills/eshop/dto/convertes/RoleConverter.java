package by.teachmeskills.eshop.dto.convertes;

import by.teachmeskills.eshop.dto.RoleDto;
import by.teachmeskills.eshop.entities.Role;
import by.teachmeskills.eshop.repositories.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleConverter {
    private final RoleRepository roleRepository;

    public RoleConverter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleDto toDto(Role role) {
        return Optional.ofNullable(role).map(r -> RoleDto.builder()
                        .name(r.getName())
                        .build()).
                orElse(null);
    }

    public Role fromDto(String roleDtoName) {
        Role opRole = roleRepository.getRoleByName(roleDtoName);
        return opRole;
    }
}