package homecare.mega.dto.response;

import java.util.List;

import homecare.mega.model.Services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicesResponse {

    List<Services> services;

}