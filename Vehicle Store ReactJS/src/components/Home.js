import { Link } from '@material-ui/core';
import React from 'react'
import styled from "styled-components";
import Section from './Section';


function Home() {
    return (
        
            <Container>
                <Section 
                    title="RANGER"
                    description="Order Online for Touchless Delivery"
                    backgroundImg="20.jpeg"
                    leftBtnText="Custom order"
                    rightBtnText="Existing inventory"
                />
                <Section 
                    title="RAPTOR"
                    description="Order Online for Touchless Delivery"
                    backgroundImg="9.jpeg"
                    leftBtnText="Custom order"
                    rightBtnText="Existing inventory"
                
                />
                <Section 
                    title="TACOMA"
                    description="Order Online for Touchless Delivery"
                    backgroundImg="19.jpeg"
                    leftBtnText="Custom order"
                    rightBtnText="Existing inventory" 
                     
                />
                <Section 
                    title="HILUX"
                    description="Order Online for Touchless Delivery"
                    backgroundImg="6.jpeg"
                    leftBtnText="Custom order"
                    rightBtnText="Existing inventory"
                 
                />
                
            </Container>
            
    )
}

export default Home

const Container = styled.div`
       height: 100vh;
`