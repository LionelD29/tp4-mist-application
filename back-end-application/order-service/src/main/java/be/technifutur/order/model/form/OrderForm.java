package be.technifutur.order.model.form;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
public class OrderForm {

//    @NotBlank(message = "Buyer name must not be blank")
//    @Size(max = 50, message = "Buyer name must be 50 characters at maximum")
//    private String buyerName;

    @NotBlank(message = "Billing address must not be blank")
    @Size(max = 50, message = "Billing address must be 100 characters at maximum")
    private String billingAddress;

    private List<GameForm> games;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter @Setter
    public static class GameForm {
        private UUID gameReference;
        private int howMany;
    }

}
