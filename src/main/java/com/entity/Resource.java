package com.entity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.util.CORSResponseFilter;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;


@Path("/user")
public class Resource {
    public Map<Integer, User> map = new HashMap<Integer, User>();
    List<User> list = new ArrayList<User>();//成员变量
    JSONArray json;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JSONArray getAllUser() throws JsonProcessingException {
        User user;//局部变量
        for (int i = 1; i < 10; i++) {
            user = new User();
            user.setUid(i);
            user.setName(getRandomName(5));
            //user="select * from user"
            list.add(user);
        }
        //把对象中设置的值
        json = JSONArray.fromObject(list);
        return json;
    }

    /*
     * 根据用户名查询用户信息
     * http://localhost:6060/api/user/get?username=xiaolian
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserName(@QueryParam("id") int id) {
        User user = new User();
        //name="select name from user where uid="+id
        user.setUid(id);
        user.setName(getRandomName(5));
        return user;
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})
    public String modifyUser(@RequestBody String json) {
        return json;
    }


    private String getRandomName(int length) {
        StringBuffer sb = new StringBuffer();
        String allchar = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < allchar.length(); i++) {
            for (int j = 0; j < length; j++) {
                char name = (char) (Math.random() * 26 + 65);
                sb.append(name);
            }
            break;
        }
        return sb.toString();
    }

}
