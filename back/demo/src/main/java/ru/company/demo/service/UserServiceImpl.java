package ru.company.demo.service;

import org.springframework.stereotype.Service;
import ru.company.demo.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    private static final Map<Integer,User> USER_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();


    @Override
    public void create(User user) {
        final int userId = USER_ID_HOLDER.incrementAndGet();
        user.setId(userId);
        USER_REPOSITORY_MAP.put(userId, user);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(USER_REPOSITORY_MAP.values());
    }

    @Override
    public User read(Integer id) {
        return USER_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(User user, Integer id) {

        if(USER_REPOSITORY_MAP.containsKey(id)){
            user.setId(id);
            USER_REPOSITORY_MAP.put(id, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return USER_REPOSITORY_MAP.remove(id)!=null;
    }
}
