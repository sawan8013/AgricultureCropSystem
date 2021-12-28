
import axios from 'axios'

//crop url
const CROP_API_BASE_URL ='http://localhost:8087/api/cropdetails/savecropdetails';
const CROP_GET_ALL_BASE_URL ='http://localhost:8087/api/cropdetails/findAllcropdetails';
const CROP_GET_BY_ID_BASE_URL ='http://localhost:8087/api/cropdetails/findAllCropDetails';
const CROP_UPDATE_BY_ID_BASE_URL ='http://localhost:8087/api/cropdetails/update';
const CROP_DELETE_BY_ID_BASE_URL ='http://localhost:8087/api/cropdetails/delete';
const GET_CROP_BY_NAME_BASE_URL ='http://localhost:9200/api/cropdetails/findAllCrops/cropName';



//cart url
const CART_API_BASE_URL ='http://localhost:8088/api/cart/saveCartdetails';


 class UploadInfo {
     //crop method
    getCrops(){
        return axios.get(CROP_GET_ALL_BASE_URL);
    }
 
    createCrop(crop){
        return axios.post(CROP_API_BASE_URL, crop);
    }

    getCropById(cropID){
        return axios.get(CROP_GET_BY_ID_BASE_URL + '/'+cropID);
        // return axios.get(`http://localhost:8087/api/cropdetails/findAllCropDetails/{cropID}`);
    }

    updateCrop(crop,cropID){
        return axios.put(CROP_UPDATE_BY_ID_BASE_URL +'/'+cropID,crop);
    }
    deleteCropById(cropID){
        return axios.delete(CROP_DELETE_BY_ID_BASE_URL + '/'+cropID);
    }

    getCropByName(crop,cropName){
        return axios.get(GET_CROP_BY_NAME_BASE_URL+'/'+cropName, crop);
    }



    //cart
    createCart(crop){
        return axios.post(CART_API_BASE_URL, crop);
    }

}

export default new UploadInfo
