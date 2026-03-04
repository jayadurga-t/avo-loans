package com.avo.loans.client;

import com.avo.loans.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountsFallback implements AccountsFeignClient {

    @Override
    public ResponseEntity<CustomerDto> fetchAccountDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
