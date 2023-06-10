import React from 'react';
import {
  TeamContainer,
  TeamWrapper,
  TeamsHeading,
  TeamTitle,
  TeamCard,
  TeamImg,
  TeamInfo,
  TeamDesc,
  
} from './TeamsElements';

const Products = ({ heading, data }) => {
  return (
    <TeamContainer>
      <TeamsHeading>{heading}</TeamsHeading>
      <TeamWrapper>
        {data.map((team, index) => {
          return (
            <TeamCard key={index}>
              <TeamImg src={team.img} alt={team.alt} />

              <TeamInfo>
    
                <TeamTitle>{team.name}</TeamTitle>
                <TeamDesc>{team.desc}</TeamDesc>
                  
              </TeamInfo>
            </TeamCard>
          );
        })}
      </TeamWrapper>
    </TeamContainer>
  );
};

export default Products;
