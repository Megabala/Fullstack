import { useState, useEffect } from 'react';
import { FaUserEdit, FaUserMinus } from 'react-icons/fa';
import './../../assets/css/AdminService.css';
import { addService, viewService, editService, deleteService } from './../../services/admin';

const AdminService = () => {
  const [showForm, setShowForm] = useState(false);
  const [formData, setFormData] = useState({
    amount: 0,
    availability: true,
    description: '',
    duration: '',
    service_name: ''
  });
  const [serviceData, setServiceData] = useState([]);
  const [editingServiceId, setEditingServiceId] = useState(null); // Track the service being edited
  const [searchQuery, setSearchQuery] = useState('');

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response = await viewService();
        setServiceData(response.data.services || []);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };

    fetchUserData();
  }, []);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (editingServiceId) {
      // If editingServiceId is present, it means we are editing an existing service
      try {
        console.log('Edit User Form Data:', formData);
        console.log(editingServiceId);
        await editService(editingServiceId, formData); // Use editingServiceId to edit the service
        resetForm();
      } catch (error) {
        console.error('Error editing service:', error);
      }
    } else {
      // Otherwise, it's a new service to be added
      try {

        console.log('Add User Form Data:', formData);
        await addService(formData);
        resetForm();
      } catch (error) {
        console.error('Error adding service:', error);
      }
    }
  };

  const resetForm = () => {
    setFormData({
      amount: 0,
      availability: true,
      description: '',
      duration: '',
      service_name: ''
    });
    setShowForm(false);
    setEditingServiceId(null); // Reset editingServiceId after form submission
  };

  const handleEditClick = (serviceId) => {
    const serviceToEdit = serviceData.find(service => service.service_id === serviceId);
    if (serviceToEdit) {
      const formDataWithoutId = {
        amount: serviceToEdit.amount,
        availability: serviceToEdit.availability,
        description: serviceToEdit.description,
        duration: serviceToEdit.duration,
        service_name: serviceToEdit.service_name
      }; // Populate form data without service_id
      setFormData(formDataWithoutId);
      setShowForm(true);
      setEditingServiceId(serviceId.toString());  // Set the editingServiceId
    }
  };

  const handleDeleteClick = async (serviceIdToDelete) => {
    try {

      console.log(serviceIdToDelete);
      await deleteService(serviceIdToDelete);


    } catch (error) {
      console.error('Error deleting service:', error);
    }
  };

  // Function to handle search input change
  const handleSearchInputChange = (e) => {
    setSearchQuery(e.target.value);
  };

  // Filter the serviceData based on the search query
  const filteredServiceData = serviceData.filter(service => {
    return service.service_name.toLowerCase().includes(searchQuery.toLowerCase());
  });

  return (
    <div className="customer-admin-service-container">
      <p className="customer-service-management-title">Services Management</p>
      <br />
      <div className="customer-search-bar">
        <input type="text" className="customer-search-input" placeholder="Search..." value={searchQuery} onChange={handleSearchInputChange} />
        <button className="customer-add-service-btn" onClick={() => setShowForm(true)}>Add Service</button>
      </div>
      <br />
      <br />
      <table className="customer-service-table">
        <thead>
          <tr>
            <th>Service ID</th>
            <th>Service Name</th>
            <th>Service Description</th>
            <th>Amount</th>
            <th>Duration</th>
            <th>Availability</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {filteredServiceData.map((service, index) => (
            <tr key={index}>
              <td>{service.service_id}</td>
              <td>{service.service_name}</td>
              <td>{service.description}</td>
              <td>{service.amount}</td>
              <td>{service.duration}</td>
              <td>{service.availability ? 'Available' : 'Not Available'}</td>
              <td><button onClick={() => handleEditClick(service.service_id)}><FaUserEdit size={30} /></button></td>
              <td><button onClick={() => handleDeleteClick(service.service_id)}><FaUserMinus size={30} /></button></td>
            </tr>
          ))}
        </tbody>
      </table>
      {showForm && (
        <div className="customer-add-service-form">
          <div className="customer-add-service-form-content">
            <span className="customer-close" onClick={() => setShowForm(false)}>×</span>
            <form onSubmit={handleSubmit}>
              <label>
                Service Name:
                <input type="text" name="service_name" value={formData.service_name} onChange={handleInputChange} />
              </label>
              <label>
                Description:
                <textarea name="description" value={formData.description} onChange={handleInputChange}></textarea>
              </label>
              <label>
                Amount:
                <input type="text" name="amount" value={formData.amount} onChange={handleInputChange} />
              </label>
              <label>
                Duration:
                <input type="text" name="duration" value={formData.duration} onChange={handleInputChange} />
              </label>
              <label>
                Availability:
                <select name="availability" value={formData.availability} onChange={handleInputChange}>
                  <option value={true}>Available</option>
                  <option value={false}>Not Available</option>
                </select>
              </label>
              <button type="submit">Submit</button>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};

export default AdminService;
