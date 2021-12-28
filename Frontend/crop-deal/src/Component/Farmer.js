import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import './Farmer.css'

class Farmer extends Component {
    render() {
        return (
            <div className='farmer'>
                {/* logo */}
                <Link to="/farmer">
                    <img className='farmer_logo' src='https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Big_Bazaar_Logo.svg/1280px-Big_Bazaar_Logo.svg.png' alt='Something went wrong'></img>
                </Link>
                {/* adding cropdetails */}
                <Link  to="/add">
                    <div className='header_option'>
                        <span className='headerLine_Two'>Add Crops</span>
                    </div>
                </Link>

                <Link  to="/profile">
                    <div className='header_option'>
                        <span className='headerLine_Two'>Profile</span>
                    </div>
                </Link>
            </div>
        )
    }
}

export default Farmer
