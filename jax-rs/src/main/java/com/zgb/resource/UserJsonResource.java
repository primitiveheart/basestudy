package com.zgb.resource;

import com.zgb.domain.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/6/3.
 */
@Path("/userJson")
public class UserJsonResource {
    private static Map<Integer, User> userMap = new HashMap<>();

    @GET
    @Path("allUsersJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUSers(){
        List<User> users = new ArrayList<User>();
        User u1 = new User(1, "Michael", "26");
        User u2 = new User(2, "King", "23");
        User u3 = new User(3, "Susan", "21");

        userMap.put(u1.getId(), u1);
        userMap.put(u2.getId(), u2);
        userMap.put(u3.getId(), u3);

        users.addAll(userMap.values());
        return users;
    }
}
