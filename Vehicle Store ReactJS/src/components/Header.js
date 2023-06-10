import React, { useState } from 'react';
import styled from "styled-components";
import MenuIcon from '@material-ui/icons/Menu';
import CloseIcon from '@material-ui/icons/Close';

function Header() {

    const [burgerStatus, setBurgerStatus] = useState(false);

    return (
        <Container>
            <a>
               
                <img src="/images/2.png" alt="teslalogo"  />
                
            </a>

            <Menu>               
                <a href="#"> RANGER </a>
                <a href="#"> RAPTOR </a>
                <a href="#"> TACOMA </a>
                <a href="#"> HILUX </a>
                
            </Menu>
            <RightMenu>
                <a href="#"> Shop </a>
                <a href="#"> Appointment </a>
                <CustomMenu onClick={()=> setBurgerStatus(true) } />
            </RightMenu>
            <BurgerNav show={burgerStatus}>               
                <CloseWrapper>
                    <CustomClose onClick={()=>setBurgerStatus(false)}/>
                </CloseWrapper>
                

                <li><a href="#"> RANGER</a></li>
                <li><a href="#"> RAPTOR</a></li>
                <li><a href="#"> TACOMA</a></li>
                <li><a href="#"> HILUX</a></li>
                <li><a href="#"> Appointment</a></li>
                <li><a href="#"> Trade-In</a></li>
                <li><a href="#"> Spare Parts</a></li>
                <li><a href="#"> Dealers</a></li>
                <li><a href="#"> About Us</a></li>
                <li><a href="#"> Career</a></li>
                <li><a href="#"> Contact</a></li>

            </BurgerNav>

        </Container>

    )
}

export default Header

const Container = styled.div`
    min-height: 60px;
    position: fixed;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding:0 20px;
    top: 0;
    left: 0;
    right: 0;
    z-index: 1;
    background-color: rgb(0.4, 0.4, 0.2, 0.5);
    
    img {
        height: 100px;
        width: 100px;
        
    }

    a {
        color: white;
    }


`
const Menu = styled.div`
    display: flex;
    align-items: center;
    flex: 1;
    justify-content: center;
    

    a {
        font-weight: 550;
        text-transform: uppercase;
        padding: 0 10px;
        flex-wrap: nowrap;
        
    }

    @media(max-width: 769px) {
        display: none;
    }

`
const RightMenu = styled.div`

    display: flex;
    align-items: center;
    

    a {
        font-weight: 600;
        text-transform: uppercase;
        margin-right: 10px;
        flex-wrap: nowrap;
        
    }

`
const CustomMenu = styled(MenuIcon)`
    cursor: pointer;
    
`

const BurgerNav = styled.div`
    position: fixed;
    top: 0;
    bottom: 0;
    right: 0;
    background: white;
    width: 300px;
    z-index: 16;
    list-style: none;
    padding: 20px;
    flex-direction: column;
    transform: ${props => props.show? 'translateX(0%)': 'translateX(100%)'};
    transition: transform 0.2s;
    

    li {
        padding: 15px 0;
        border-bottom: 1px solid rgba(0, 0, 0, 0.2);
        
        a {
            font-weight: 600;
            color: black;
            
        }
    }

`
const CustomClose =  styled(CloseIcon)`
    cursor: pointer;   

`
const CloseWrapper = styled.div`
    display: flex;
    justify-content: flex-end;

`

