import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import UploadInfo from '../Services/CropService'
import './AddCrops.css'

class AddCrops extends Component {
    constructor(props){
        super(props)
        this.state={
            cropID:'',
            cropName:'',
            cropType:'',
            crop_quantity:'',
            price:'',
            uploadedBy:'',
            msg:'',
            priceMsg:'',
            cropNameMsg:'',
            cropTypeMsg:'',
            cropQuantityMsg:'',
            uploadedByMsg:''

        }

        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeTypeHandler = this.changeTypeHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);
        this.changeQuantityHandler = this.changeQuantityHandler.bind(this);
        this.changeProviderHandler = this.changeProviderHandler.bind(this);
        this.saveOrUpdateData = this.saveOrUpdateData.bind(this); 
    }

    //validation
    valid(){
        
        if(this.state.cropName.length<3 && this.state.cropType.length<1 && 
          this.state.crop_quantity.length<1 && this.state.uploadedBy.length<6 && this.state.price.length<1){
         this.setState({cropNameMsg:"*Required",
         cropTypeMsg: "*Required",
         cropQuantityMsg:"*Required",
         uploadedByMsg:"*Required",
         priceMsg:"*Required",
        })
      }
      else  if(this.state.cropName.length<3){
          this.setState({
            cropNameMsg:"*Required"})
          }
      else  if(this.state.cropType.length<3){
        this.setState({
            cropTypeMsg:"*Required"})
        }
      else  if(this.state.crop_quantity.length<3){
        this.setState({
            cropQuantityMsg:"*Required"})
        }
      else  if(this.state.uploadedBy.length<3){
        this.setState({
            uploadedByMsg:"*Required"})
      }
      else  if(this.state.price <=0 || this.state.price.length<1){
        this.setState({
            priceMsg:"Price Should be more than 0"})
      }
      else{
        
        return true; 
        }
      
    }

    saveOrUpdateData=(e)=>{
        e.preventDefault();
        if(this.valid()){
            let crop ={cropID:this.state.cropID, cropName:this.state.cropName, cropType:this.state.cropType,  
                crop_quantity:this.state.crop_quantity, price:this.state.price,  
                uploadedBy:this.state.uploadedBy};
            console.log('crop => ' + JSON.stringify(crop));

            UploadInfo.createCrop(crop).then(res =>{
                this.setState({
                    msg: "Added Successfully",
                })
                //    this.props.history.push('/');
            });
        }
    }

    changeIdHandler=(event)=>{
        this.setState({cropID: event.target.value});
    }

    changeTypeHandler=(event)=>{
        this.setState({cropType: event.target.value});
    }

    changeNameHandler=(event)=>{
        this.setState({cropName: event.target.value});
    }

    changePriceHandler=(event)=>{
        this.setState({price: event.target.value});
    }

    changeQuantityHandler=(event)=>{
        this.setState({crop_quantity: event.target.value});
    }

    changeProviderHandler=(event)=>{
        this.setState({ uploadedBy: event.target.value});
    }

    cancel(){
        this.props.history.push('/');
    }
    render() {
        return (
            <div className='register'>
                {/* logo */}
                <Link to="/farmer">
                    <img className='register_logo' src='https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Big_Bazaar_Logo.svg/1280px-Big_Bazaar_Logo.svg.png' alt='Something went wrong'></img>
                </Link>

                <div className='register_container'>
                    <form>
                        <h1>Add Crop Details</h1>
                        <p style={{color:"green" }}>{this.state.msg}</p>
                        <div>
                            {/* id */}
                            <label className='label'>ID</label>
                            <input type="text" name='id' placeholder='id'  
                            value={this.state.cropID} onChange={this.changeIdHandler}></input>
                        </div>

                        <div>
                            {/* cropName */}
                            <label className='label'>Crop Name 
                                <label className='errMsg' style={{color:"red" }}> {this.state.cropNameMsg}</label>
                            </label>
                            <input type="text" name='cropName' placeholder='cropName'  
                            value={this.state.cropName} onChange={this.changeNameHandler}></input>
                            
                        </div>
                        <div>
                            {/* cropType */}
                            <label className='label'>Crop Type
                                <label className='errMsg' style={{color:"red" }}> {this.state.cropTypeMsg}</label>
                            </label>
                            <input type="text" name='cropType' placeholder='cropType'
                            value={this.state.cropType} onChange={this.changeTypeHandler}></input>
                            
                        </div>
                        <div>
                            {/* quantity */}
                            <label className='label'>Quantity
                                <label className='errMsg' style={{color:"red" }}> {this.state.cropQuantityMsg}</label>
                            </label>
                            <input type="text" name='quantity' placeholder='quantity'
                            value={this.state.crop_quantity} onChange={this.changeQuantityHandler}></input>
                            
                        </div>
                        <div>
                            {/* price */}
                            <label className='label'>Price
                                <label className='errMsg' style={{color:"red" }}> {this.state.priceMsg}</label>
                            </label>
                            <input type="text" name='price' placeholder='price'
                            value={this.state.price} onChange={this.changePriceHandler}></input>
                            
                        </div> 

                        <div>
                            {/* uploadedBy */}
                            <label className='label'>Uploaded By
                            <label className='errMsg' style={{color:"red" }}> {this.state.uploadedByMsg}</label>
                            </label>
                            <input type="text" name='uploadedBy' placeholder='uploadedBy'
                            value={this.state.uploadedBy} onChange={this.changeProviderHandler}></input>
                            
                        </div>    

                        <button onClick={this.saveOrUpdateData} className='crop_submit'>Submit</button>
                        <Link to="/farmer">
                            <button onClick={this.cancel.bind(this)} className='crop_cancel'>Cancel</button>
                        </Link>
                        
                    </form>
                </div>
                
            </div>
        )
    }
}

export default AddCrops
