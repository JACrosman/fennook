import { MantineProvider } from '@mantine/core';

import { Router } from './Router';
import { theme } from './theme';

import '@mantine/core/styles.css';
import MainLayout from './layout/MainLayout';

function App() {
  return (
    <MantineProvider theme={theme} defaultColorScheme='dark'>
      <Router />
    </MantineProvider>
  );
}

export default App;

