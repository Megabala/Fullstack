// OurServices.js
import React from 'react';
import './Ourservices.css'; // Import CSS file for styling
import ServiceImage from './ServiceImage'; // Import the ServiceImage component
import serviceback from './assets/serviceback.webp';
function OurServices() {
  // Sample data for the cards
  const servicesData = [
    { id: 1, title: 'Service 1', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service1.jpg' },
    { id: 2, title: 'Service 2', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service2.jpg' },
    { id: 3, title: 'Service 3', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service3.jpg' },
    { id: 1, title: 'Service 1', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service1.jpg' },
    { id: 2, title: 'Service 2', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service2.jpg' },
    { id: 3, title: 'Service 3', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service3.jpg' },
   
    { id: 1, title: 'Service 1', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service1.jpg' },
    { id: 2, title: 'Service 2', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service2.jpg' },
    { id: 3, title: 'Service 3', description: 'Every year, trees grow two annual rings. In the spring, the usually wider and thinner-walled layer, called springwood, grows.', imageUrl: 'service3.jpg' },
   
    
  ];

  return (
    <div className="services-container">
      <ServiceImage />
      <div className="services-content">
        {servicesData.map(service => (
          <div key={service.id} className="card">
            <img src={serviceback} alt={service.title}/>
            <h2>{service.title}</h2>
            <p>{service.description}</p>
            <button>Read More</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default OurServices;
