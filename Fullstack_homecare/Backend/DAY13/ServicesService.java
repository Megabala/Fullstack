package homecare.mega.service;

import homecare.mega.dto.request.ServicesRequest;
import homecare.mega.dto.response.RegisterResponse;
import homecare.mega.dto.response.ServicesResponse;

public interface ServicesService {

    RegisterResponse addService(ServicesRequest request);

    ServicesResponse getAllServices();

    RegisterResponse updateService(String id, String service_name, String description, String duration, Float amount,
            boolean availability);

    RegisterResponse deleteService(String id);

}