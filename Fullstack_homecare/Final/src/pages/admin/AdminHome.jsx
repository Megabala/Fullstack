import React, { useEffect, useState } from 'react';
import { FaUsers, FaClipboardList, FaMoneyBillAlt } from 'react-icons/fa';
import './../../assets/css/AdminHome.css';
import { viewBookings,editBooking } from './../../services/admin';

const AdminHome = () => {
  const [bookingData, setBookingData] = useState([]);
  const [selectedBooking, setSelectedBooking] = useState(null);

  useEffect(() => {
    const fetchBookingData = async () => {
      try {
        const response = await viewBookings();
        setBookingData(response.data.bookings || []);
      } catch (error) {
        console.error('Error fetching booking data:', error);
      }
    };

    fetchBookingData();
  }, []);

  const handleAccept = async(booking) => {
    setSelectedBooking({ ...booking, bookingstatus: 'Approved' });
    try{
      await editBooking(booking.booking_id,selectedBooking);
}
catch(error){
  console.error('Error editing service:', error);
}
  };
  
  const handleReject = async(booking) => {
    setSelectedBooking({ ...booking, bookingstatus: 'Rejected' });
    try{
      await editBooking(booking.booking_id,selectedBooking);
}
catch(error){
  console.error('Error editing service:', error);
}
    
    // Perform reject logic here
  };

  return (
    <div className="dash">
      <div className="top-stat">
        <div className="stat">
          <FaUsers size={50} />
          <div>
            <p>Total Users</p>
            <p>2000</p>
          </div>
        </div>

        <div className="stat2">
          <FaClipboardList size={50} />
          <div>
            <p>Total Bookings</p>
            <p>4000</p>
          </div>
        </div>

        <div className="stat3">
          <FaMoneyBillAlt size={50} />
          <div>
            <p>Total Revenue</p>
            <p>Rs.200000</p>
          </div>
        </div>
      </div>

      <div className="mid-dash">
        <div className="left-dash">
          <p className="section-title">Recent Bookings</p>
          <div className="recent-bookings-table-container">
            <table className="recent-bookings-table">
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
                  <th>Approval</th>
                  <th>Rejection</th>
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
                    <td>
                      <button className="approval-button" onClick={() => handleAccept(booking)}>Accept</button>
                    </td>
                    <td>
                      <button className="rejection-button" onClick={() => handleReject(booking)}>Reject</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>

      {/* Display selected booking details */}
      {selectedBooking && (
        <div className="selected-booking-details">
          <h2>Selected Booking Details</h2>
          <p>Booking ID: {selectedBooking.booking_id}</p>
          <p>Patient Name: {selectedBooking.patientname}</p>
          {/* Add more details as needed */}
          <p>Booking Status: {selectedBooking.bookingStatus}</p>
        </div>
      )}
    </div>
  );
};

export default AdminHome;
