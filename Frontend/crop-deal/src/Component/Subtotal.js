import React from 'react'
import './Subtotal.css'
import CurrencyFormat from "react-currency-format";
import {useStateValue} from './StateProvider'
import {getBasketTotal} from './Reducer';


function Subtotal() {
    const [{basket},dispatch] = useStateValue(); 
    return (
        <div className='subtotal'>
            {/* Price */}
            <CurrencyFormat
                renderText = {(value) =>(
                    <>
                        <p>
                            Subtotal({basket.length} items): <strong>{`${value}`}</strong>
                        </p>
                    </>
                )}
                decimalScale={2}
                value={getBasketTotal(basket)}
                displayType={"text"}
                thousandSeparator={true}
                prefix={"Rs."}
            />
            <a href='http://localhost:8081/paymentDetails'>
                <button>Proceed to Checkout</button>
            </a>
            
        </div>
    )
}

export default Subtotal
