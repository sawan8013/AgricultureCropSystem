import React, { Component } from 'react'
import { Link } from 'react-router-dom'

 class Profile extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            Name:'',
            Email:'',
            PhoneNumber:'',
            Location:'',
            Bio:'',
            Occupation:'',
            usernameError:'',
            EmailError:'',
            mobileNumberError:'',
            msg:''
        }

        this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeMobileHandler = this.changeMobileHandler.bind(this);
        this.changeLocationHandler = this.changeLocationHandler.bind(this);
        this.changeBioHandler = this.changeBioHandler.bind(this);
        this.changeOccupationHandler = this.changeOccupationHandler.bind(this);
        this.saveUserData = this.saveUserData.bind(this); 
    }

    //validation
    valid(){
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
        if(this.state.Name.length<4 && this.state.Email.length<6 && 
          this.state.PhoneNumber.length<9){
         this.setState({usernameError:"*Required",
          EmailError: "*Required",
          mobileNumberError:"*Required",
        })
      }
      else  if(this.state.Name.length<4){
          this.setState({
          usernameError:"Invalid Username"})
          }
      else  if(this.state.Email.length<6){
        this.setState({
        EmailError:"Email id is not valid"})
        }
      else  if(!regex.test(this.state.Email)){
        this.setState({
        EmailError:"This is not a valid email format!"})
        }
      else  if(this.state.PhoneNumber.length<9){
        this.setState({
        mobileNumberError:"Mobile number should be 10 digits"})
        }
      else{
        
        return true; 
        }
      
    }

    //for save
    saveUserData=(e)=>{
        e.preventDefault();
        if(this.valid()){
            let user ={Name:this.state.Name, Email:this.state.Email, PhoneNumber:this.state.PhoneNumber,  
                Location:this.state.Location, Bio:this.state.Bio, Occupation:this.state.Occupation};
            console.log('user => ' + JSON.stringify(user));
        }
    }

    changeUserNameHandler=(event)=>{
        this.setState({Name: event.target.value});
    }

    changeEmailHandler=(event)=>{
        this.setState({Email: event.target.value});
    }

    changeMobileHandler=(event)=>{
        this.setState({PhoneNumber: event.target.value});
    }

    changeLocationHandler=(event)=>{
        this.setState({Location: event.target.value});
    }

    changeBioHandler=(event)=>{
        this.setState({Bio: event.target.value});
    }

    changeOccupationHandler=(event)=>{
        this.setState({Occupation: event.target.value});
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
                        <h1>Edit your public profile</h1>
                        <p style={{color:"green" }}>{this.state.msg}</p>

                        <div>
                            {/* Name */}
                            <label className='label'> Name 
                                <label className='errMsg' style={{color:"red" }}> {this.state.usernameError}</label>
                            </label>
                            <input type="text" name='Name' placeholder='Name'  
                            value={this.state.Name} onChange={this.changeUserNameHandler}
                            ></input>
                            
                        </div>
                        <div>
                            {/* Email */}
                            <label className='label'>Email
                                <label className='errMsg' style={{color:"red" }}> {this.state.EmailError}</label>
                            </label>
                            <input type="email" name='email' placeholder='Email'
                            value={this.state.Email} onChange={this.changeEmailHandler}
                            ></input>
                            
                        </div>
                        <div>
                            {/* Phone Number */}
                            <label className='label'>Phone Number
                                <label className='errMsg' style={{color:"red" }}> {this.state.mobileNumberError}</label>
                            </label>
                            <input type="text" name='number' placeholder='Mobile number'
                            value={this.state.PhoneNumber} onChange={this.changeMobileHandler}
                            ></input>
                            
                        </div>
                        <div>
                            {/* Location */}
                            <label className='label'>Location
                                
                            </label>
                            <input type="text" name='Location' placeholder='Location'
                            value={this.state.Location} onChange={this.changeLocationHandler}
                            ></input>
                            
                        </div> 

                        <div>
                            {/* Bio */}
                            <label className='label'>Bio (optional)
                                
                            </label>
                            <input type="text" name='Bio' placeholder='Share a little something about you'
                            value={this.state.Bio} onChange={this.changeBioHandler}
                            ></input>
                            
                        </div>  

                        <div>
                            {/* Occupation */}
                            <label className='label'>Occupation (optional)
                                
                            </label>
                            <input type="text" name='Occupation' placeholder='Share your current job'
                            value={this.state.Occupation} onChange={this.changeOccupationHandler}
                            ></input>
                            
                        </div>    

                        <button onClick={this.saveUserData} className='crop_submit'>Submit</button>
                        <Link to="/farmer">
                            <button className='crop_cancel'>Cancel</button>
                        </Link>
                        
                    </form>
                </div>
                
            </div>
        )
    }
}

export default Profile
