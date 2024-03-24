import axios from "../configs/axios-config";

const CLIENT_API_BASE_URL = (process.env.REACT_APP_BACK || "http://localhost:8080") + "/api/v1";
class ClientService {
    create(client) {
        return axios.post(`${CLIENT_API_BASE_URL}/customers`, client);
    }

    getAll() {
        return axios.get(`${CLIENT_API_BASE_URL}/customers`, )
    }

    getById(id) {
        return axios.get(`${CLIENT_API_BASE_URL}/customers/${id}`);
    }

}

export default new ClientService();