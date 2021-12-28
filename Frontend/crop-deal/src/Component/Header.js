import React from 'react'
import { Link } from 'react-router-dom'
import SearchIcon from '@material-ui/icons/Search'
import ShoppingBasketIcon from '@material-ui/icons/ShoppingBasket'
import './Header.css'
import {useStateValue} from './StateProvider'

function Header() {

    const [{ basket }] = useStateValue();

    console.log(basket);

    return (
        <nav className='header'>
            {/* Logo on the left */}
            <Link to="/">
                <img className='header_logo' src='https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Big_Bazaar_Logo.svg/1280px-Big_Bazaar_Logo.svg.png' alt='Something went wrong'></img>
            </Link>

            {/* Search bar */}
            <div className='search'>
                <input type="text" className='searchInput' placeholder='What would you like to buy today?'/>
                <SearchIcon className='searchIcon' />
            </div>

            {/* Links */}
            <div className='links'>
                {/* 1st Link */}
                <Link to="/login" className="header_link">
                    <div className='header_option'>
                        <span className='headerLine_One'>Login /</span>
                        <span className='headerLine_Two'>Sign In</span>
                    </div>
                </Link>

                {/* 2nd Link */}
                <Link to="/orders" className="header_link">
                    <div className='header_option'>
                        <span className='headerLine_One'>Your</span>
                        <span className='headerLine_Two'>Orders</span>
                    </div>
                </Link>

                {/* 3rd link */}
                <Link to="/checkout" className='header_link'>
                    <div className='header_Basket'>
                        {/* Basket Icon */}
                        <ShoppingBasketIcon />
                        {/* Number of items in the Basket */}
                        <span className='headerLine_Two BasketCount'>{basket.length}</span>
                    </div>
                </Link>
            </div>
        </nav>
    )
}

export default Header
