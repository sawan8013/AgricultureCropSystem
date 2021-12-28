import React, { Component } from 'react'
import { withRouter } from "react-router-dom";
import './CropList.css'
import UploadInfo from '../Services/CropService'

 class CropList extends Component {
    constructor(props) {
        super(props)

        this.state = {
                crops: [],
                msg:''
        }
        
        this.editCrop = this.editCrop.bind(this);
        this.deleteCrop = this.deleteCrop.bind(this);
    }
    
    editCrop(cropID){
        this.props.history.push({pathname:`/update-data/${cropID}`});
       
    }

    deleteCrop(cropID){
        if(window.confirm('Are you sure to delete this record ?')){
            UploadInfo.deleteCropById(cropID).then(res=>{
                this.setState({crops: this.state.crops.filter(crop=>crop.cropID != cropID)},
                this.setState({
                    msg: "Item Deleted",
                }));
            })
        }
        
    }

    componentDidMount(){
        UploadInfo.getCrops().then((res) => {
            this.setState({ crops: res.data});
        });
    }
    render() {
        return (
            
                <div className='product1'>
                    <h1>Crop List</h1>
                    <p style={{color:"red" }}>{this.state.msg}</p>
                    <table className='crops'>
                        <thead>
                            <th>Crop Name</th>
                            <th>Crop Type</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Uploaded By</th>
                            <th>Actions</th>
                        </thead>
                        <tbody>
                            {
                                this.state.crops.map(c =>
                                    <tr key={c.cropID}>
                                        <td>{c.cropName}</td>
                                        <td>{c.cropType}</td>
                                        <td>{c.crop_quantity}</td>
                                        <td>Rs.{c.price}</td>
                                        <td>{c.uploadedBy}</td>
                                        <td className='button'>
                                            <button onClick={()=>this.editCrop(c.cropID)}  className="update">Update</button>
                                            <button onClick={()=>this.deleteCrop(c.cropID)}className="delete">Delete</button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                {/* // <p><strong>Name:</strong>{c.cropName}</p>
                // <p><strong>Type:</strong>{c.cropType}</p>
                // <p><strong>Quantity:</strong>{c.crop_quantity}</p>
                // <p className='product__price'><strong>Price:Rs</strong>
                //     {c.price}
                // </p>
                
                // <p><strong>Uploaded BY:</strong>{c.uploadedBy}</p> */}
            
                
                {/* <button onClick={()=>this.editCrop(c.cropID)}  className="btn btn-info">Update</button>
                <button style={{marginTop:"10px"}} onClick={()=>this.deleteCrop(c.cropID)}className="btn btn-danger">Delete</button>  */}
            </div>
        )
            
        
    }
}

export default withRouter(CropList)
