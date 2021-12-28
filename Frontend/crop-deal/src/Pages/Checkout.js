import React from 'react'
import {useStateValue} from '../Component/StateProvider'
import { Link } from 'react-router-dom'
import './Checkout.css'
import CheckoutProduct from '../Component/CheckoutProduct';
import Subtotal from '../Component/Subtotal';

function Checkout() {
    const[{basket}] = useStateValue();
    return (
        <div className='checkout'>
            <div className='checkout__left'>
           <img className='checkout_image' src="https://images-na.ssl-images-amazon.com/images/G/01/US-hq/2021/img/Events/Holiday/EpicDailyDeals/LandingPage/HOL21_EDD_Phase5_hero-banner_short_desktop_1500x150.jpg"
           alt="Something went wrong."
           /> 
           {basket?.length === 0 ? (
               <div className='checkout_title'>
                  <h2 >Your Shopping Basket is empty</h2>
                  <p>
                      You have no items in your basket.To buy one or more items,click
                      "Add to basket" next to the item.
                  </p>
               </div>  
           ) :(
               <div className='checkout_title'>
                 <h2>Your Shopping Basket</h2>  
                 {/* List out all the checkout products */}
                 {basket?.map((crops) => (
                    <CheckoutProduct
                    id={crops.cropId}
                    cropType={crops.cropType}
                    cropName= {crops.cropName}
                    price={crops.price}
                    crop_quantity={crops.crop_quantity}
                    uploadedBy={crops.uploadedBy}
                    
                    />
           ))}
                 
               </div>
            
           )}
        </div>
        {basket.length >0 &&(
            <div className='checkout__right'>
                <Subtotal/> 
                <div>
                    <Link to="/">
                        <img className='checkout_ad' src='https://newspaperads.ads2publish.com/wp-content/uploads/2021/06/big-bazaar-shop-for-rupees-1500-and-get-rupees-1000-cash-back-ad-times-of-india-mumbai-29-05-2021.jpg' alt='Something went wrong'></img>
                    </Link>
                </div>
            </div>

            
        )}
        </div>
    );
}

export default Checkout
