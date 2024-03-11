package homecare.mega.service.imp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import homecare.mega.dto.request.BookingRequest;
import homecare.mega.dto.response.BookingResponse;
import homecare.mega.dto.response.RegisterResponse;

import homecare.mega.model.Bookings;

import homecare.mega.repository.BookingsRepository;
import homecare.mega.service.BookingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class BookingServiceImpl implements BookingService {

    private final BookingsRepository bookingsRepo;
    
    @Override
    public RegisterResponse addBookings(BookingRequest request) {
        var bookings = Bookings.builder()
                        .email(request.getEmail())
                        .patientname(request.getPatientname())
                        .dateofbirth(request.getDateofbirth())
                        .gender(request.getGender())
                        .address(request.getAddress())
                        .mobilenumber(request.getMobilenumber())
                        .emergencycontact(request.getEmergencycontact())
                        .medicalcondition(request.getMedicalcondition())
                        .servicename(request.getServicename())
                        .frequency(request.getFrequency())
                        .timing(request.getTiming())
                        .language(request.getLanguage())
                        .bookingstatus(request.getBookingstatus())
                        .build();

        bookingsRepo.save(bookings);
                        

        return RegisterResponse.builder()
                                .message("Bookings added successfully")
                                .build();
    }

    @Override
    public BookingResponse getAllBookings() {
        
        List<Bookings> bookings = bookingsRepo.findAll();
        return BookingResponse.builder().bookings(bookings).build();
    }

    @Override
    public RegisterResponse updateBookings(String id, BookingRequest request) {
         Optional<Bookings> userOptional = bookingsRepo.findById(id);
        if (userOptional.isPresent()) {

            Bookings bookings = userOptional.get();
            bookings.setEmail(request.getEmail());
            bookings.setPatientname(request.getPatientname());
            bookings.setDateofbirth(request.getDateofbirth());
            bookings.setGender(request.getGender());
            bookings.setAddress(request.getAddress());
            bookings.setMobilenumber(request.getMobilenumber());
            bookings.setEmergencycontact(request.getMobilenumber());
            bookings.setMedicalcondition(request.getMedicalcondition());
            bookings.setServicename(request.getServicename());
            bookings.setFrequency(request.getFrequency());
            bookings.setTiming(request.getTiming());
            bookings.setLanguage(request.getLanguage());
            bookings.setBookingstatus(request.getBookingstatus());            
            bookingsRepo.save(bookings);

            return RegisterResponse.builder().message("Bookings updated successfully").build();
        } 
        else {
            return RegisterResponse.builder().message("Booking not found").build();
        }
    }

    @Override
    public RegisterResponse deleteBookings(String id) {
        Optional<Bookings> userOptional = bookingsRepo.findById(id);

        if(!userOptional.isPresent())
        {
            return RegisterResponse.builder().message("Bookings not found").build();
        }
        bookingsRepo.deleteById(id);
        return RegisterResponse.builder().message("Bookings deleted").build();
       
    }
    
    @Override
    public BookingResponse getBooking(String email) {
        List<Bookings> Bookings = bookingsRepo.findByEmail(email);
        return BookingResponse.builder().bookings(Bookings).build();

   
}}