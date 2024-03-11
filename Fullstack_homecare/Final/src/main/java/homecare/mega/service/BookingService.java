package homecare.mega.service;

import homecare.mega.dto.request.BookingRequest;
import homecare.mega.dto.response.BookingResponse;
import homecare.mega.dto.response.RegisterResponse;


public interface BookingService {

    RegisterResponse addBookings(BookingRequest request);

    BookingResponse getAllBookings();

    RegisterResponse updateBookings(String id, BookingRequest request);

    RegisterResponse deleteBookings(String id);

    BookingResponse getBooking(String email);
}