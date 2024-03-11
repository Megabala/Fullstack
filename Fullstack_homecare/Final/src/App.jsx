// App.js
// import React from 'react';
import LazyLayout from "./components/ui/LazyLayout";
import { lazy } from "react";
import {Navigate, BrowserRouter , Routes,Route } from 'react-router-dom';
import { UserLayout } from "./pages/user/UserLayout";
import {AdminLayout} from "./pages/admin/AdminLayout";
//  import Navbar from './components/ui/user/Navbar';
// import Home from './pages/user/Home';
// import UserProfile from './pages/user/UserProfile'; // Assuming you have a UserProfile component
// import Footer from './components/ui/user/Footer';
// import Ourservices from './pages/user/Ourservices';
// import ServicePage from './pages/user/ServicePage';
// import BookForm from './pages/user/BookForm';
// import Aboutus from './pages/user/Aboutus';
//  import Login from './pages/auth/Login'
//  import AdminSidebar from './pages/admin/AdminSidebar'
const LazyLogin = lazy(() => import("./pages/auth/Login"));
const LazyHome = lazy(() => import("./pages/user/Home"));
const LazyOurServices=lazy(()=>import('./pages/user/Ourservices'));
const LazyAboutUs =lazy(()=>import('./pages/user/Aboutus'));
const LazyAdminHome =lazy(()=>import('./pages/admin/AdminHome'));
const LazyAdminUser =lazy(()=>import('./pages/admin/AdminUser'));
const LazyAdminService=lazy(()=>import('./pages/admin/AdminService'));
const LazyBookForm=lazy(()=>import('./pages/user/BookForm'));
const LazyAdminBookings=lazy(()=>import('./pages/admin/AdminBooking'));
const LazyUserBookings=lazy(()=>import('./pages/user/Bookingsdisplay'));
// import Payment from './Payment';
function App() {
  return (
  <BrowserRouter>
  <Routes>
  <Route exact path="/" element={<Navigate to="/login" />} />
  <Route
          path="/login"
          element={<LazyLayout component={LazyLogin} />}
        />
  <Route
          path="/home"
          element={<UserLayout><LazyLayout component={LazyHome} /></UserLayout>}
        ></Route>
  <Route
          path="/ourservices"
          element={<UserLayout><LazyLayout component={LazyOurServices} /></UserLayout>}
          ></Route>
  <Route
          path="/booknow"
          element={<UserLayout><LazyLayout component={LazyBookForm} /></UserLayout>}
          ></Route>
  <Route
          path="/aboutus"
          element={<UserLayout><LazyLayout component={LazyAboutUs} /></UserLayout>}
          ></Route>
  <Route
          path="/showbookings"
          element={<LazyLayout component={LazyUserBookings} />}
          ></Route>
  <Route
          path="/adminhome"
          element={
            <AdminLayout>
              <LazyLayout component={LazyAdminHome} />
            </AdminLayout>
          }
        />    
  <Route
          path="/adminuser"
          element={
            <AdminLayout>
              <LazyLayout component={LazyAdminUser} />
            </AdminLayout>
          }
        />    
  <Route
          path="/bookings"
          element={
            <AdminLayout>
              <LazyLayout component={LazyAdminBookings} />
            </AdminLayout>
          }
        />    
  <Route
          path="/adminservice"
          element={
            <AdminLayout>
              <LazyLayout component={LazyAdminService} />
            </AdminLayout>
          }
        />    
          </Routes>

  </BrowserRouter>
  
  );
}

export default App;
