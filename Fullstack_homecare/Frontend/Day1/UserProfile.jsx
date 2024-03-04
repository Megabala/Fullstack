import React, { useState } from 'react';
import './UserProfile.css'; // Import your CSS file for styling
import sky from './assets/sky.jpeg'; // Import your background image file

const UserProfile = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    middleName: '',
    gender: '',
    address: '',
    mobileNum: '',
    dateOfBirth: ''
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSave = () => {
    // Here you can send the formData to your backend API
    console.log(formData);
    // Reset form data after saving if needed
    setFormData({
      firstName: '',
      lastName: '',
      middleName: '',
      gender: '',
      address: '',
      mobileNum: '',
      dateOfBirth: ''
    });
  };

  return (
    <div className="user-profile">
      <img src={sky} alt="Avatar" width="100%" height="200px" />
      <div className="card-container">
        <div className="card left-card">
      

        <h2>User Details</h2>
          <p><strong>First Name:</strong> John</p>
          <p><strong>Last Name:</strong> Doe</p>
          <p><strong>Middle Name:</strong> Smith</p>
          <p><strong>Gender:</strong> Male</p>
          <p><strong>Address:</strong> 123 Main St, City, Country</p>
          <p><strong>Mobile Number:</strong> 123-456-7890</p>
          <p><strong>Date of Birth:</strong> January 1, 1990</p>
        </div>
        <div className="card right-card">
          <h2>Edit Profile</h2>
          <form>
            <div className="form-group">
              <label htmlFor="firstName">First Name:</label>
              <input type="text" id="firstName" name="firstName" value={formData.firstName} onChange={handleInputChange} />
              <label htmlFor="lastName">Last Name:</label>
              <input type="text" id="lastName" name="lastName" value={formData.lastName} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label htmlFor="middleName">Middle Name:</label>
              <input type="text" id="middleName" name="middleName" value={formData.middleName} onChange={handleInputChange} />
              <label htmlFor="gender">Gender:</label>
              <select id="gender" name="gender" value={formData.gender} onChange={handleInputChange}>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
              </select>
            </div>
            <div className="form-group">
              <label htmlFor="address">Address:</label>
              <textarea id="address" name="address" value={formData.address} onChange={handleInputChange}></textarea>
              <label htmlFor="mobileNum">Mobile Number:</label>
              <input type="text" id="mobileNum" name="mobileNum" value={formData.mobileNum} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label htmlFor="dateOfBirth">Date of Birth:</label>
              <input type="date" id="dateOfBirth" name="dateOfBirth" value={formData.dateOfBirth} onChange={handleInputChange} />
            </div>
            <div className="button-group">
              <button type="button" onClick={handleSave}>Save</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}
export default UserProfile;
