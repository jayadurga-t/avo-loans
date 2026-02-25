package com.avo.loans.serviceImpl;

import com.avo.loans.client.AccountsFeignClient;
import com.avo.loans.client.CardsFeignClient;
import com.avo.loans.dto.CardsDto;
import com.avo.loans.dto.CustomerDetailsDto;
import com.avo.loans.dto.CustomerDto;
import com.avo.loans.dto.LoansDto;
import com.avo.loans.entity.Loans;
import com.avo.loans.exception.ResourceNotFoundException;
import com.avo.loans.mapper.CustomerMapper;
import com.avo.loans.mapper.LoansMapper;
import com.avo.loans.repository.LoansRepository;
import com.avo.loans.service.ICustomerService;
import com.avo.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsFeignClient accountsFeignClient;
    private CardsFeignClient cardsFeignClient;
    private LoansRepository loansRepository;

    private ILoansService iLoansService;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String correlationId, String mobileNumber) {

//        ResponseEntity<CustomerDto> customerDtoResponseEntity =
//                accountsFeignClient.fetchAccountDetails(mobileNumber);
//        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(
//                customerDtoResponseEntity.getBody(), new CustomerDetailsDto());
//
//        ResponseEntity<CardsDto> cardsDtoReponseEntity = cardsFeignClient.fetchCard(mobileNumber);
//        customerDetailsDto.setCardsDto(cardsDtoReponseEntity.getBody());
//
//        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
//                new Supplier<ResourceNotFoundException>() {
//                    @Override
//                    public ResourceNotFoundException get() {
//                        return new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber);
//                    }
//                }
//        );
//        LoansDto loansDto = LoansMapper.mapToLoansDto(loans, new LoansDto());
//        customerDetailsDto.setLoansDto(loansDto);

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(
                accountsFeignClient.fetchAccountDetails(correlationId,mobileNumber).getBody(), new CustomerDetailsDto());
        customerDetailsDto.setCardsDto(cardsFeignClient.fetchCard(correlationId, mobileNumber).getBody());
        customerDetailsDto.setLoansDto(iLoansService.fetchLoan(mobileNumber));

        return customerDetailsDto;
    }
}
