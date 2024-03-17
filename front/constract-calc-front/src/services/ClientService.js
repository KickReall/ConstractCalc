import axios from "../configs/axios-config";

const CLIENT_API_BASE_URL = process.env.REACT_APP_BACK + "/api/v1";
class ClientService {
    create(client) {
        return axios.post(`${CLIENT_API_BASE_URL}/customers`, { client });
    }

    getAll() {
        return axios.get(`${CLIENT_API_BASE_URL}/customers`, )
    }

    getById(id) {
        const params = { id };

        const config = {
            params,
        };

        return axios.get(`${CLIENT_API_BASE_URL}/customers`, config);
    }

}

export default new ClientService();