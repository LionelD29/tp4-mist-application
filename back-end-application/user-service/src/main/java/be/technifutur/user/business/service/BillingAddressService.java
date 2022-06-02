package be.technifutur.user.business.service;

import be.technifutur.user.repository.BillingAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BillingAddressService {

    private final BillingAddressRepository billingAddressRepository;

}
