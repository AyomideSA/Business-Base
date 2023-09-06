package com.ayomidesolaayodele.app.businessbase.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Entity
@Table(name="yelp_authorization")
public class YelpAuthorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String client_id;
    @Column
    private String api_key;

    public YelpAuthorization(String client_id, String api_key) {
        this.client_id = client_id;
        this.api_key = api_key;
    }

    public YelpAuthorization() {

    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }
}


