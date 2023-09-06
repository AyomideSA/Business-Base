package com.ayomidesolaayodele.app.businessbase.services;

import com.ayomidesolaayodele.app.businessbase.models.YelpAuthorization;
import com.ayomidesolaayodele.app.businessbase.repositories.YelpAuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationRepositoryService {

    @Autowired
    public YelpAuthorizationRepository yelpAuthorizationRepository;

    public void save(YelpAuthorization yelpAuthorization) {
        yelpAuthorizationRepository.save(yelpAuthorization);
    }

}
