import { useState } from 'react';
import { FaUserEdit, FaUserMinus } from 'react-icons/fa';
import './../../assets/css/AdminUser.css';
import { viewUser } from './../../services/user';
import { useEffect } from 'react';
const AdminUser = () => {
  const [isAddUserFormVisible, setAddUserFormVisible] = useState(false);
  const [userData, setUserData] = useState([]);
  const handleAddUserClick = () => {
    setAddUserFormVisible(true);
  };

  const handleCloseForm = () => {
    setAddUserFormVisible(false);
  };
  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response = await viewUser();
        console.log(response);
        console.log(response.data.users);
        setUserData(response.data.users || []);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };

    fetchUserData();
  }, []);


  return (
    <div className="admin-user-manage-container">
      <p style={{ color: '#49274a', fontVariant: 'small-caps', fontSize: '30px' }}>User Management</p>
      <br />
      <div className="search-bar">
        <input type="text" placeholder="Search..." />
        <button className="add-user-btn" onClick={handleAddUserClick}>
          Add User
        </button>
      </div>
      <br />
      <br />
      {isAddUserFormVisible && (
        <div className="add-user-form">
          <h2>Add User Form</h2>
          <form>
            <label htmlFor="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required />

            <label htmlFor="userName">User Name:</label>
            <input type="text" id="userName" name="userName" required />

            <label htmlFor="email">Email ID:</label>
            <input type="email" id="email" name="email" required />

            <label htmlFor="phoneNumber">Phone Number:</label>
            <input type="tel" id="phoneNumber" name="phoneNumber" required />
               <div>
              <button type="submit">Add User</button>
              <button type="button" onClick={handleCloseForm}>Close</button>
            </div>
          </form>
        </div>
      )}
      <div className="table-container">
        <table className="user-table">
          <thead>
            <tr>
              <th>User ID</th>
              <th>User Name</th>
              <th>Email ID</th>
              <th>Phone Number</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {userData.map(user => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td>
                  <button>
                    <FaUserEdit size={30} />
                  </button>
                </td>
                <td>
                  <button>
                    <FaUserMinus size={30} />
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default AdminUser;
