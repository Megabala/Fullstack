package homecare.mega.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import homecare.mega.dto.request.BookingRequest;
import homecare.mega.dto.response.BookingResponse;
import homecare.mega.dto.response.RegisterResponse;
import homecare.mega.dto.response.UserDetailResponse;
import homecare.mega.service.BookingService;
import homecare.mega.utils.MyConstant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MyConstant.BOOKINGS)
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

     @PostMapping(MyConstant.BOOKINGS_ADD)
    public ResponseEntity<?> addBookings(@RequestBody BookingRequest request) {
        RegisterResponse response = new RegisterResponse();
            System.out.println(request);
        try {
            response = bookingService.addBookings(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(MyConstant.BOOKINGS_GET_ALL)
    public ResponseEntity<?> getAllBookings()
    {
        BookingResponse bookingResponse = new BookingResponse();
        try{
                bookingResponse =  bookingService.getAllBookings();
                return new ResponseEntity<>(bookingResponse,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(bookingResponse,HttpStatus.EXPECTATION_FAILED);
        }
    }

    
    @PutMapping(MyConstant.BOOKINGS_UPDATE)
    public ResponseEntity<?> updateBookings(@RequestParam String id , @RequestBody BookingRequest request)
    {
        RegisterResponse response = new RegisterResponse();
        try{
            response = bookingService.updateBookings(id,request);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(MyConstant.BOOKINGS_DELETE)
    public ResponseEntity<?> deleteBookings(@RequestParam String id)
    {
        RegisterResponse response = new RegisterResponse();

        try
        {
            response = bookingService.deleteBookings(id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
        }

    }
     
    @GetMapping(MyConstant.BOOKINGS_GET)
    public ResponseEntity<?> getBooking(@RequestParam String email)
    {
       BookingResponse response = new BookingResponse();
        try
        {
            response = bookingService.getBooking(email);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    } 
}