package homecare.mega.dto.response;

import java.util.List;

import homecare.mega.model.Bookings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    List<Bookings> bookings;

}