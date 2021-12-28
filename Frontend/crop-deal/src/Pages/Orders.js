import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import './Order.css'

export class Orders extends Component {
    render() {
        return (
            <div className='orders'>
                <div className='order_logo'>
                    <img className='order_image' src="https://m.media-amazon.com/images/I/61DUO0NqyyL._SX3000_.jpg"
                    alt="Something went wrong."
                    /> 

                    <div className='order_heading'>
                        <h2 >Your Orders</h2>
                        <p>
                            You have no orders.
                        </p>
                        <div className='button_div'>
                            <Link to="/">
                                <button className='button1'>Start Shopping</button>
                            </Link>
                        </div>

                        
                    </div>
                </div>
            </div>
        )
    }
}

export default Orders
