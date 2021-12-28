import React, { Component } from 'react';
import { withRouter } from "react-router-dom";
import { Link, params} from 'react-router-dom';
import UploadInfo from '../Services/CropService';
import './UpdateCropList.css';

 class UpdateCropList extends Component  {
     
    constructor(props){
        super(props)

        this.state={
             
            cropID: this.props.match.params.cropID,     
            cropName: '',
            cropType: '',
            crop_quantity: '',
            price: '',
            uploadedBy: '',
            msg:'',
            priceMsg:'',
            cropNameMsg:'',
            cropTypeMsg:'',
            cropQuantityMsg:'',
            uploadedByMsg:''
        }
        
        
       
        this.changeTypeHandler = this.changeTypeHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);
        this.changeQuantityHandler = this.changeQuantityHandler.bind(this);
        this.changeProviderHandler = this.changeProviderHandler.bind(this);
        this.UpdateData = this.UpdateData.bind(this); 
    }
    componentDidMount(){
        UploadInfo.getCropById(this.state.cropID).then((res)=>{
            //console.log("res");
           let crop = res.data;
           this.setState({
            cropID: crop.cropID,   
            cropName: crop.cropName,
            cropType: crop.cropType,
            crop_quantity: crop.crop_quantity,
            price: crop.price,
            uploadedBy: crop.uploadedBy
        });
       });
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

    //update
    UpdateData=(e)=>{
        e.preventDefault();
        if(this.valid()){
        let crop ={ 
            cropID:this.state.cropID,
            cropName:this.state.cropName, 
            cropType:this.state.cropType, 
            crop_quantity:this.state.crop_quantity, 
            price:this.state.price, 
            uploadedBy:this.state.uploadedBy};
        console.log('crop => ' + JSON.stringify(crop));
        
        UploadInfo.updateCrop(crop, this.state.cropID).then(res=>{
           this.setState({
            msg: "Updated",
        })
        });
    }
        
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
      this.props.history.push('/farmer');
 

    }


    render() {
        return (
            <div>
                <div className='container'>
                    <div className='register'>
                        {/* logo */}
                        <Link to="/farmer">
                            <img className='register_logo' src='https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Big_Bazaar_Logo.svg/1280px-Big_Bazaar_Logo.svg.png' alt='Something went wrong'></img>
                        </Link>
                        <div className='register_container'>
                            <h1 className='text-center'>Update Crop Details</h1>
                            <p style={{color:"green" }}>{this.state.msg}</p>
                            <div className='card-body'>
                                <form>
                                   {/* Crop name */}
                                    <div className = "form-group">
                                            <label className='label'> Crop Name: 
                                                <label className='errMsg' style={{color:"red" }}> {this.state.cropNameMsg}</label>
                                            </label>
                                            <input placeholder="Crop Name" name="cropname" className="form-control" 
                                                value={this.state.cropName} onChange={this.changeNameHandler}/>
                                    </div>
                                    {/* Crop type */}
                                    <div className = "form-group">
                                            <label className='label'> Crop Type:
                                                <label className='errMsg' style={{color:"red" }}> {this.state.cropTypeMsg}</label>
                                             </label>
                                            <input placeholder="Crop Type" name="croptype" className="form-control" 
                                                value={this.state.cropType} onChange={this.changeTypeHandler}/>
                                    </div>
                                    {/* price */}
                                    <div className = "form-group">
                                            <label className='label'> Crop Price: 
                                                <label className='errMsg' style={{color:"red" }}> {this.state.priceMsg}</label>
                                            </label>
                                            <input placeholder="Crop Price" name="cropprice" className="form-control" 
                                                value={this.state.price} onChange={this.changePriceHandler}/>
                                    </div>
                                    {/* quantity */}
                                    <div className = "form-group">
                                            <label className='label'> Crop Quantity: 
                                                <label className='errMsg' style={{color:"red" }}> {this.state.cropQuantityMsg}</label>
                                            </label>
                                            <input placeholder="Crop Quantity" name="cropquantity" className="form-control" 
                                                value={this.state.crop_quantity} onChange={this.changeQuantityHandler}/>
                                    </div>
                                    {/* uploadedBy */}
                                    <div className = "form-group">
                                            <label className='label'> Provider: 
                                                <label className='errMsg' style={{color:"red" }}> {this.state.uploadedByMsg}</label>
                                            </label>
                                            <input placeholder="Provider" name="provider" className="form-control" 
                                                value={this.state.uploadedBy} onChange={this.changeProviderHandler}/>
                                    </div>

                                    <button className="crop_submit" onClick={this.UpdateData}>Save</button>
                                        <button className="crop_cancel" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default withRouter(UpdateCropList)
