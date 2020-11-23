package startspringboot.demo.mapper;

import org.springframework.stereotype.Component;
import startspringboot.demo.dto.DataDto;
import startspringboot.demo.model.Role;
import startspringboot.demo.model.User;
import java.util.Set;

@Component
public class UserMapper {
    private static final String DEFAULT_PASSWORD = "1111";

    public User mapToUser(DataDto dataDto) {
        User user = new User();
        user.setUserId(dataDto.getUserId());
        user.setProfileName(dataDto.getProfileName());
        user.setPassword(DEFAULT_PASSWORD);
        user.setRoles(Set.of(Role.of("USER")));
        return user;
    }
}
