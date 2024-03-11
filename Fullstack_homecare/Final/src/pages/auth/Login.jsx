import  { useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faUser, faLock } from '@fortawesome/free-solid-svg-icons';
import './../../assets/css/Login.css';
import {register} from './../../services/auth';
import { useNavigate } from 'react-router-dom';
import {  useDispatch } from 'react-redux';
import { jwtDecode } from 'jwt-decode';
import {login} from './../../services/auth';
import {setAuthentication , setToken,setUser} from './../../redux/authSlice';
// import { Provider } from 'react-redux';

// import { Link } from "react-router-dom";
const Login = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [loginData, setLoginData] = useState({
    email: '',
    password: '',
  });

  const [signupData, setSignupData] = useState({
    name: '',
    email: '',
    password: '',
    role:'USER'
  });

  // const [loginErrors, setLoginErrors] = useState({});
  const [signupErrors, setSignupErrors] = useState({});

  const handleLoginChange = (e) => {
    const { name, value } = e.target;
    setLoginData({ ...loginData, [name]: value });
  };

  const handleSignupChange = (e) => {
    const { name, value } = e.target;
    setSignupData({ ...signupData, [name]: value });
  };

  // const validateLogin = () => {
  //   const errors = {};

  //   if (!/^\S+@\S+\.\S+$/.test(loginData.email)) {
  //     errors.email = 'Invalid email address';
  //   }

  //   if (loginData.password.length < 6) {
  //     errors.password = 'Password must be at least 6 characters long';
  //   }

  //   setLoginErrors(errors);
  //   return Object.keys(errors).length === 0;
  // };

  const validateSignup = () => {
    const errors = {};

    if (!signupData.name.trim()) {
      errors.name = 'name is required';
    }

    if (!/^\S+@\S+\.\S+$/.test(signupData.email)) {
      errors.email = 'Invalid email address';
    }

    if (signupData.password.length < 6) {
      errors.password = 'Password must be at least 6 characters long';
    }

    setSignupErrors(errors);
    return Object.keys(errors).length === 0;
  };

 
  const handleLoginSubmit = (e) => {
    e.preventDefault();
    login(loginData).then((res) => {
      if (res?.data?.accessToken) {
          sessionStorage.setItem('token',res?.data?.accessToken);
          sessionStorage.setItem('userEmail', loginData.email); 
          dispatch(setAuthentication(true))
          dispatch(setToken(res?.data?.accessToken));
          dispatch(setUser(jwtDecode(res?.data?.accessToken).role));
          navigate((jwtDecode(res?.data?.accessToken).role === 'USER') ? '/home' : '/adminhome');
      }
  }).catch((err) => console.log(err));
};
  const handleSignupSubmit = (e) => {
    e.preventDefault();
    if (validateSignup()) {
      console.log('Signup form submitted:', signupData);
      register(signupData);
      console.log('Form submitted:', signupData);
      navigate('/login');
    }
    else {
      // Form is not valid, display error messages
      console.log('Form validation failed');
    }
  };

  return (
    <div className="whole">
      <div className="container">
        <input type="checkbox" id="flip" />
        <div className="cover">
          <div className="front">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrpZEneLh1WL_0kpeQEvbvHipkPx22W2hKMg&s" alt="" />
            <div className="text">
              <span className="text-1">Every new friend is a <br /> new adventure</span>
              <span className="text-2">Lets get connected</span>
            </div>
          </div>
          <div className="back">
            <img className="backImg" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrpZEneLh1WL_0kpeQEvbvHipkPx22W2hKMg&s" alt="" />
            <div className="text">
              <span className="text-1">Complete miles of journey <br /> with one step</span>
              <span className="text-2">Lets get started</span>
            </div>
          </div>
        </div>
        <div className="forms">
          <div className="form-content">
            {/* Login Form */}
            <div className="login-form">
              <div className="title">Login</div>
              <form onSubmit={handleLoginSubmit}>
                <div className="input-boxes">
                  <div className="input-box">
                    <FontAwesomeIcon icon={faEnvelope} />
                    <input type="text" name="email" placeholder="Enter your email" value={loginData.email} onChange={handleLoginChange} required />
                  </div>
                  {/* {loginErrors.email && <div className="error">{loginErrors.email}</div>} */}
                  <div className="input-box">
                    <FontAwesomeIcon icon={faLock} />
                    <input type="password" name="password" placeholder="Enter your password" value={loginData.password} onChange={handleLoginChange} required />
                  </div>
                  {/* {loginErrors.password && <div className="error">{loginErrors.password}</div>} */}
                  <div className="text"><a href="#">Forgot password?</a></div>
                  <div className="button input-box">

                    <input type="submit" value="Submit" />
                  
                  </div>
                  <div className="text sign-up-text">Dont have an account? <label htmlFor="flip">Sign up now</label></div>
                </div>
              </form>
            </div>

            {/* Signup Form */}
            <div className="signup-form">
              <div className="title">Signup</div>
              <form onSubmit={handleSignupSubmit}>
                <div className="input-boxes">
                  <div className="input-box">
                    <FontAwesomeIcon icon={faUser} />
                    <input type="text" name="name" placeholder="Enter your name" value={signupData.name} onChange={handleSignupChange} required />
                  </div>
                  {signupErrors.name && <div className="error">{signupErrors.name}</div>}
                  <div className="input-box">
                    <FontAwesomeIcon icon={faEnvelope} />
                    <input type="email" name="email" placeholder="Enter your email" value={signupData.email} onChange={handleSignupChange} required />
                  </div>
                  {signupErrors.email && <div className="error">{signupErrors.email}</div>}
                  <div className="input-box">
                    <FontAwesomeIcon icon={faLock} />
                    <input type="password" name="password" placeholder="Enter your password" value={signupData.password} onChange={handleSignupChange} required />
                  </div>
                  {signupErrors.password && <div className="error">{signupErrors.password}</div>}
                  <div className="button input-box">
                    <input type="submit" value="Submit" />
                  </div>
                  <div className="text sign-up-text">Already have an account? <label htmlFor="flip">Login now</label></div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Login
