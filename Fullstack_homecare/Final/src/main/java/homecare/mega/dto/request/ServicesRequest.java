package homecare.mega.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicesRequest {

    private String service_name;
    private String description;
    private boolean availability;
    private String duration;
    private Float amount;
}