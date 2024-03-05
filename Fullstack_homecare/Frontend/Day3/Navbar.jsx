import React, { useState } from 'react';
import './Navbar.css'; // Import CSS file for styling
import logo from './assets/logo.png';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBars, faTimes, faUser, faComments, faCog, faBook, faSignOutAlt } from '@fortawesome/free-solid-svg-icons'; // Import specific icons from Font Awesome

function Navbar() {
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  return (
    <div className="navbar-container">
      <div className="navbar">
        <div className="icon">
          <img src={logo} alt="Logo" style={{ width: '120px', height: '50px' }} />
        </div>
        <div className="navbar-links">
          <a href="#" className="navbar-link">Home</a>
          <a href="#" className="navbar-link">About Us</a>
          <a href="#" className="navbar-link">Our Services</a>
          <a href="#" className="navbar-link">FAQ</a>
          <a href="#" className="navbar-link">Contact</a>
        </div>
        <div className="menu-icon" onClick={toggleSidebar}>
          <FontAwesomeIcon icon={faBars} />
        </div>
      </div>
      {/* Sidebar */}
      <div className={`sidebar ${isSidebarOpen ? 'open' : ''}`}>
        <div className="close-icon" onClick={toggleSidebar}>
          <FontAwesomeIcon icon={faTimes} />
        </div>
        <a href="#" className="sidebar-link"><FontAwesomeIcon icon={faUser} /> Profile</a>
        <a href="#" className="sidebar-link"><FontAwesomeIcon icon={faComments} /> Testimonials</a>
        <a href="#" className="sidebar-link"><FontAwesomeIcon icon={faCog} /> Settings</a>
        <a href="#" className="sidebar-link"><FontAwesomeIcon icon={faBook} /> Bookings</a>
        <a href="#" className="sidebar-link"><FontAwesomeIcon icon={faSignOutAlt} /> Logout</a>
      </div>
    </div>
  );
}

export default Navbar;
