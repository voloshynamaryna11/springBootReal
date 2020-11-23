package startspringboot.demo.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import startspringboot.demo.dto.DataDto;
import startspringboot.demo.model.Role;
import startspringboot.demo.model.User;
import java.util.Set;

public class UserMapperTest {
    private DataDto dataDtoOk = new DataDto();
    private UserMapper userMapper = new UserMapper();

    @Before
    public void init() {
        dataDtoOk.setUserId("6");
        dataDtoOk.setProfileName("Lana");
    }

    @Test
    public void map_ok() {
        User user = new User();
        user.setUserId("6");
        user.setProfileName("Lana");
        user.setRoles(Set.of(Role.of("USER")));
        user.setPassword("1111");
        Assert.assertEquals(user, userMapper.mapToUser(dataDtoOk));
    }

    @Test
    public void map_empty() {
        User user = new User();
        user.setRoles(Set.of(Role.of("USER")));
        user.setPassword("1111");
        Assert.assertEquals(user, userMapper.mapToUser(new DataDto()));
    }
}
