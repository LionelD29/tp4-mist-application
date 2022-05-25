package be.technifutur.order.model.form;

import be.technifutur.order.model.entity.Game;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
public class OrderForm {

    @NotBlank(message = "Buyer name must not be blank")
    @Size(max = 50, message = "Buyer name must be 50 characters at maximum")
    private String buyer_name;

    @NotBlank(message = "Shipping address must not be blank")
    @Size(max = 50, message = "Shipping address must be 100 characters at maximum")
    private String shipping_address;

    private List<Game> gamesToOrder;

}
