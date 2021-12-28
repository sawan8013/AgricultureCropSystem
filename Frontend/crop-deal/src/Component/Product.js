import React from 'react'
import './Product.css'
import {useStateValue} from './StateProvider'

function Product({id,cropType,cropName,price,crop_quantity,uploadedBy}) {

    const[{basket},dispatch]=useStateValue();
    const addToBasket=()=>{
        dispatch({
            type:'ADD_TO_BASKET',
            item:{
            id:id,
            cropName:cropName,
            cropType:cropType,
            crop_quantity:crop_quantity,
            price:price,
            uploadedBy:uploadedBy,
            },
            
        });
        
    }
    return(
    <div className='product'>
        <div className='product_info'>
            <p><strong>Type: </strong>{cropType}</p>
            <p><strong>Name: </strong>{cropName}</p>
            <p className='product__price'><strong>Price: </strong><small>Rs.</small>
                {price}
            </p>
            <p><strong>Quantity: </strong>{crop_quantity}</p>
            <p><strong>Uploaded By :</strong>{uploadedBy}</p>
            <button onClick={addToBasket}>Add to Basket</button>
        </div>
</div>
);
}

export default Product
