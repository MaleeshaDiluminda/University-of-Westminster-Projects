import React from 'react';
import {
  FaFacebook,
  FaInstagram,
  FaYoutube,
  FaTwitter,
  FaLinkedin
} from 'react-icons/fa';
import {
  FooterContainer,
  FooterWrap,
  SocialMedia,
  SocialMediaWrap,
  SocialLogo,
  SocialIcons,
  SocialIconLink
} from './FooterElements';

const Footer = () => {
  return (
    <FooterContainer>
      <FooterWrap>
        <SocialMedia>
          <SocialMediaWrap>
            <SocialLogo to='/'>Major League Baseball</SocialLogo>
            <SocialIcons>
              <SocialIconLink href='https://www.facebook.com/mlb' target='_blank' aria-label='Facebook'>
                <FaFacebook />
              </SocialIconLink>
              <SocialIconLink href='https://www.instagram.com/mlb/' target='_blank' aria-label='Instagram'>
                <FaInstagram />
              </SocialIconLink>
              <SocialIconLink href='https://www.youtube.com/channel/UCoLrcjPV5PbUrUyXq5mjc_A' target='_blank' aria-label='Youtube'>
                <FaYoutube />
              </SocialIconLink>
              <SocialIconLink
                href='https://twitter.com/mlb?lang=en' target='_blank' aria-label='Twitter' rel='noopener noreferrer' >
                <FaTwitter />
              </SocialIconLink>
              
            </SocialIcons>
          </SocialMediaWrap>
        </SocialMedia>
      </FooterWrap>
    </FooterContainer>
  );
};

export default Footer;
