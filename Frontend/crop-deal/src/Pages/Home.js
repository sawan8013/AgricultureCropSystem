import React, { useEffect, useState } from 'react'
import './Home.css'
import Product from '../Component/Product'
import axios from 'axios';

function Home() {
    const[crop,setCrop]=useState([])
    const [isLoaded, setIsLoaded] = useState(false);
    const[error,setError]= useState(null);

    useEffect(()=>{
        axios.get('http://localhost:9200/api/cropdetails/findAllcropdetails')
        .then(res=>{
            console.log(res)
            setCrop(res.data)
        },
        (error) => {
            setIsLoaded(true);
            setError(error);
        })
    

    },[]);
    if (error) {
        return <>{error.message}</>;
     } 
    // else if (!isLoaded) {
    //     return <>loading...</>;
    // }
    else {
    return (
        <div className='home'>
            <img 
            className='home_image'
            src="https://m.media-amazon.com/images/I/61ASx7NHTWL._SX3000_.jpg"
            alt=""
            />

            {/* Product */}
            <div className='home_row'>
    
            { crop.map(crops=>(
                    <Product 
                    id={crops.cropId}
                    cropType={crops.cropType}
                    cropName= {crops.cropName}
                    price={crops.price}
                    crop_quantity={crops.crop_quantity}
                    uploadedBy={crops.uploadedBy}
                    />

                ))       
                }
            </div>
            {/* Banner */}
            <div>
                <img className='home_image1' 
                    src='https://cms.bigbazaarstore.com/cms/model/7rm/CSW/5kHz/Desktop.jpg' 
                    alt='Something went wrong'></img>
            </div>
        </div>
    )
}
}
export default Home
