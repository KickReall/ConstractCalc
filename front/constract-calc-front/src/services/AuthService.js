import axios from "axios";

const AUTH_API_BASE_URL = process.env.REACT_APP_BACK + "/api/auth";
class AuthService {
    login() {
        return axios.post(`${AUTH_API_BASE_URL}/login`, {withCredentials: true});
    }

    logout() {
        return axios.post(`${AUTH_API_BASE_URL}/logout`, {withCredentials: true})
    }

    refresh() {
        return axios.get(`${AUTH_API_BASE_URL}/refresh`, {withCredentials: true});
    }

}

export default new AuthService();