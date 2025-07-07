package shopit.shop.security.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    private String name, description, images;
    private Long price;
    private int id;
    private int stock;
}
