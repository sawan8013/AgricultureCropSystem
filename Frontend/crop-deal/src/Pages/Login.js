import React from 'react'
import { Link } from 'react-router-dom'
import './Login.css'

function Login() {

    const login = event => {
        event.preventDefault(); //this stop the refresh!!!
    }


    return (
        <div className='login'>
            {/* logo */}
            <Link to="/">
                <img className='login_logo' src='https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Big_Bazaar_Logo.svg/1280px-Big_Bazaar_Logo.svg.png' alt='Something went wrong'></img>
            </Link>

            <div className='login_container'>
                <h1>Sign in</h1>
                <form>
                    <h5>Username</h5>
                    <input type="text" />
                    <h5>Password</h5>
                    <input type="password" />
                    <button onClick={login} type='submit' className='login_signin'>Sign in</button>

                    <p>By continuing, I accept TCP-bigbazar’s Terms and Conditions and Privacy Policy.</p>

                    <Link to="/register">
                        <button  className='login_signup'>New User? Create your Account</button>
                    </Link>
                </form>
            </div>


        </div>
    )
}

export default Login
