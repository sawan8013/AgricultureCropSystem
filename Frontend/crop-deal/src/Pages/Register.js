import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import UserService from '../Services/UserService';
import './Register.css';



export class Register extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            userName:'',
            email:'',
            mobileNumber:'',
            pass:'',
            usernameError:'',
            EmailError:'',
            mobileNumberError:'',
            passError:'',
            msg:''
        }

        this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeMobileHandler = this.changeMobileHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.saveUserData = this.saveUserData.bind(this); 
    }

    //validation
    valid(){
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
        if(this.state.userName.length<4 && this.state.email.length<6 && 
          this.state.mobileNumber.length<9 && this.state.pass.length<6){
         this.setState({usernameError:"*Required",
          EmailError: "*Required",
          mobileNumberError:"*Required",
          passError:"*Required",
        })
      }
      else  if(this.state.userName.length<4){
          this.setState({
          usernameError:"Invalid Username"})
          }
      else  if(this.state.email.length<6){
        this.setState({
        EmailError:"Email id is not valid"})
        }
      else  if(!regex.test(this.state.email)){
        this.setState({
        EmailError:"This is not a valid email format!"})
        }
      else  if(this.state.mobileNumber.length<9){
        this.setState({
        mobileNumberError:"Mobile number should be 10 digits"})
        }
      else  if(this.state.pass.length<6){
        this.setState({
        passError:"Password length should be more than 6"})
      }
      else{
        
        return true; 
        }
      
    }

    //for save
    saveUserData=(e)=>{
        e.preventDefault();
        if(this.valid()){
            let user ={userName:this.state.userName, email:this.state.email, mobileNumber:this.state.mobileNumber,  
                pass:this.state.pass};
            console.log('user => ' + JSON.stringify(user));

            UserService.createUsers(user).then(res =>{
                this.setState({
                    msg:"Registration Successful"
                    
                })
                // this.props.history.push('/')      
         })
        }
    }

    changeUserNameHandler=(event)=>{
        this.setState({userName: event.target.value});
    }

    changeEmailHandler=(event)=>{
        this.setState({email: event.target.value});
    }

    changeMobileHandler=(event)=>{
        this.setState({mobileNumber: event.target.value});
    }

    changePasswordHandler=(event)=>{
        this.setState({pass: event.target.value});
    }


    render() {
        return (
            <div className='register1'>
            {/* logo */}
            <Link to="/">
                <img className='register_logo' src='https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Big_Bazaar_Logo.svg/1280px-Big_Bazaar_Logo.svg.png' alt='Something went wrong'></img>
            </Link>

            {/* main form */}
            <div className='register_container'>
                <p style={{color:"green" }}>{this.state.msg}</p>
                <form>
                    <h1>Sign up</h1>
                    <div>
                        {/* phonenumber */}
                        <label className='label'>Phone number</label>
                        <input type="text" name='phonenumber' placeholder='Phone number'
                        value={this.state.mobileNumber} onChange={this.changeMobileHandler}></input>
                        <p style={{color:"red" }}>{this.state.mobileNumberError}</p>
                    </div>
                    <div>
                        {/* name */}
                        <label className='label'>Name</label>
                        <input type="text" name='name' placeholder='Name'
                        value={this.state.userName} onChange={this.changeUserNameHandler}></input>
                        <p style={{color:"red" }}>{this.state.usernameError}</p>
                    </div>
                    <div>
                        {/* email */}
                        <label className='label'>Email</label>
                        <input type="email" name='email' placeholder='Email'
                        value={this.state.email} onChange={this.changeEmailHandler}></input>
                        <p style={{color:"red" }}>{this.state.EmailError}</p>
                    </div>
                    <div>
                        {/* password */}
                        <label className='label'>Password</label>
                        <input type="password" name='password' placeholder='Password'
                        value={this.state.pass} onChange={this.changePasswordHandler}></input>
                        <p style={{color:"red" }}>{this.state.passError}</p>
                    </div>    

                    <button onClick={this.saveUserData} className='register_signup'>Submit</button>
                    <Link to="/login">
                        <button  className='login_signup'>Existing User? Log in</button>
                    </Link>
                </form>
            </div>
            
        </div>

        )
    }
}

export default Register

