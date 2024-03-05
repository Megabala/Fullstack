// ServiceImage.js
import React from 'react';
import serviceback from './assets/serviceback.webp'; // Import the image file
import './ServiceImage.css'; // Import CSS file for styling

function ServiceImage() {
  return (
    <div className="service-image-container">
      <div className="service-text">
        <h1>Services Of Care Coimbatore, Tamilnadu, India</h1>
      </div>
      <img src={serviceback} alt="Service" className="service-image" />
    </div>
  );
}

export default ServiceImage;
