import "./../../assets/css/LazyLoad.css"
import PropTypes from 'prop-types';
import { Suspense } from 'react';
import load from './../../assets/others/load.jpeg';

const LazyLayout = ({ component: Component, ...rest }) => {
  return (
    <Suspense fallback={<img src={load} alt="Loading" id ="load_ani"/>}>
      <Component {...rest} />
    </Suspense>
  );
};

LazyLayout.propTypes = {
  component: PropTypes.elementType.isRequired,
};

export default LazyLayout;
