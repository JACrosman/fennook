import { useDisclosure } from '@mantine/hooks';
import { AppShell } from '@mantine/core';
import SideNav from './SideNav';

function MainLayout({ children }: React.PropsWithChildren) {
  const [opened, { toggle }] = useDisclosure();

  return (
    <AppShell
      // header={{ height: 70 }}
      navbar={{ width: 300, breakpoint: 'sm', collapsed: { mobile: !opened } }}
      padding='md'
    >
      <AppShell.Navbar>
        <SideNav />
      </AppShell.Navbar>

      <AppShell.Main>{children}</AppShell.Main>
    </AppShell>
  );
}

export default MainLayout;
