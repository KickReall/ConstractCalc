import axios from "axios";
import AuthService from "../services/AuthService";


const BaseAxios = axios.create({
    withCredentials: true,
    baseURL: process.env.REACT_APP_BACK
});

BaseAxios.interceptors.request.use((config) => {
    config.headers.Authorization = `Bearer ${localStorage.getItem('token')}`
    return config;
});

BaseAxios.interceptors.response.use(
    (res) => res,
    async (error) => {
        const originalRequest = error?.config;
        if (error.response.status === 401 && error.config && !error.config._isRetry) {
            originalRequest._isRetry = true;
            try {
                const res = await AuthService.refresh();
                localStorage.setItem('token', res.data.accessToken);
                const newData = await BaseAxios.request(originalRequest);
                return Promise.resolve(newData)
            } catch (e) {
                localStorage.removeItem('token');
                window.location.href = '/login';
            }
        }
        return Promise.reject(error)
    }
);