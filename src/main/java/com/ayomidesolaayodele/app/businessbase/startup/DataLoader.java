package com.ayomidesolaayodele.app.businessbase.startup;

import com.ayomidesolaayodele.app.businessbase.models.YelpAuthorization;
import com.ayomidesolaayodele.app.businessbase.repositories.YelpAuthorizationRepository;
import com.ayomidesolaayodele.app.businessbase.services.AuthorizationRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
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

}
