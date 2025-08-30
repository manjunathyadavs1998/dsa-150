package com.dsa.top.dsa_problems.java.threads;

import java.io.*;

class User implements Serializable {
    String username;
    transient String password;  // will not be saved in serialization

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class TransientDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("manju", "secret123");

        // Serialize object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"));
        oos.writeObject(user);
        oos.close();

        // Deserialize object
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"));
        User deserializedUser = (User) ois.readObject();
        ois.close();

        System.out.println("Username: " + deserializedUser.username); // manju
        System.out.println("Password: " + deserializedUser.password); // null (not saved)
    }
}
