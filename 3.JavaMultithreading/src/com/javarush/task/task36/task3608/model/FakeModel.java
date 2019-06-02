package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public void loadUsers() {
        List<User> fakeUsers = new ArrayList<>();
        fakeUsers.add(new User("User1", 1, 1));
        fakeUsers.add(new User("User2", 2, 2));
        fakeUsers.add(new User("User3", 3, 5));

        modelData.setUsers(fakeUsers);
    }

    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    private List<User> getAllUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }
}
