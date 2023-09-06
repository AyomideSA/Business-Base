package com.ayomidesolaayodele.app.businessbase.startup;

import com.ayomidesolaayodele.app.businessbase.models.YelpAuthorization;
import com.ayomidesolaayodele.app.businessbase.repositories.YelpAuthorizationRepository;
import com.ayomidesolaayodele.app.businessbase.services.AuthorizationRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class DataLoader implements ApplicationRunner {

    YelpAuthorizationRepository yelpAuthorizationRepository;

    @Autowired
    public DataLoader(YelpAuthorizationRepository yelpAuthorizationRepository) {
        this.yelpAuthorizationRepository = yelpAuthorizationRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] yelp_credentials = new String[2];
        Scanner scanner = new Scanner(new File("C:\\Users\\ayoso\\IdeaProjects\\credentials.txt"));
        int i = 0;
        while (scanner.hasNextLine()) {
            yelp_credentials[i++] = scanner.nextLine();
        }
        scanner.close();
        yelpAuthorizationRepository.save(new YelpAuthorization(yelp_credentials[0], yelp_credentials[1]));

    }

//    @Override
//    public void run(String...args) throws Exception {
//        String[] yelp_credentials = new String[2];
//        try {
//            Scanner scanner = new Scanner(new File("C:\\Users\\ayoso\\IdeaProjects\\credentials.txt"));
//            int i = 0;
//            while (scanner.hasNextLine()) {
//                yelp_credentials[i++] = '\'' + scanner.nextLine() + '\'';
//            }
//            System.out.println(Arrays.toString(yelp_credentials));
//            Connection conn = DriverManager.getConnection("jdbc:h2:mem:tempdb");
//            Statement stmt = conn.createStatement();
//         //   stmt.executeUpdate("CREATE TABLE YelAuthorization(id int, client_id varchar(255), api_key varchar(255));");
//            stmt.executeUpdate("INSERT INTO YelpAuthorization(id, client_id, api_key) VALUES(0, "+yelp_credentials[0]+", "+yelp_credentials[1]+");");
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
