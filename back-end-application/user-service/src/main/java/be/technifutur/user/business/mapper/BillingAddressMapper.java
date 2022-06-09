package be.technifutur.user.business.mapper;

import be.technifutur.shared.model.dto.BillingAddressDTO;
import be.technifutur.user.model.entity.BillingAddress;
import be.technifutur.user.model.entity.User;
import be.technifutur.user.model.form.BillingAddressForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BillingAddressMapper {

    public BillingAddressDTO entityToDTO(BillingAddress entity) {
        if (entity == null)
            return null;
        return BillingAddressDTO.builder()
                .address(entity.getAddress())
                .build();
    }

    public BillingAddress formToEntity(User user, BillingAddressForm form) {
        if (form == null)
            return null;
        return BillingAddress.builder()
                .address(form.getAddress())
                .users(new ArrayList<>())
                .build();
    }

}
