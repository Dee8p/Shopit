package shopit.shop.security.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    @NonNull
    private String email;
    @NonNull
    private String encryptedPassword;
    private Boolean enabled;
    private Integer role;

    public User(String email, String encryptedPassword) {
    }
}
