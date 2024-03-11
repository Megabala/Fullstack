import React, { useState } from 'react';
import './../../assets/css/AdminBooking.css'; // Assuming you have a separate CSS file for styling
import {useEffect} from 'react';
import {viewBookings} from './../../services/admin'
const AdminBooking = () => {
  const [bookingData, setBookingData] = useState([]);
  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response = await viewBookings();
        
        setBookingData(response.data.bookings|| []);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };

    fetchUserData();
  }, []);
  return (
    <div className="booking-table-container">
      <table className="booking-table">
        <thead>
          <tr>
            <th>Booking ID</th>
            <th>Patient Name</th>
            <th>Date of Birth</th>
            <th>Gender</th>
            <th>Address</th>
            <th>Mobile Number</th>
            <th>Emergency Contact</th>
            <th>Medical Condition</th>
            <th>Service Name</th>
            <th>Frequency</th>
            <th>Timing</th>
            <th>Language</th>
            <th>Booking Status</th>
          </tr>
        </thead>
        <tbody>
          {bookingData.map((booking, index) => (
            <tr key={index}>
              <td>{booking.booking_id}</td>
              <td>{booking.patientname}</td>
              <td>{booking.dateofbirth}</td>
              <td>{booking.gender}</td>
              <td>{booking.address}</td>
              <td>{booking.mobilenumber}</td>
              <td>{booking.emergencycontact}</td>
              <td>{booking.medicalcondition}</td>
              <td>{booking.servicename}</td>
              <td>{booking.frequency}</td>
              <td>{booking.timing}</td>
              <td>{booking.language}</td>
              <td>{booking.bookingstatus}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AdminBooking;
