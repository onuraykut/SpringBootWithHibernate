package com.kryptow.springbootrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.model.posts.Posts;
import com.kryptow.springbootrest.model.posts.PrivatePosts;
import com.kryptow.springbootrest.repository.PostDAOImpl;
import com.kryptow.springbootrest.repository.UserDAOImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private UserDAOImpl userDAOImpl;
    private PostDAOImpl postDAOImpl;
   
    public DbSeeder(UserDAOImpl userDAOImpl,PostDAOImpl postDAOImpl) {
        this.userDAOImpl = userDAOImpl;
        this.postDAOImpl = postDAOImpl;
    }
    @Override
    public void run(String... strings) throws Exception {
    	/*    User marriot = new User(
        		2,
                "12x3",
                "asdas11111",
                "onur",
                new Date(),
                0,
                0,
                1
                
        );
       User marriot2 = new User(
                "1234",
                "asdas11111",
                "onur",
                new Date(),
                22,
                23,
                1
                
        );
        User marriot3 = new User(
                "12345",
                "asdas11111",
                "onur",
                new Date(),
                22,
                23,
                1
        ); */
     //PrivatePosts privatePosts = new PrivatePosts("123a","12345","merhaba begen","asd.jpeg","asdsd",5);
        // drop all hotels
     //   this.userRepository.deleteAll();

        //add our hotels to the database
       // List<User> hotels = Arrays.asList(marriot, marriot2, marriot3);
        //List<PrivatePosts> hotels2 = Arrays.asList(privatePosts);
      //  this.userDAOImpl.save(marriot);
       // this.postDAOImpl.save(privatePosts);
    }
}
