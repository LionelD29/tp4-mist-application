package be.technifutur.user.business.mapper;

import be.technifutur.shared.model.dto.BillingAddressDTO;
import be.technifutur.user.model.entity.BillingAddress;
import org.springframework.stereotype.Service;

@Service
public class BillingAddressMapper {

    public BillingAddressDTO entityToDTO(BillingAddress entity) {
        if (entity == null)
            return null;
        return BillingAddressDTO.builder()
                .address(entity.getAddress())
                .build();
    }

}
