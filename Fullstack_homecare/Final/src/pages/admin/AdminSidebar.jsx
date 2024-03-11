import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faChartLine, faUser, faBook, faCogs, faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import '../../assets/css/AdminSidebar.css';
import { Link } from 'react-router-dom';

function AdminSidebar() {
  return (
    <div className="admin-sidebar">
      <Link to="/adminhome" className="admin-sidebar-item">
        <FontAwesomeIcon icon={faChartLine} />
        Dashboard
      </Link>
      {/* <Link to="/adminuser" className="admin-sidebar-item">
        <FontAwesomeIcon icon={faUser} />
        User
      </Link> */}
      <Link to="/bookings" className="admin-sidebar-item">
        <FontAwesomeIcon icon={faBook} />
        Bookings
      </Link>
      <Link to="/adminservice" className="admin-sidebar-item">
        <FontAwesomeIcon icon={faCogs} />
        Services
      </Link>
      <Link to="/login" className="admin-sidebar-item">
        <FontAwesomeIcon icon={faSignOutAlt} />
        Logout
      </Link>
    </div>
  );
}

export default AdminSidebar;
