package com.code.prodapp.productionreadyfeatures.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        // get security context
        // get authentication
        // get principal user
        // get its username
        return Optional.of("Aamir Hussain");
    }
}
