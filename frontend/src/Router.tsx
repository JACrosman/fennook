import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import { HomePage } from './pages/home/Home.page';
import MainLayout from './layout/MainLayout';
import { LoginPage } from './pages/auth/login/Login.page';

const router = createBrowserRouter([
  {
    path: '/',
    element: <HomePage />,
  },
  {
    path: '/login',
    element: <LoginPage />,
  },
]);

// const router = createBrowserRouter([
//   {
//     path: '/',
//     element: <MainLayout />,
//     children: [
//       {
//         index: true,
//         element: <HomePage />
//       }
//     ]
//   },
//   {
//     path: '/auth',
//     children: [
//       {
//         path: 'login',
//         async lazy() {
//           const { LoginPage } = await import("./pages/auth/login/Login.page");
//           return { Component: LoginPage };
//         }
//       }
//     ]
//   }
// ]);

export function Router() {
  return <RouterProvider router={router} />;
}
