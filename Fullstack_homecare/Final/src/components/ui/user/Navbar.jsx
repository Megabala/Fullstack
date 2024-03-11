import React, { useState } from 'react';
import './../../../assets/css/Navbar.css'; // Import CSS file for styling
import logo from './../../../assets/images/logo.png';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBars, faTimes, faUser, faComments, faCog, faBook, faSignOutAlt } from '@fortawesome/free-solid-svg-icons'; // Import specific icons from Font Awesome
import { Link } from 'react-router-dom';
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
          <Link to="/home"className="navbar-link" >Home</Link>
          <Link to="/aboutus" className="navbar-link">About Us</Link>
          <Link to="/ourservices"  className="navbar-link">Our Services</Link>
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
        <Link to="/showbookings" className="sidebar-link"><FontAwesomeIcon icon={faUser} /> Profile</Link>
        <a href="#" className="sidebar-link"><FontAwesomeIcon icon={faComments} /> Testimonials</a>
        <a href="#" className="sidebar-link"><FontAwesomeIcon icon={faCog} /> Settings</a>
        {/* <Link to="/showbookings" className="sidebar-link"><FontAwesomeIcon icon={faBook} />Bookings</Link> */}
        <Link to="/login" className="sidebar-link"><FontAwesomeIcon icon={faSignOutAlt} /> Logout</Link>
      </div>
    </div>
  );
}

export default Navbar;
