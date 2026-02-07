package com.avo.loans.controller;

import com.avo.loans.constants.LoansConstants;
import com.avo.loans.dto.LoansDto;
import com.avo.loans.dto.Response;
import com.avo.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoansController {

    private ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<Response> createLoan(@RequestParam String mobileNumber){
        iLoansService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoan(@RequestParam String mobileNumber){
        LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansDto);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateLoan(@RequestBody LoansDto loansDto){
        boolean isUpdated = iLoansService.updateLoan(loansDto);

        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Response(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(LoansConstants.STATUS_500, LoansConstants.MESSAGE_500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response> deleteLoan(@RequestParam String mobileNumber){
        boolean isDeleted = iLoansService.deleteLoan(mobileNumber);

        if (isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Response(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(LoansConstants.STATUS_500, LoansConstants.MESSAGE_500));
        }
    }

}
