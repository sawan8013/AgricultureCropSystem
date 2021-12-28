import axios from 'axios'

const USER_API_BASE_URL ='http://localhost:9100/signup';


 class UserService {
    
    createUsers(user){
        return axios.post(USER_API_BASE_URL, user);
    }

    

}

export default new UserService