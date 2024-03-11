package homecare.mega.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    @Builder.Default
    private String message = "Something went wrong... ";
    @Builder.Default
    private String accessToken = "";
}
