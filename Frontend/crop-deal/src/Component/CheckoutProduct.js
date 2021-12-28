import React from 'react'
import './CheckoutProduct.css'
import {useStateValue} from './StateProvider'

function CheckoutProduct({id,cropType,cropName,price,crop_quantity,uploadedBy}) {
    
    const[,dispatch]=useStateValue();
    
   
    const removeFromBasket=()=>{
     //remove item from basket...
     dispatch({
         type:"REMOVE_FROM_BASKET",
         id:id,
     });

    };

    return (
        <div className='checkoutProduct'>
            <div className='checkout_info'>
                <p><strong>Type: </strong>{cropType}</p>
                <p className='checkout_title'><strong>Name: </strong>{cropName}</p>
                <p className='checkout_price'><strong>Price: </strong>
                    <small>Rs.</small>
                    {price}
                </p>
                <p><strong>Quantity: </strong>{crop_quantity}</p>
                <p><strong>Provided By: </strong>{uploadedBy}</p>   
                <button onClick={removeFromBasket}>Remove</button>
            </div>
        
        </div>
)
}
export default CheckoutProduct
