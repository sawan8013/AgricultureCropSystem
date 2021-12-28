import React, { Component } from 'react'
import {Navbar, Container} from 'react-bootstrap'
import './Footer.css'


class Footer extends Component {
    
    render() {
        let fullYear = new Date().getFullYear();

        return (
            <Navbar className='footer'> 
                <Container>
                    <div>
                        {fullYear}-{fullYear+1}, All Rights Reserved by Bigbazar
                    </div>
                </Container>
            </Navbar>
        )
    }
}

export default Footer
