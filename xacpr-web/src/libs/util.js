import axios from 'axios';
import env from '../config/env';

let util = {};
util.title = function (title) {
    title = title ? title + ' - Home' : 'CPR系统';
    window.document.title = title;
};

const ajaxUrl = env === 'production' ? 'http://127.0.0.1:8080' : 'http://localhost:8080';

util.ajax = axios.create({
    baseURL: ajaxUrl,
    timeout: 30000
});

export default util;