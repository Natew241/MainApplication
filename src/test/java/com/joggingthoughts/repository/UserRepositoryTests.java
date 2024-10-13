package com.joggingthoughts.repository;


import com.joggingthoughts.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUserAutoGeneratesId(){
        UserEntity user = new UserEntity();
    }
}
