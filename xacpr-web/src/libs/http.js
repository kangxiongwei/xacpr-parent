import axios from 'axios';
import env from '../config/env';
const ajaxUrl = env === 'development' ? 'http://localhost:8080' : '';

/**
 * 封装发送post请求的方法
 * @param vm     Vue实例
 * @param url    请求地址，除去域名的后缀
 * @param data   请求参数JSON数据
 * @param params 请求参数K-V数据
 */
const post = async (vm, url, data, params) => {
    return await axios.post(ajaxUrl + url, data, {
        params: params,
        headers: {
            'x-requested-with': 'XMLHttpRequest',
            'Access-Control-Allow-Credentials': 'true'
        }
    }).then(response => {
        if (response != null && response.data.code === 200) {
            return response.data.data;
        } else {
            throw response.data.msg;
        }
    });
};
export {post};