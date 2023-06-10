import styled from 'styled-components';

export const TeamContainer = styled.div`
  /* width: 100vw; */
  min-height: 20vh;
  padding: 5rem calc((100vw - 1300px) / 3);
  background:linear-gradient(to right, #090b68 , #fb0101);
  color: white;
`;

export const TeamWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: 0 auto;
`;

export const TeamCard = styled.div`
  margin: 0 2rem;
  line-height: 2;
  width: 300px;
`;

export const TeamImg = styled.img`
  height: 300px;
  min-width: 300px;
  max-width: 100%;
  
 
`;

export const TeamsHeading = styled.h1`
  font-size: clamp(2rem, 2.5vw, 3rem);
  text-align: center;
  margin-bottom: 5rem;
`;

export const TeamTitle = styled.h2`
  font-weight: 400;
  font-size: 1.5rem;
`;

export const TeamInfo = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 2rem;
  text-align: center;
`;

export const TeamDesc = styled.p`
  margin-bottom: 1rem;
`;

