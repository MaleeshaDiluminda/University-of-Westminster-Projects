import React from 'react';
import {
  SidebarContainer,
  Icon,
  CloseIcon,
  SidebarMenu,
  SidebarLink,
  SidebarRoute,
  SideBtnWrap
} from './SidebarElements';

const Sidebar = ({ isOpen, toggle }) => {
  return (
    <SidebarContainer isOpen={isOpen} onClick={toggle}>
      <Icon onClick={toggle}>
        <CloseIcon />
      </Icon>
      <SidebarMenu>
        <SidebarLink to='https://www.mlb.com/news' target='_blank'  aria-label='News'>News</SidebarLink>
        <SidebarLink href='https://www.mlb.com/news' target='_blank'  aria-label='News'>Standings</SidebarLink>
        <SidebarLink href='https://www.mlb.com/news' target='_blank'  aria-label='News'>Players</SidebarLink>
        <SidebarLink href='https://www.mlb.com/news'target='_blank'  aria-label='News'>History</SidebarLink>
      </SidebarMenu>
      <SideBtnWrap>
        <SidebarRoute href='/https://www.mlb.com/news'>Tickets</SidebarRoute>
      </SideBtnWrap>
    </SidebarContainer>
  );
};

export default Sidebar;
