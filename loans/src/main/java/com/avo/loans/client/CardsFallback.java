package com.avo.loans.client;

import com.avo.loans.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient {

    @Override
    public ResponseEntity<CardsDto> fetchCard(String correlationId, String mobileNumber) {
        return null;
    }
}
