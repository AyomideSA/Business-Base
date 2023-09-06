package com.ayomidesolaayodele.app.businessbase.repositories;

import com.ayomidesolaayodele.app.businessbase.models.YelpAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("yelp_authorization_repo")
public interface YelpAuthorizationRepository extends JpaRepository<YelpAuthorization, String> {

}
