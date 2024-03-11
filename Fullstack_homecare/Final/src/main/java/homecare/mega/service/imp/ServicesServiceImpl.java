package homecare.mega.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import homecare.mega.dto.request.ServicesRequest;
import homecare.mega.dto.response.RegisterResponse;
import homecare.mega.dto.response.ServicesResponse;
import homecare.mega.model.Services;
import homecare.mega.repository.ServiceRepository;
import homecare.mega.service.ServicesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class ServicesServiceImpl implements ServicesService {

    private final ServiceRepository serviceRepository;

    @Override
    public RegisterResponse addService(ServicesRequest request) {

        var service = Services.builder()
                        .service_name(request.getService_name())
                        .description(request.getDescription())
                        .availability(request.isAvailability())
                        .amount(request.getAmount())
                        .duration(request.getDuration())
                        .build();

        serviceRepository.save(service);
                        

        return RegisterResponse.builder()
                                .message("Service added successfully")
                                .build();
    }

    @Override
    public ServicesResponse getAllServices() {
        List<Services> service = serviceRepository.findAll();
        return ServicesResponse.builder().services(service).build();
    }

    @Override
    public RegisterResponse updateService(String id, String service_name, String description, String duration,
            Float amount, boolean availability) {

        Optional<Services> userOptional = serviceRepository.findById(id);
        if (userOptional.isPresent()) {

            Services service = userOptional.get();
            service.setService_name(service_name);
            service.setAmount(amount);
            service.setAvailability(availability);
            service.setDescription(description);
            service.setDuration(duration);
            
            serviceRepository.save(service);

            return RegisterResponse.builder().message("Service updated successfully").build();
        } 
        else {
            return RegisterResponse.builder().message("Service not found").build();
        }
        
    }

    @Override
    public RegisterResponse deleteService(String id) {
        
        
        Optional<Services> userOptional = serviceRepository.findById(id);

        if(!userOptional.isPresent())
        {
            return RegisterResponse.builder().message("Service not found").build();
        }
        serviceRepository.deleteById(id);
        return RegisterResponse.builder().message("Service deleted").build();
    }

}