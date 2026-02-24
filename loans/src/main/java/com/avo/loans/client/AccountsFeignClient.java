package com.avo.loans.client;

import com.avo.loans.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("accounts")
public interface AccountsFeignClient {

    @GetMapping(value = "/api/fetch", consumes = "application/json")
    public ResponseEntity<CustomerDto> fetchAccountDetails(
            @RequestHeader("avoBank-correlation-id") String correlationId, @RequestParam String mobileNumber);

}
